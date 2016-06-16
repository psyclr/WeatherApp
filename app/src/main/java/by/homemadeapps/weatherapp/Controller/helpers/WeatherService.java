package by.homemadeapps.weatherapp.Controller.helpers;

import java.io.IOException;

import by.homemadeapps.weatherapp.Controller.WeatherAPI;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 16.06.16.
 */
public class WeatherService {
    private WeatherAPI service;

    public WeatherService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.HTTP.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(WeatherAPI.class);
    }


    public void getWeather(String name, Callback callback) throws IOException {
        service.getWeather(name).enqueue(callback);
    }

}
