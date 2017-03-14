import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.List;
import java.util.Set;

/**
 * Created by DrDan on 3/13/2017.
 */

@Entity
public class Advisor {

    @Id
    private String name;
    @Reference
    private Set<AdvisorModel> Models;


    public Advisor(String name) {
        this.name = name;
    }

    public Advisor() {
    }

    public String getName() {
        return name;
    }

    public Set<AdvisorModel> getModels() {
        return Models;
    }

    public void addModel(AdvisorModel am){
        for (AdvisorModel a : Models){
            if (a.getName() == am.getName())
                return;
        }
        Models.add(am);
    }

}
