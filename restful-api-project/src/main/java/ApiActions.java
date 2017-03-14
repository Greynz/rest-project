import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.List;

/**
 * Created by DrDan on 3/12/2017.
 */
public class ApiActions {

    MongoClient client = new MongoClient("localhost", 27017);
    Datastore modelsDs = new Morphia().createDatastore(client, "advisorModels");
    Datastore advisorDs = new Morphia().createDatastore(client, "advisorModels");


    //PUT ADVISOR MODEL
    public String addAdvisorModel(AdvisorModel advisorModel, String advisorId){

        Advisor advisor = advisorDs.get(Advisor.class, advisorId);

        if (advisor == null)
            return "Advisor not found.";

        if (advisorModel.verifyAssetAllocation()){
            if ( modelsDs.get(AdvisorModel.class, advisorModel.getId()) == null ){
                System.out.println("doesn't exist yet!");
                modelsDs.save(advisorModel);
                advisor.addModel(advisorModel);
                advisorDs.save(advisor);
            }
            else
                modelsDs.save(advisorModel);

            return "Advisor model successfully added.";
        }
        else
            return "Advisor model asset allocation errors.";
    }

    //PUT ADVISOR
    public String addAdvisor(String advisorId){
        if (advisorDs.get(Advisor.class, advisorId) == null){
            Advisor advisor = new Advisor(advisorId);
            advisorDs.save(advisor);
            return "Advisor added";
        }
        return "User already exists";
    }

    //GET ADVISOR MODELS
    public List<AdvisorModel> getAdvisorModels(String advisorId, int pnum, int psize){

        Advisor advisor = advisorDs.get(Advisor.class, advisorId);

        if (advisor == null)
            return null;

        Query<AdvisorModel> query = modelsDs.createQuery(AdvisorModel.class).offset(pnum).limit(psize).field("advisor").equal(advisorId);
        List<AdvisorModel> models = query.asList();
        return models;
    }

    //GET ALL ADVISOR MODELS
    public List<AdvisorModel> getAllAdvisorModels(){
        List<AdvisorModel> models = modelsDs.find(AdvisorModel.class).asList();
        return models;
    }

}
