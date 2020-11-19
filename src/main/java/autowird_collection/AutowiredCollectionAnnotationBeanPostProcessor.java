package autowird_collection;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class AutowiredCollectionAnnotationBeanPostProcessor implements BeanPostProcessor {


        @SneakyThrows
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            Set<Field> fields = ReflectionUtils.getAllFields(bean.getClass(), field -> field.isAnnotationPresent(AutowiredCollection.class));
            for (Field field : fields) {
                List<Object> classesInstances =new ArrayList<>();
                AutowiredCollection annotation = field.getAnnotation(AutowiredCollection.class);
                Class<?>[] classes = annotation.value();
                for (Class<?> aClass:classes) {
                    classesInstances.add(aClass.getDeclaredConstructor().newInstance());
                }
                field.setAccessible(true);
                field.set(bean,classesInstances);
            }
            return bean;
        }
}
