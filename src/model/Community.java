package model;

public class Community {
    private String name;
    private TypeCommunity type;
    private Representative representative;
    private int population;
    private Problem problem;

    // Constructor para Community
    public Community(String name, String type, Representative representative, int population, String problem) {
        this.name = name;
        setTypeCommunity(type);
        this.representative = representative;
        this.population = population;
        setProblem(problem);
    }

    // Obtener el nombre de la comunidad
    public String getName() {
        return name;
    }

    // Establecer el nombre de la comunidad
    public void setName(String name) {
        this.name = name;
    }

    // Obtener el problema de la comunidad
    public Problem getProblem() {
        return problem;
    }

    // Establecer el problema de la comunidad
    public void setProblem(String problem) {
        this.problem = Problem.valueOf(problem.toUpperCase());
    }

    // Obtener el representante de la comunidad
    public Representative getRepresentative() {
        return representative;
    }

    // Obtener el tipo de comunidad
    public TypeCommunity getTypeCommunity() {
        return type;
    }

    // Establecer el tipo de comunidad
    public void setTypeCommunity(String type) {
        this.type = TypeCommunity.valueOf(type.toUpperCase());
    }

    // Obtener la población de la comunidad
    public int getPopulation() {
        return population;
    }

    // Establecer la población de la comunidad
    public void setPopulation(int population) {
        this.population = population;
    }

    // Representación de la comunidad en formato String
    @Override
    public String toString() {
        return "Comunidad: " + name + ", Tipo: " + type + ", Población: " + population + ", Problema: " + problem;
    }
}
