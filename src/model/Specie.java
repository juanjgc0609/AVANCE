package model;

public class Specie {
    private String name;
    private TypeSpecies type;
    private String photo;
    private int numberOfSpecimens;

    /**
     * Constructor para crear una nueva especie.
     * @param name Nombre de la especie.
     * @param type Tipo de la especie (flora/fauna).
     * @param photo Foto representativa de la especie.
     * @param numberOfSpecimens Cantidad de especímenes de la especie.
     */
    public Specie(String name, String type, String photo, int numberOfSpecimens) {
        this.name = name;
        setType(type); // Se asigna el tipo utilizando el método setType
        this.photo = photo;
        this.numberOfSpecimens = numberOfSpecimens;
    }

    /**
     * Obtiene el número de especímenes de la especie.
     * @return Número de especímenes.
     */
    public int getNumberSpecimens() {
        return numberOfSpecimens;
    }

    /**
     * Representa la especie en formato de cadena.
     * @return Cadena con la información de la especie.
     */
    @Override
    public String toString() {
        return "Especie: " + name + ", Tipo: " + type + ", Número de especímenes: " + numberOfSpecimens;
    }

    /**
     * Obtiene el nombre de la especie.
     * @return Nombre de la especie.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el tipo de la especie.
     * @return Tipo de la especie (flora/fauna).
     */
    public TypeSpecies getTypeSpecie() {
        return type;
    }

    /**
     * Establece el nombre de la especie.
     * @param name Nombre de la especie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Establece el tipo de la especie.
     * Convierte la cadena ingresada a mayúsculas para coincidir con el enumerado TypeSpecies.
     * @param type Tipo de la especie (flora/fauna).
     */
    public void setType(String type) {
        this.type = TypeSpecies.valueOf(type.toUpperCase());
    }

    /**
     * Establece el número de especímenes de la especie.
     * @param number Número de especímenes.
     */
    public void setNumberSpecimens(int number) {
        this.numberOfSpecimens = number;
    }

    /**
     * Obtiene la foto de la especie.
     * @return Foto de la especie.
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Establece la foto de la especie.
     * @param photo URL o ruta de la foto de la especie.
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
