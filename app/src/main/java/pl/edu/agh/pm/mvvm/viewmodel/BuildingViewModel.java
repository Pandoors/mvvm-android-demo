package pl.edu.agh.pm.mvvm.viewmodel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pl.edu.agh.pm.mvvm.model.Building;
import pl.edu.agh.pm.mvvm.model.BuildingDataProvider;

public class BuildingViewModel extends ViewModel {

    private final MutableLiveData<Building> buildingData = new MutableLiveData<>();
    private final List<Building> cities = new BuildingDataProvider().getBuildings();
    private int currentIndex = 0;
    private final long delay = 2000L;

    public BuildingViewModel() {
        loop();
    }

    public LiveData<Building> getBuildingData() {
        return buildingData;
    }

    private void loop() {
        new Handler(Looper.getMainLooper()).postDelayed(this::updateBuilding, delay);
    }

    private void updateBuilding() {
        currentIndex++;
        currentIndex %= cities.size();

        buildingData.postValue(cities.get(currentIndex));

        loop();
    }
}
