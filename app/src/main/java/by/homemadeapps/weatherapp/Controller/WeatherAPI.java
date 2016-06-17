package by.homemadeapps.weatherapp.Controller;

import by.homemadeapps.weatherapp.DataModel.Entity.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alex on 13.06.16.
 *         // Call<ResponseData> getWeather(@Query("q") String city);

 */
public interface WeatherAPI {

    @GET("/data/2.5/weather")
    Call<ResponseData> getWeather(@Query("q") String city, @Query("APPID")String key);
  /*  class factory {
        private static WeatherAPI service;
        public static WeatherAPI getInstance(){
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.HTTP.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                service = retrofit.create(WeatherAPI.class);

                return service;
            } else {
                return service;
            }
        }
    }*/


}
