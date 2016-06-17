package by.homemadeapps.weatherapp.Controller;

import by.homemadeapps.weatherapp.Controller.helpers.Constants;
import by.homemadeapps.weatherapp.DataModel.Entity.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alex on 13.06.16.
 */
public interface WeatherAPI {

    @GET("/data/2.5/weather?appid=" + Constants.HTTP.API_KEY)
    Call<ResponseData> getWeather(@Query("q") String city);
}
