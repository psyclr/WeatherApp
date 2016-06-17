package by.homemadeapps.weatherapp.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.homemadeapps.weatherapp.Controller.helpers.WeatherService;
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
        try {
            Log.i("Кнопка","try");

            weatherService.getWeather(mEnterCityName.getText().toString(), new Callback() {

                @Override
                public void onResponse(Call call, Response response) {
                 //   Log.i("onResponse",response.errorBody().toString());


                    ResponseData responseData = (ResponseData)response.body();
                    Log.i("Кнопка","onResponse");

                    mHumidityView.setText(responseData.getMain().getHumidity()+"");
                    mCityTextView.setText(responseData.getName());
                    Date date = new Date();
                    date.setTime(responseData.getDt());
                    mCurrentDateView.setText(date.toString());
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                   t.getCause();
                    t.getMessage();
                    t.getStackTrace();
                    Log.d("Кнопка",t.getCause().toString());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*WeatherAPI.factory.getInstance().getWeather("London", Constants.HTTP.API_KEY).enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Log.d("response", "message");
                Log.d("response:", response.message());
                List<Weather> weather = response.body().getWeather();
                Log.d(weather.size() + "", "");
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
            }
        });*/

    }
}
