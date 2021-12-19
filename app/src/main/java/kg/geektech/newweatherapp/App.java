package kg.geektech.newweatherapp;

import android.app.Application;

import kg.geektech.newweatherapp.data.remote.RetrofitClient;
import kg.geektech.newweatherapp.data.remote.WeatherApi;
import kg.geektech.newweatherapp.data.repository.MainRepository;

public class App extends Application {
    public static WeatherApi api;
    public static MainRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient client=new RetrofitClient();
        api= client.provideApi();
        repository=new MainRepository();
    }
}
