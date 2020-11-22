package autowird_collection;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService {
    @AutowiredCollection({Telegram.class,WhatsApp.class})
    List<Message> messages;


     public void sendMessages(){
        messages.forEach(Message::sendMessage);
    }
}
