package pl.edu.agh.pm.mvvm.model;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.pm.mvvm.R;

public class CityDataProvider {

    private final List<City> cities = new ArrayList<>();

    public CityDataProvider() {
        cities.add(new City("Bangkok", R.drawable.bangkok, 10_000_000));
        cities.add(new City("Beijing", R.drawable.beijing, 21_500_000));
        cities.add(new City("London", R.drawable.london, 8_900_000));
        cities.add(new City("New York", R.drawable.newyork, 8_400_000));
        cities.add(new City("Paris", R.drawable.paris, 2_100_000));
        cities.add(new City("Rio de Janeiro", R.drawable.rio, 6_700_000));
        cities.add(new City("Rome", R.drawable.rome, 2_800_000));
        cities.add(new City("Singapore", R.drawable.singapore, 5_700_000));
        cities.add(new City("Sydney", R.drawable.sydney, 5_300_000));
        cities.add(new City("Tokyo", R.drawable.tokyo, 13_900_000));
    }

    public List<City> getCities() {
        return cities;
    }
}