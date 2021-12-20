package kg.geektech.newweatherapp.data.repository;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import kg.geektech.newweatherapp.App;
import kg.geektech.newweatherapp.common.Resource;
import kg.geektech.newweatherapp.data.models.MainWeather;
import kg.geektech.newweatherapp.data.remote.WeatherApi;
import kg.geektech.newweatherapp.ui.fragments.weather_fragment.WeatherFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private WeatherApi api;
    private WeatherFragment weatherFragment=new WeatherFragment();



    @Inject
    public MainRepository(WeatherApi api){
        this.api=api;
    }

    public MutableLiveData<Resource<MainWeather>> getWeather(String cityName){
        MutableLiveData<Resource<MainWeather>> mutableLiveData= new MutableLiveData<>();
        mutableLiveData.setValue(Resource.loading());
        api.getWeather(cityName,"32fb914ebb0929b9e2aaa101289d40ea","metric")
        .enqueue(new Callback<MainWeather>() {
            @Override
            public void onResponse(Call<MainWeather> call, Response<MainWeather> response) {
                if(response.isSuccessful() && response.body()!=null){
                    mutableLiveData.setValue(Resource.success(response.body()));
                }
                else{
                    mutableLiveData.setValue(Resource.error(null,response.message()));
                }
            }

            @Override
            public void onFailure(Call<MainWeather> call, Throwable t) {
                mutableLiveData.setValue(Resource.error(null,t.getLocalizedMessage()));
            }
        });
        return mutableLiveData;
    }
}
