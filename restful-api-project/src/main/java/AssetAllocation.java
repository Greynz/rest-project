import org.mongodb.morphia.annotations.Embedded;

/**
 * Created by DrDan on 3/12/2017.
 */

@Embedded
public class AssetAllocation {

    private String symbol;
    private int percentage;

    public AssetAllocation() {}

    public AssetAllocation(String s, int n){
        symbol = s;
        percentage = n;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPercentage() {
        return percentage;
    }
}
