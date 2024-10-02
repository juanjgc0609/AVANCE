package model;
public class BiodiversePlace {
    private String name;
    private double area;
    private String department;
    private List<Specie> species;
    private List<Community> communities;

    public BiodiversePlace(String name, double area, String department) {
        this.name = name;
        this.area = area;
        this.department = department;
        this.species = new ArrayList<>();
        this.communities = new ArrayList<>();
    }

    public void addSpecies(Specie specie) {
        species.add(specie);
    }

    public List<Specie> getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public String getDepartment() {
        return department;
    }

    public Community getCommunity() {
        // Código para obtener la comunidad asociada
        return communities.get(0); // Ejemplo simplificado
    }

    @Override
    public String toString() {
        return "Lugar: " + name + ", Área: " + area + ", Departamento: " + department;
    }
}
