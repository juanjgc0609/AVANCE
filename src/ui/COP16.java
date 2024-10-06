package ui;

import java.util.Scanner;

import model.Controller;

public class COP16 {
    Scanner reader;
    Controller controller;

    public COP16() {
        reader = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args) {
        // Código para inicializar el sistema
        COP16 cop16 = new COP16();
        int opt = 0;
        while (opt != 10) {
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Registrar voluntario");
            System.out.println("2. Para registrar una caminata");
            System.out.println("3. Para registrar un lugar con diversidad biológica");
            System.out.println("4. Para consultar los lugares ordenados de menor a mayor con respecto al área");
            System.out.println(
                    "5. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento.");
            System.out.println("6. Para ingresar una comunidad");
            System.out.println("7. Para ingresar una especie a un lugar");
            System.out.println("8. Modificar los datos de la especie en un lugar.");
            System.out.println("9. Para consultar la información de las comunidades con problemas");
            System.out.println("10. Para consultar el nombre del lugar con mayor cantidad de especies.");
            System.out.println("10. Salir");
            opt = cop16.reader.nextInt();
            cop16.reader.nextLine();
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
                default:
                    System.out.println("Opciòn inválida");
                    break;
            }
        }
    }

    public void registerVolunteer() {
        // Código para registrar un voluntario
        System.out.println(
                "Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali, Colombia");
        System.out.println("¿Cúal es tu nombre?");
        String name = reader.nextLine();
        System.out.println("Por favor, digita tu cédula");
        String id = reader.nextLine();
        controller.createVolunteer(name, id);
        System.out.println("¡Bienvenido, " + name + "!");
    }

    public void registerWalk() {
        // Código para registrar una caminata
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

    public void registerBiodiversePlace() {
        // Código para registrar un lugar biodiverso
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
        System.out.println(
                controller.registerPlace(name, department, area, photo, inauguration, budget));
    }

    public void asociateCommunityToPlace() {
        // Código para asociar una comunidad a un lugar biodiverso
        System.out.println("Ingresa el nombre del lugar");
        String bioPlaceName = reader.nextLine();
        System.out.println("Ingresa el nombre de la comunidad");
        String communityName = reader.nextLine();
        System.out.println(controller.asociateCommunityToPlace(bioPlaceName, communityName));

    }

    public void registerCommunity() {
        // Código para registrar una comunidad
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
        System.out
                .println(
                        "Ingresa el problema de la comunidad (FALTA_AGUA, FALTA_HOSPITAL, FALTA_ESCUELA, FALTA_COMIDA)");
        String problem = reader.nextLine();
        controller.registerCommunity(name, type, representativeName, representativePhone, population, problem);
    }

    public void registerSpecie() {
        // Código para registrar una especie
        System.out.println("Ingresa el nombre del lugar a donde se le registrará la especie");
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
        System.out.println(
                controller.asociateSpecieToPlace(bioPlaceName, name, type, photo, numberOfSpecimens));
    }

    public void changeSpecie() {
        // Código para modificar una especie en un lugar
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

    public void showPlacesByArea() {
        // Código para mostrar los lugares según su área
        System.out.println(controller.showPlacesByArea());
    }

    public void departmentWithMorePlaces() {
        // Código para mostrar el departamento con más lugares registrados
        System.out.println(controller.departmentWithMorePlaces());
    }

    public void consultCommunitiesByProblem() {
        // Código para consultar la información de las comunidades con problemas
        System.out.println("Ingresa el problema a consultar");
        String problem = reader.nextLine();
        System.out.println(controller.consultCommunitiesByProblem(problem));
    }

    public void showPlaceNameWithMoreSpecies() {
        // Código para consultar el lugar con más especies
        System.out.println(controller.showPlaceNameWithMoreSpecies());
    }
}
