package pl.edu.utp.jobfinder.generator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.edu.utp.jobfinder.generator.data.DataValues;
import pl.edu.utp.jobfinder.model.Message;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
public class MessageGenerator extends AbstractGenerator {

    // Constructors
    public MessageGenerator() {
        super();
    }
    
    // TODO: Test messages generator
    // TODO: Comments
    public List<Message> generateMessages(int amount) {
        List<Message> messages = new ArrayList<>();
        
        for (int i = 0; i < amount; i++) {
            Message message = new Message();
            
            message.setContent(sentenceGenerator(DataValues.getWords(), 5, 20));
            message.setIsReaded(random.nextBoolean());
            message.setDate(dateObjectGenerator());
            message.setUser(appUserRepository.findAll().get(random.nextInt(appUserRepository.findAll().size())));
            
            messages.add(message);
        }
        
        return messages;
    }
    
}
