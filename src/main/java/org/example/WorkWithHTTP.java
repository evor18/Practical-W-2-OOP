package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.awt.Desktop;
public class WorkWithHTTP {
    public static String getJson(String userStr) throws IOException, InterruptedException {
        String str = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="
                + URLEncoder.encode(userStr, StandardCharsets.UTF_8);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(str))
                .header("User-Agent", "aibiiiiiiiiiiiiiiiiiiiilya")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public static void getHTTP(int userChoice) throws IOException {
        String str = "https://ru.wikipedia.org/w/index.php?curid=" + String.valueOf(userChoice);
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(str));
        //desktop.browse(URI.create("https://rt.pornhub.com/")); //на всякий случай
    }
}
