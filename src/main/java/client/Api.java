package client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Api {


    private static final String API_KEY = "dfb53327f4ad3e35ca796292";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static Map<String, Double> getApi(String baseCurrency) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");

        Map<String, Double> exchangeRates = new HashMap<>();
        for (String key : rates.keySet()) {
            exchangeRates.put(key, rates.get(key).getAsDouble());
        }

        return exchangeRates;
    }
}
