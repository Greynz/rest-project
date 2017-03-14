import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * Created by DrDan on 3/12/2017.
 */

@Entity
public class AdvisorModel {

    @Id
    private String id;

    private String name;
    private String advisor;
    private String description;
    private int cashHoldingPercentage;
    private int drifPercentage;
    private Date createdOn;
    private String modelType;
    private String rebalanceFrequency;
    private List<AssetAllocation> assetAllocations;

    public AdvisorModel() {
    }

    public AdvisorModel(String description, int cashHoldingPercentage, int drifPercentage, Date createdOn, String modelType, String rebalanceFrequency, List<AssetAllocation> assetAllocations) {
        this.description = description;
        this.cashHoldingPercentage = cashHoldingPercentage;
        this.drifPercentage = drifPercentage;
        this.createdOn = createdOn;
        this.modelType = modelType;
        this.rebalanceFrequency = rebalanceFrequency;
        this.assetAllocations = assetAllocations;
    }

    //getters
    public String getName() {
        return name;
    }
    public String getId() { return id; }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAdvisor(String advisor) { this.advisor = advisor; }

    //utility functions
    public boolean verifyAssetAllocation(){
        int percentage = 0;
        for (AssetAllocation a : assetAllocations){
            percentage += a.getPercentage();
        }
        return percentage == 100;
    }

    public void printAssets(){
        for (AssetAllocation a : assetAllocations){
            System.out.println(a.getSymbol() + ": " + a.getPercentage());
        }
    }

    public void generateId(){
        id = name + advisor;
    }

}
