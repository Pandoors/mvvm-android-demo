package pl.edu.agh.pm.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import pl.edu.agh.pm.mvvm.R;
import pl.edu.agh.pm.mvvm.databinding.ActivityMainBinding;
import pl.edu.agh.pm.mvvm.model.City;
import pl.edu.agh.pm.mvvm.viewmodel.CityViewModel;

public class MainActivity extends AppCompatActivity {

    private CityViewModel model;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        model = new ViewModelProvider(this).get(CityViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        model.getCityData().observe(this, new Observer<City>() {
            @Override
            public void onChanged(City city) {
                if (city != null) {
                    binding.cityImage.setImageDrawable(
                            ResourcesCompat.getDrawable(getResources(), city.getImg(), getApplicationContext().getTheme())
                    );
                    binding.cityNameTV.setText(city.getName());
                    binding.cityPopulationTV.setText(String.valueOf(city.getPopulation()));
                }
            }
        });
    }
}