package Task_3_Wiki;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {
    @SerializedName("query")
    @Expose
    private Query query;

    public Query getQuery() {
        return query;
    }
}