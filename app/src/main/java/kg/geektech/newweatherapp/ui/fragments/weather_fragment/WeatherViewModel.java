package kg.geektech.newweatherapp.ui.fragments.weather_fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import kg.geektech.newweatherapp.App;
import kg.geektech.newweatherapp.common.Resource;
import kg.geektech.newweatherapp.data.models.MainWeather;

public class WeatherViewModel  extends ViewModel {
    public LiveData<Resource<MainWeather>> liveData;

    public WeatherViewModel() {
    }

    public void getWeather(){
        liveData= App.repository.getWeather();
    }
}
