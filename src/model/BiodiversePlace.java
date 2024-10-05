package model;

import java.time.LocalDate;

public class BiodiversePlace {
    // Attributes
    private String name;
    private String department;
    private double area;
    private String photo;
    private LocalDate inaugurationDate;
    private double budget;
    private Specie[] species;
    private Community community;

    // Constructor
    public BiodiversePlace(String name, String department, double area, String photo, String inaugurationDate,
            double budget) {
        this.name = name;
        this.area = area;
        this.department = department;
        this.photo = photo;
        this.inaugurationDate = LocalDate.parse(inaugurationDate);
        this.budget = budget;
        this.species = new Specie[50];
    }

    public void addSpecies(Specie specie) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = specie;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getInaugurationDate() {
        return inaugurationDate;
    }

    public void setInaugurationDate(LocalDate inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Specie[] getSpecies() {
        return species;
    }

    public void setSpecies(Specie[] species) {
        this.species = species;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Specie searchSpecieByName(String name) {
        Specie specie = null;
        for (int i = 0; i < species.length; i++) {
            if (species[i] != null && species[i].getName().equals(name)) {
                specie = species[i];
                break;
            }
        }
        return specie;
    }

    public boolean addSpecie(Specie specie) {
        boolean added = false;
        for (int i = 0; i < species.length && !added; i++) {
            if (species[i] == null) {
                species[i] = specie;
                added = true;
            }
        }
        return added;
    }

    @Override
    public String toString() {
        return "Lugar: " + name + ", Área: " + area + ", Departamento: " + department;
    }
}
