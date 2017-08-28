package pl.edu.utp.jobfinder.generator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.edu.utp.jobfinder.enumerator.ApplyStatus;
import pl.edu.utp.jobfinder.model.Apply;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Service
public class ApplyGenerator extends AbstractGenerator{

    // Constructors
    public ApplyGenerator() {
        super();
    }
    
    // TODO : Check
    public List<Apply> generateApplies(int amount) {
        List<Apply> applies = new ArrayList<>();
        
        for (int i = 0; i < amount; i++) {
            Apply apply = new Apply();
            
            apply.setJobOffer(jobOfferRepository.findAll().get(random.nextInt(jobOfferRepository.findAll().size())));
            apply.setCv(cvRepository.findAll().get(random.nextInt(cvRepository.findAll().size())));
            apply.setApplyStatus(ApplyStatus.values()[random.nextInt(ApplyStatus.values().length)]);
            
            applies.add(apply);
        }
        
        return applies;
    } 
    
}
