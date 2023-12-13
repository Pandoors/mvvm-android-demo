package pl.edu.agh.pm.mvvm.viewmodel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pl.edu.agh.pm.mvvm.model.City;
import pl.edu.agh.pm.mvvm.model.CityDataProvider;

public class CityViewModel extends ViewModel {

    private final MutableLiveData<City> cityData = new MutableLiveData<>();
    private final List<City> cities = new CityDataProvider().getCities();
    private int currentIndex = 0;
    private final long delay = 2000L;

    public CityViewModel() {
        loop();
    }

    public LiveData<City> getCityData() {
        return cityData;
    }

    private void loop() {
        new Handler(Looper.getMainLooper()).postDelayed(this::updateCity, delay);
    }

    private void updateCity() {
        currentIndex++;
        currentIndex %= cities.size();

        cityData.postValue(cities.get(currentIndex));

        loop();
    }
}
