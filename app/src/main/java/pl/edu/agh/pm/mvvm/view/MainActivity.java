package pl.edu.agh.pm.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import pl.edu.agh.pm.mvvm.databinding.ActivityMainBinding;
import pl.edu.agh.pm.mvvm.viewmodel.CityViewModel;

public class MainActivity extends AppCompatActivity {

    // view has reference to ViewModel
    private CityViewModel cityViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cityViewModel = new ViewModelProvider(this).get(CityViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        cityViewModel.getCityData().observe(this, city -> {
            if (city != null) {
                binding.cityImage.setImageDrawable(
                        ResourcesCompat.getDrawable(getResources(), city.getImg(), getApplicationContext().getTheme())
                );
                binding.cityNameTV.setText(city.getName());
                binding.cityPopulationTV.setText(String.valueOf(city.getPopulation()));
            }
        });
    }
}