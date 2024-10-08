package ui;

import java.util.Scanner;
import model.Controller;

public class COP16 {
    Scanner reader;
    Controller controller;

    public COP16() {
        // Inicializa el controlador
        controller = new Controller(); // Asegúrate de inicializar controller aquí
    }

    public static void main(String[] args) {
        // Código para inicializar el sistema
        COP16 cop16 = new COP16();
        cop16.reader = new Scanner(System.in);
        int opt = 0;
        while (opt != 11) {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Registrar voluntario");
            System.out.println("2. Para registrar una caminata");
            System.out.println("3. Para registrar un lugar con diversidad biológica");
            System.out.println("4. Para consultar los lugares ordenados de menor a mayor con respecto al área");
            System.out.println("5. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento.");
            System.out.println("6. Para ingresar una comunidad");
            System.out.println("7. Para ingresar una especie a un lugar");
            System.out.println("8. Modificar los datos de la especie en un lugar.");
            System.out.println("9. Para consultar la información de las comunidades con problemas");
            System.out.println("10. Para consultar el nombre del lugar con mayor cantidad de especies.");
            System.out.println("11. Salir");
            opt = cop16.reader.nextInt();
            cop16.reader.nextLine(); // Consume el salto de línea
            switch (opt) {
                case 1:
                    cop16.registerVolunteer();
                    break;
                case 2:
                    cop16.registerWalk();
                    break;
                case 3:
                    cop16.registerBiodiversePlace();
                    break;
                case 4:
                    cop16.showPlacesByArea();
                    break;
                case 5:
                    cop16.departmentWithMorePlaces();
                    break;
                case 6:
                    cop16.registerCommunity();
                    break;
                case 7:
                    cop16.registerSpecie();
                    break;
                case 8:
                    cop16.changeSpecie();
                    break;
                case 9:
                    cop16.consultCommunitiesByProblem();
                    break;
                case 10:
                    cop16.showPlaceNameWithMoreSpecies();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        cop16.reader.close(); // Cierra el escáner al final
    }

    /**
     * Registra un nuevo voluntario en el sistema.
     * Pide al usuario ingresar su nombre y cédula para registrarlo.
     */
    public void registerVolunteer() {
        System.out.println("Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali, Colombia");
        System.out.println("¿Cuál es tu nombre?");
        String name = reader.nextLine();
        System.out.println("Por favor, digita tu cédula");
        String id = reader.nextLine();
        controller.createVolunteer(name, id);
        System.out.println("¡Bienvenido, " + name + "!");
    }

    /**
     * Registra una caminata ecológica en el sistema.
     * Solicita información sobre los participantes, guías, ruta, temperatura y humedad.
     */
    public void registerWalk() {
        System.out.println("¿Cuantos participantes acudirán a la caminata el día de hoy?");
        int participants = reader.nextInt();
        System.out.println("¿Cuántos guías acudirán a la caminata el día de hoy?");
        int guides = reader.nextInt();
        reader.nextLine();
        System.out.println("Ingresa el tipo de ruta (LADERA, FARALLONES, ORIENTE)");
        String routeType = reader.nextLine();
        System.out.println("Ingresa la temperatura");
        double temperature = reader.nextDouble();
        reader.nextLine();
        System.out.println("Ingresa la humedad");
        double humidity = reader.nextDouble();
        reader.nextLine();

        System.out.println(controller.asociateWalkToVolunteer(routeType, participants, guides, temperature, humidity));
    }

    /**
     * Registra un nuevo lugar biodiverso en el sistema, validando que el nombre sea único.
     * @param reader Scanner para leer la entrada del usuario.
     * @param cantidadLugares Número actual de lugares registrados.
     * @return La cantidad de lugares actualizada después del registro.
     */
    public void registerBiodiversePlace() {
        System.out.println("Ingresa el nombre del lugar biodiverso");
        String name = reader.nextLine();
        System.out.println("Ingresa el departamento en el cual está el lugar");
        String department = reader.nextLine();
        System.out.println("Ingresa la cantidad de kilómetros cuadrados que abarca el lugar");
        double area = reader.nextDouble();

        reader.nextLine();

        System.out.println("Ingresa la foto del lugar");
        String photo = reader.nextLine();
        System.out.println("Ingresa la fecha de inauguración del lugar (AAAA-MM-DD)");
        String inauguration = reader.nextLine();
        System.out.println("Ingresa los recursos económicos necesarios para un buen cuidado del hábitat");
        double budget = reader.nextDouble();
        reader.nextLine();
        controller.createBiodiversePlace(name, department, area, photo, inauguration, budget);
        System.out.println("Lugar ingresado con éxito.");
    }

    /**
     * Asocia una comunidad a un lugar biodiverso en el sistema.
     * Solicita el nombre del lugar y el de la comunidad.
     */
    public void asociateCommunityToPlace() {
        System.out.println("Ingresa el nombre del lugar");
        String bioPlaceName = reader.nextLine();
        System.out.println("Ingresa el nombre de la comunidad");
        String communityName = reader.nextLine();
        System.out.println(controller.asociateCommunityToPlace(bioPlaceName, communityName));
    }

    /**
     * Registra una nueva comunidad en el sistema.
     * Solicita el nombre, tipo de comunidad, representante, teléfono y problema.
     */
    public void registerCommunity() {
        System.out.println("Ingresa el nombre de la comunidad");
        String name = reader.nextLine();
    
        System.out.println("Ingresa el tipo de comunidad (AFROCOLOMBIANA, INDIGENA, RAIZAL)");
        String type = reader.nextLine();
    
        System.out.println("Ingresa el nombre del representante de la comunidad");
        String representativeName = reader.nextLine();
    
        System.out.println("Ingresa el número de teléfono del representante de la comunidad");
        String representativePhone = reader.nextLine();
    
        System.out.println("Ingresa la población de la comunidad");
        int population = reader.nextInt();
        reader.nextLine();  // Consumir el salto de línea pendiente después de nextInt()
    
        System.out.println("Ingresa el problema de la comunidad (FALTA_AGUA, FALTA_HOSPITAL, FALTA_ESCUELA, FALTA_COMIDA)");
        String problem = reader.nextLine();
    
        controller.createCommunity(name, type, representativeName, representativePhone, population, problem);
    }

    /**
     * Registra una especie en un lugar biodiverso.
     * Solicita información sobre el lugar, el nombre de la especie, tipo, foto y cantidad de ejemplares.
     */
    public void registerSpecie() {
        System.out.println("Ingresa el nombre del lugar a donde se le registrarará la especie");
        String bioPlaceName = reader.nextLine();
        System.out.println("Ingresa el nombre de la especie");
        String name = reader.nextLine();
        System.out.println("Ingresa el tipo de la especie (flora/fauna)");
        String type = reader.nextLine();
        System.out.println("Ingresa la foto de la especie");
        String photo = reader.nextLine();
        System.out.println("Ingresa la cantidad de ejemplares de la especie");
        int numberOfSpecimens = reader.nextInt();
        reader.nextLine();
        System.out.println(controller.asociateSpecieToPlace(bioPlaceName, name, type, photo, numberOfSpecimens));
    }

    /**
     * Modifica los datos de una especie ya registrada en un lugar biodiverso.
     * Solicita el nombre del lugar, de la especie original, y los nuevos datos de la especie.
     */
    public void changeSpecie() {
        System.out.println("Ingresa el nombre del lugar");
        String bioPlaceName = reader.nextLine();
        System.out.println("Ingresa el nombre de la especie");
        String specieName = reader.nextLine();
        System.out.println("Ingresa el nuevo nombre de la especie");
        String newSpecieName = reader.nextLine();
        System.out.println("Ingresa el nuevo tipo de la especie (flora/fauna)");
        String newSpecieType = reader.nextLine();
        System.out.println("Ingresa la nueva foto de la especie");
        String newSpeciePhoto = reader.nextLine();
        System.out.println("Ingresa la nueva cantidad de ejemplares de la especie");
        int newNumberOfSpecimens = reader.nextInt();
        reader.nextLine();
        System.out.println(controller.changeSpecie(bioPlaceName, specieName, newSpecieName, newSpecieType,
                newSpeciePhoto, newNumberOfSpecimens));
    }

    /**
     * Muestra una lista de los lugares biodiversos ordenados por área de menor a mayor.
     */
    public void showPlacesByArea() {
        System.out.println(controller.showPlacesByArea());
    }

    /**
     * Muestra el departamento con más lugares registrados hasta el momento.
     */
    public void departmentWithMorePlaces() {
        System.out.println(controller.departmentWithMorePlaces());
    }

    /**
     * Consulta las comunidades que tienen problemas específicos (agua, hospitales, escuelas, etc.).
     * Solicita el tipo de problema para hacer la consulta.
     */
    public void consultCommunitiesByProblem() {
        System.out.println("Ingresa el problema a consultar");
        String problem = reader.nextLine();
        System.out.println(controller.consultCommunitiesByProblem(problem));
    }

    /**
     * Muestra el nombre del lugar biodiverso con la mayor cantidad de especies registradas.
     */
    public void showPlaceNameWithMoreSpecies() {
        System.out.println(controller.showPlaceNameWithMoreSpecies());
    }
}
