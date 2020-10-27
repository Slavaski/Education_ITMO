package Task_3_Wiki;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search {
    @SerializedName("snippet")
    @Expose
    private String snippet;

    public String getRequest() {
        String request = this.snippet.substring(snippet.indexOf(">")+1, snippet.indexOf('/')-1);
        return request;
    }

    @Override
    public String toString() {
        return snippet.replaceAll("<span class=\"searchmatch\">" + getRequest() + "</span>", getRequest());
    }
}