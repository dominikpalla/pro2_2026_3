package cz.uhk.spring3.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {
    private final String API_KEY = "b1f0f39ebd3e42c981862543263003";
    private final String URL = "http://api.weatherapi.com/v1/current.json?key="
            + API_KEY + "&q=";


    public String getTemp(String location) {
        location = URLEncoder.encode(location.trim(), StandardCharsets.UTF_8);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL + location)
                .build();

        try(Response response = client.newCall(request).execute()){
            String responseBody = response.body().string();
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONObject currentJson = jsonObject.getJSONObject("current");
            float temp = currentJson.getFloat("temp_c");
            return String.valueOf(temp);
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
