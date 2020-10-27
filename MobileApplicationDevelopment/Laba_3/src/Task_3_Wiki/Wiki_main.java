package Task_3_Wiki;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Wiki_main {
    public static void main(String[] args) {
        Scanner query = new Scanner(System.in);
        System.out.print("Enter your query: ");
        String queryForServer = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=\"" + URLEncoder.encode(query.nextLine(), StandardCharsets.UTF_8) + "\"";

        try {
            URLConnection connection = new URL(queryForServer).openConnection();
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            char[] buffer = new char[256];
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read(buffer)) != -1)
                sb.append(buffer, 0, rc);
            reader.close();

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Example wiki = gson.fromJson(String.valueOf(sb), Example.class);
            if (wiki.getQuery().getSearch().isEmpty())
                System.out.println("No data.");
            else
                System.out.println(wiki.getQuery());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
