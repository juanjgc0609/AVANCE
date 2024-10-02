package model;

public class Volunteer {
    private String name;
    private String id;
    private Walk[] walks;
    private int walkCount;

    // Constructor para Volunteer
    public Volunteer(String name, String id) {
        this.name = name;
        this.id = id;
        this.walks = new Walk[10]; // Inicializamos el arreglo con capacidad para 10 caminatas
        this.walkCount = 0;        // Contador para el número de caminatas
    }

    // Obtener el nombre del voluntario
    public String getName() {
        return name;
    }

    // Obtener el ID del voluntario
    public String getId() {
        return id;
    }

    // Agregar una caminata a la lista de caminatas del voluntario
    public void addWalk(Walk walk) {
        if (walkCount < walks.length) {
            walks[walkCount] = walk;
            walkCount++;
        } else {
            System.out.println("No se pueden agregar más caminatas. Espacio insuficiente.");
        }
    }

    // Obtener la lista de caminatas asociadas al voluntario
    public Walk[] getWalks() {
        Walk[] actualWalks = new Walk[walkCount];
        for (int i = 0; i < walkCount; i++) {
            actualWalks[i] = walks[i];
        }
        return actualWalks; // Retorna solo las caminatas almacenadas hasta el momento
    }
}


