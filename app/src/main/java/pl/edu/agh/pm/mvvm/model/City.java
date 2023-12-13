package pl.edu.agh.pm.mvvm.model;

public class City {
    private final String name;
    private final int img;
    private final int population;

    public City(String name, int img, int population) {
        this.name = name;
        this.img = img;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", img=" + img +
                ", population=" + population +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return img == city.img &&
                population == city.population &&
                name.equals(city.name);
    }

}
