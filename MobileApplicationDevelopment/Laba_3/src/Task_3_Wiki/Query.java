package Task_3_Wiki;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query {
    @SerializedName("search")
    @Expose
    private List<Search> search = null;

    public List<Search> getSearch() {
        return search;
    }

    @Override
    public String toString() {
        return search.toString().substring(1).substring(0, search.toString().length()-2);
    }
}