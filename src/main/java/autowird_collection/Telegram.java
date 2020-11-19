package autowird_collection;

import org.springframework.stereotype.Component;

@Component
public class Telegram implements Message {
    @Override
    public void sendMessage() {
        System.out.println("sending telegram");
    }
}
