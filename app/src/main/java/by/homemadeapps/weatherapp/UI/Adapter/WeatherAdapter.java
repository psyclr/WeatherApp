/*
package by.homemadeapps.weatherapp.UI.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.homemadeapps.weatherapp.DataModel.Entity.Main;
import by.homemadeapps.weatherapp.DataModel.Entity.POJO.Clouds;
import by.homemadeapps.weatherapp.DataModel.Entity.POJO.Wind;
import by.homemadeapps.weatherapp.DataModel.Entity.ResponseData;
import by.homemadeapps.weatherapp.DataModel.Entity.Weather;
import by.homemadeapps.weatherapp.R;

*/
/**
 * Created by Alex on 13.06.16.
 *//*

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.Holder> {

    private List<ResponseData> mResponseWeatherData;

    public WeatherAdapter() {
        mResponseWeatherData = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null, false);


        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
    ResponseData currentRespData = mResponseWeatherData.get(position) ;
        Weather[] weather = currentRespData.getWeather();
        Main main = currentRespData.getMain();
        Clouds clouds = currentRespData.getClouds();
        Cordinate cordinate = currentRespData.getCordinate();
        System system= currentRespData.getSys();
        Wind wind = currentRespData.getWind();

        holder.mCityName.setText(currentRespData.getCityName());

    }

    @Override
    public int getItemCount() {
        return mResponseWeatherData.size();
    }

    public void addItem(ResponseData responseData) {
        mResponseWeatherData.add(responseData);
        notifyDataSetChanged();
        Log.d("SUCCESS", mResponseWeatherData.toString());

    }

    public class Holder extends RecyclerView.ViewHolder {
        protected ImageView mPicture;
        private TextView mCityName, mSpeed, mTemperature, mHumidity, mSunrise, mSunset, mDeg;

        public Holder(View itemView) {
            super(itemView);
            mPicture = (ImageView) itemView.findViewById(R.id.wheatherPicture);
            mCityName = (TextView) itemView.findViewById(R.id.city);
            mSpeed = (TextView) itemView.findViewById(R.id.speed);
            mTemperature = (TextView) itemView.findViewById(R.id.temperature);
            mHumidity = (TextView) itemView.findViewById(R.id.humidity);
            mSunrise = (TextView) itemView.findViewById(R.id.sunrise);
            mSunset = (TextView) itemView.findViewById(R.id.sunset);
            mDeg = (TextView) itemView.findViewById(R.id.deg);
        }
    }
}
*/
