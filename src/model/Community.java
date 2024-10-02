package model;

public class Community {
    private String name;
    private TypeCommunity type;
    private Representative representative;
    private int population;
    private Problem issue;

    // Constructor para Community
    public Community(String name, TypeCommunity type, Representative representative, int population, Problem issue) {
        this.name = name;
        this.type = type;
        this.representative = representative;
        this.population = population;
        this.issue = issue;
    }

    // Obtener el problema de la comunidad
    public Problem getProblem() {
        return issue;
    }

    // Obtener el representante de la comunidad
    public Representative getRepresentative() {
        return representative;
    }

    // Obtener el tipo de comunidad
    public TypeCommunity getTypeCommunity() {
        return type;
    }

    // Representación de la comunidad en formato String
    @Override
    public String toString() {
        return "Comunidad: " + name + ", Tipo: " + type + ", Población: " + population + ", Problema: " + issue;
    }
}


