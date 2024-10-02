package model;

public class Representative {
    private String name;
    private String cellphone;

    // Constructor para Representative
    public Representative(String name, String cellphone) {
        this.name = name;
        this.cellphone = cellphone;
    }

    // Obtener el nombre del representante
    public String getName() {
        return name;
    }

    // Obtener el celular del representante
    public String getCellphone() {
        return cellphone;
    }

    // Representación del representante en formato String
    @Override
    public String toString() {
        return "Representante: " + name + ", Celular: " + cellphone;
    }
}

