package by.homemadeapps.weatherapp.Controller;

import by.homemadeapps.weatherapp.Controller.helpers.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 13.06.16.
 */
public class RestManager {
private WeatherAPI mWeatherService;
    public WeatherAPI getmWeatherService(){
        if (mWeatherService==null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …

// add logging as last interceptor
            httpClient.addInterceptor(logging);  // <-- this is the important line!

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            mWeatherService = retrofit.create(WeatherAPI.class);
        }
        return mWeatherService;
    }


}
