package kg.geektech.newweatherapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import kg.geektech.newweatherapp.App;
import kg.geektech.newweatherapp.common.Resource;
import kg.geektech.newweatherapp.data.models.MainWeather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    public MutableLiveData<Resource<MainWeather>> getWeather(){
        MutableLiveData<Resource<MainWeather>> liveData= new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        App.api.getWeather("Bishkek","32fb914ebb0929b9e2aaa101289d40ea","metric")
        .enqueue(new Callback<MainWeather>() {
            @Override
            public void onResponse(Call<MainWeather> call, Response<MainWeather> response) {
                if(response.isSuccessful() && response.body()!=null){
                    liveData.setValue(Resource.success(response.body()));
                }
                else{
                    liveData.setValue(Resource.error(null,response.message()));
                }
            }

            @Override
            public void onFailure(Call<MainWeather> call, Throwable t) {
                liveData.setValue(Resource.error(null,t.getLocalizedMessage()));
            }
        });
        return liveData;
    }
}
