package model;

public class Volunteer {
    private String name;
    private String id;
    private Walk[] walks;
    private int walkCount;

    /**
     * Constructor para crear un nuevo voluntario.
     * @param name Nombre del voluntario.
     * @param id Identificación del voluntario.
     */
    public Volunteer(String name, String id) {
        this.name = name;
        this.id = id;
        this.walks = new Walk[10]; // Inicializamos el arreglo con capacidad para 10 caminatas
        this.walkCount = 0;        // Contador para el número de caminatas
    }

    /**
     * Obtiene el nombre del voluntario.
     * @return Nombre del voluntario.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la identificación del voluntario.
     * @return Identificación del voluntario.
     */
    public String getId() {
        return id;
    }

    /**
     * Agrega una caminata al voluntario.
     * Si el arreglo de caminatas está lleno, muestra un mensaje de error.
     * @param walk La caminata a agregar.
     */
    public void addWalk(Walk walk) {
        if (walkCount < walks.length) {
            walks[walkCount] = walk;
            walkCount++;
        } else {
            System.out.println("No se pueden agregar más caminatas. Espacio insuficiente.");
        }
    }

    /**
     * Obtiene la lista de caminatas asociadas al voluntario.
     * Solo retorna las caminatas que han sido agregadas (sin espacios vacíos).
     * @return Un arreglo con las caminatas del voluntario.
     */
    public Walk[] getWalks() {
        Walk[] actualWalks = new Walk[walkCount];
        for (int i = 0; i < walkCount; i++) {
            actualWalks[i] = walks[i];
        }
        return actualWalks; // Retorna solo las caminatas almacenadas hasta el momento
    }
}
