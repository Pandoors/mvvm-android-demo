package pl.edu.agh.pm.mvvm.model;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.pm.mvvm.R;

public class BuildingDataProvider {

    private final List<Building> buildings = new ArrayList<>();

    public BuildingDataProvider() {
        buildings.add(new Building("Faculty of Geology, Geophysics and Environmental Protection, AGH", R.drawable.a0, "al. Adama Mickiewicza 30"));
        buildings.add(new Building("Faculty of Electrical Engineering, Automatics, Computer Science and Biomedical Engineering, AGH", R.drawable.b1, "al. A. Mickiewicza 30"));
        buildings.add(new Building("Department of Applied Computer Science, AGH", R.drawable.c3, "al. Adama Mickiewicza 30"));
        buildings.add(new Building("Faculty of Electrical Engineering, Automatics, Computer Science and Biomedical Engineering, AGH", R.drawable.d2, "ul. Reymonta 13A"));
        buildings.add(new Building("Main Library of the AGH University of Science and Technology", R.drawable.library, "al. Adama Mickiewicza 30"));
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}