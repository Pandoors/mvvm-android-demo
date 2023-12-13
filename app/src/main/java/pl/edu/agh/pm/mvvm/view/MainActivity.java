package pl.edu.agh.pm.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import pl.edu.agh.pm.mvvm.databinding.ActivityMainBinding;
import pl.edu.agh.pm.mvvm.viewmodel.BuildingViewModel;

public class MainActivity extends AppCompatActivity {
    // view has reference to ViewModel
    private BuildingViewModel buildingViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        buildingViewModel = new ViewModelProvider(this).get(BuildingViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        buildingViewModel.getBuildingData().observe(this, building -> {
            if (building != null) {
                binding.buildingImage.setImageDrawable(
                        ResourcesCompat.getDrawable(getResources(), building.getImg(), getApplicationContext().getTheme())
                );
                binding.buildingNameTV.setText(building.getName());
                binding.buildingAddressTV.setText(String.valueOf(building.getAddress()));
            }
        });
    }
}