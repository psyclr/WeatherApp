package by.homemadeapps.weatherapp.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.homemadeapps.weatherapp.Controller.RestManager;
import by.homemadeapps.weatherapp.Controller.helpers.WeatherService;
import by.homemadeapps.weatherapp.DataModel.Entity.Main;
import by.homemadeapps.weatherapp.DataModel.Entity.ResponseData;
import by.homemadeapps.weatherapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.CITY_NAME_FIND)
    EditText mEnterCityName;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.CityName)
    TextView mCityTextView;
    @BindView(R.id.Speed)
    TextView mSpeedView;
    @BindView(R.id.Humidity)
    TextView mHumidityView;
    @BindView(R.id.CurrentDate)
    TextView mCurrentDateView;
    @BindView(R.id.refresh_button)
    Button mRefreshButton;

    private WeatherService weatherService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        weatherService = new WeatherService();
    }

    @OnClick(R.id.refresh_button)
    void onClick() {
        Log.d("working", "fine");

        /*try {
            weatherService.getWeather("Hrodna", new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    ResponseData responseData = (ResponseData)response.body();
                    mHumidityView.setText(responseData.getMain().getHumidity());
                }

                @Override
                public void onFailure(Call call, Throwable t) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            RestManager manager = new RestManager();
            manager.getmWeatherService().getWeather("Hrodna").enqueue(new Callback<ResponseData>() {
                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                    ResponseData resp = response.body();
                    if (resp != null) {
                        Main main = response.body().getMain();
                        int num = 0;
                    }
                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
                    int num = 0;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
