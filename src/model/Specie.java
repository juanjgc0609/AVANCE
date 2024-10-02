package model;

public class Specie {
    private String name;
    private TypeSpecies type;
    private String photo;
    private int numberOfSpecimens;

    // Constructor para Specie
    public Specie(String name, TypeSpecies type, String photo, int numberOfSpecimens) {
        this.name = name;
        this.type = type;
        this.photo = photo;
        this.numberOfSpecimens = numberOfSpecimens;
    }

    // Obtener el número de especímenes
    public int getNumberSpecimens() {
        return numberOfSpecimens;
    }

    // Representación de la especie en formato String
    @Override
    public String toString() {
        return "Especie: " + name + ", Tipo: " + type + ", Número de especímenes: " + numberOfSpecimens;
    }

    // Obtener el nombre de la especie
    public String getName() {
        return name;
    }

    // Obtener el tipo de la especie
    public TypeSpecies getTypeSpecie() {
        return type;
    }

    // Establecer el nombre de la especie
    public void setName(String name) {
        this.name = name;
    }

    // Establecer el tipo de la especie
    public void setType(TypeSpecies type) {
        this.type = type;
    }

    // Establecer el número de especímenes
    public void setNumberSpecimens(int number) {
        this.numberOfSpecimens = number;
    }

    // Establecer la foto de la especie
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
