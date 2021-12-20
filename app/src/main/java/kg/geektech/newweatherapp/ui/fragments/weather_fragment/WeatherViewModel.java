package kg.geektech.newweatherapp.ui.fragments.weather_fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kg.geektech.newweatherapp.App;
import kg.geektech.newweatherapp.common.Resource;
import kg.geektech.newweatherapp.data.models.MainWeather;
import kg.geektech.newweatherapp.data.repository.MainRepository;

@HiltViewModel
public class WeatherViewModel  extends ViewModel {
    private MainRepository repository;
    public LiveData<Resource<MainWeather>> liveData;

    @Inject
    public WeatherViewModel(MainRepository repository) {
        this.repository=repository;
    }

    public void getWeather(String cityName){
        liveData=repository.getWeather(cityName);
    }
}
