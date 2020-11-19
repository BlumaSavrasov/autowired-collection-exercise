package autowird_collection;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class MassageService {
    @AutowiredCollection({Telegram.class,WhatsApp.class})
    List<Message> messages;

    @PostConstruct
    void setMessages(){
        messages.forEach(Message::sendMessage);
    }
}
