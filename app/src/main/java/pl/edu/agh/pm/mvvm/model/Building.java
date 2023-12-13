package pl.edu.agh.pm.mvvm.model;

import java.util.Objects;

public class Building {
    private final String name;
    private final int img;
    private final String address;

    public Building(String name, int img, String address) {
        this.name = name;
        this.img = img;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", img=" + img +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building)) return false;
        Building building = (Building) o;
        return img == building.img &&
                Objects.equals(address, building.address) &&
                name.equals(building.name);
    }

}
