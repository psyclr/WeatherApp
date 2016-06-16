package by.homemadeapps.weatherapp.Controller;

import by.homemadeapps.weatherapp.Controller.helpers.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 13.06.16.
 */
public class RestManager {
private WeatherAPI mWeatherService;
    public WeatherAPI getmWeatherService(){
        if (mWeatherService==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mWeatherService = retrofit.create(WeatherAPI.class);
        }
        return mWeatherService;
    }


}
