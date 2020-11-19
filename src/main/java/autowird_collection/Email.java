package autowird_collection;

import org.springframework.stereotype.Component;

@Component
public class Email implements Message {
    @Override
    public void sendMessage() {
        System.out.println("sending email");
    }
}
