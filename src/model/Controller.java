package model;

public class Controller {
    // Asociations
    private BiodiversePlace[] places;
    private Route[] routes;
    private Volunteer volunteer;
    private Community[] communities;

    // Constructor
    public Controller() {
        this.routes = new Route[3];
        this.places = new BiodiversePlace[30];
        this.communities = new Community[30];
    }

    // Crear un voluntario
    public Volunteer createVolunteer(String name, String id) {
        volunteer = new Volunteer(name, id);
        return volunteer;
    }

    // Crear una caminata
    public Walk createWalk(String routeType, int participants, int guides, Volunteer volunteer, double temperature,
            double humidity) {
        Route route = searchRouteByType(routeType);
        return new Walk(route, participants, guides, volunteer, temperature, humidity);
    }

    // Registrar lugar biodiverso
    public String registerPlace(String name, String department, double area, String photo, String inauguration,
            double budget) {
        BiodiversePlace biodiversePlace = createBiodiversePlace(name, department, area, photo, inauguration, budget);
        String message = "";
        boolean added = false;
        for (int i = 0; i < places.length && !added; i++) {
            if (places[i] == null) {
                places[i] = biodiversePlace;
                added = true;
            }
        }
        if (added) {
            message = "Lugar ingresado con éxito.";
        } else {
            message = "Lugar no pudo ser ingresado, el sistema se encuentra lleno.";
        }
        return message;
    }

    // Crear un lugar biodiverso inicialmente sin especies ni comunidad que lo cuide
    public BiodiversePlace createBiodiversePlace(String name, String department, double area, String photo,
            String inauguration, double budget) {
        return new BiodiversePlace(name, department, area, photo, inauguration, budget);
    }

    // Registrar comunidad
    public String registerCommunity(String name, String type, String representativeName, String representativePhone,
            int population, String problem) {
        Community community = createCommunity(name, type, representativeName, representativePhone, population, problem);
        String message = "";
        boolean added = false;
        for (int i = 0; i < communities.length && !added; i++) {
            if (communities[i] == null) {
                communities[i] = community;
                added = true;
            }
        }
        if (added) {
            message = "Comunidad ingresada con electrónico.";
        } else {
            message = "Comunidad no pudo ser ingresada, el sistema se encuentra lleno.";
        }
        return message;
    }

    // Crear una comunidad
    public Community createCommunity(String name, String type, String representativeName, String representativePhone,
            int population,
            String problem) {
        Representative representative = createRepresentative(representativeName, representativePhone);
        return new Community(name, type, representative, population, problem);
    }

    // Crear una especie
    public Specie createSpecie(String name, String type, String photo, int numberOfSpecimens) {
        return new Specie(name, type, photo, numberOfSpecimens);
    }

    // Crear una ruta
    public Route createRoute(String start, String end, String meetingPoint, String type) {
        return new Route(start, end, meetingPoint, type);
    }

    // Crear un representante
    public Representative createRepresentative(String name, String phone) {
        return new Representative(name, phone);
    }

    public String showPlacesByArea() {
        // Lógica para mostrar los lugares por área
        BiodiversePlace[] places = sortPlacesByArea();
        String message = "";
        for (int i = 0; i < places.length; i++) {
            message += places[i].toString() + "\n";
        }
        return message;
    }

    // Ordenar lugares por área
    public BiodiversePlace[] sortPlacesByArea() {
        // Implementación del algoritmo para ordenar los lugares por área
        for (int i = 0; i < places.length - 1; i++) {
            for (int j = 0; j < places.length - i - 1; j++) {
                if (places[j].getArea() > places[j + 1].getArea()) {
                    BiodiversePlace temp = places[j];
                    places[j] = places[j + 1];
                    places[j + 1] = temp;
                }
            }
        }

        return places;
    }

    // Departamento con más lugares
    public String departmentWithMorePlaces() {
        // Buscar el string más repetido
        String departmentWithMorePlaces = "";
        int maxCount = 0;
        for (int i = 0; i < places.length; i++) {
            int count = 0;
            for (int j = 0; j < places.length; j++) {
                if (places[i].getDepartment().equals(places[j].getDepartment())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                departmentWithMorePlaces = places[i].getDepartment();
            }
        }
        return departmentWithMorePlaces;
    }

    // Cambiar los datos de una especie en un lugar
    public String changeSpecie(String bioPlaceName, String specieName, String newSpecieName, String newSpecieType,
            String newSpeciePhoto, int newNumberOfSpecimens) {
        // Lógica para cambiar la especie en el lugar seleccionado
        String message = "";
        BiodiversePlace bioPlace = searchPlaceByName(bioPlaceName);
        if (bioPlace == null) {
            message = "Lugar no encontrado";
        } else {
            Specie specie = bioPlace.searchSpecieByName(specieName);
            if (specie == null) {
                message = "Especie no encontrada";
            } else {
                specie.setName(newSpecieName);
                specie.setType(newSpecieType);
                specie.setPhoto(newSpeciePhoto);
                specie.setNumberSpecimens(newNumberOfSpecimens);
                message = "Especie cambiada";
            }
        }
        return message;
    }

    // Buscar una caminata por su tipo de ruta
    public Walk searchWalkByRouteType(String routeType) {
        // Lógica para buscar una caminata por su tipo de ruta
        Walk walk = null;
        for (int i = 0; i < volunteer.getWalks().length; i++) {
            if (volunteer.getWalks()[i] != null) {
                if (volunteer.getWalks()[i].getRoute().getType().equals(routeType.toUpperCase())) {
                    walk = volunteer.getWalks()[i];
                }
            }
        }
        return walk;
    }

    // Asociar una caminata a un voluntario
    public String asociateWalkToVolunteer(String routeType, int participants, int guides, double temperature,
            double humidity) {
        String message = "";
        if (volunteer == null) {
            message = "Voluntario no encontrado";
        } else {
            Walk walk = createWalk(routeType, participants, guides, volunteer, temperature, humidity);
            if (walk == null) {
                message = "La caminata no pudo ser creada";
            } else {
                message = "Caminata asociada correctamente";
            }
        }
        // Lógica para asociar una caminata a un voluntario

        return message;
    }

    // Asociar una especie a un lugar biodiverso
    public String asociateSpecieToPlace(String placeName, String specieName, String specieType, String speciePhoto,
            int numberOfSpecimens) {
        // Lógica para asociar una especie a un lugar
        BiodiversePlace place = searchPlaceByName(placeName);
        String message = "";
        if (place == null) {
            message = "Lugar no encontrado";
        } else {
            Specie specie = createSpecie(specieName, specieType, speciePhoto, numberOfSpecimens);
            place.addSpecie(specie);
            message = "Especie asociada correctamente";
        }
        return message;
    }

    // Asociar una comunidad a un lugar biodiverso
    public String asociateCommunityToPlace(String communityName, String placeName) {
        // Lógica para asociar una comunidad a un lugar
        Community community = searchCommunityByName(communityName);
        String message = "";
        if (community == null) {
            message = "Comunidad no encontrada";
        } else {
            BiodiversePlace place = searchPlaceByName(placeName);
            if (place != null) {
                place.setCommunity(community);
                message = "Comunidad asociada correctamente";
            } else {
                message = "Lugar no encontrado";
            }
        }
        return message;
    }

    // Buscar un lugar por su nombre
    public BiodiversePlace searchPlaceByName(String name) {
        // Lógica para buscar un lugar por su nombre
        BiodiversePlace place = null;
        for (int i = 0; i < places.length; i++) {
            if (places[i].getName().equals(name)) {
                place = places[i];
                break;
            }
        }
        return place;
    }

    // Buscar una comunidad por su nombre
    public Community searchCommunityByName(String name) {
        // Lógica para buscar una comunidad por su nombre
        Community community = null;
        for (int i = 0; i < places.length; i++) {
            if (places[i].getCommunity().getName().equals(name)) {
                community = places[i].getCommunity();
                break;
            }
        }
        return community;

    }

    // Buscar una ruta por su tipo
    public Route searchRouteByType(String type) {
        // Lógica para buscar una ruta por su tipo
        Route route = null;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i].getType().equals(type.toUpperCase())) {
                route = routes[i];
                break;
            }
        }
        return route;
    }

    // Consultar las comunidades con problemas
    public Community[] consultCommunitiesByProblem(String problem) {
        // Lógica para devolver las comunidades con problemas
        Community[] communitiesWithProblem = new Community[places.length];
        for (int i = 0; i < places.length; i++) {
            if (places[i].getCommunity().getProblem().equals(problem.toUpperCase())) {
                communitiesWithProblem[i] = places[i].getCommunity();
            }
        }
        return communitiesWithProblem;
    }

    // Consultar el lugar con más especies
    public String showPlaceNameWithMoreSpecies() {
        // Lógica para encontrar el lugar con más especies
        String message = "";
        BiodiversePlace placeWithMoreSpecies = null;
        int maxCount = 0;
        for (int i = 0; i < places.length; i++) {
            int count = 0;
            for (int j = 0; j < places[i].getSpecies().length; j++) {
                if (places[i].getSpecies()[j] != null) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                placeWithMoreSpecies = places[i];
            }
        }
        message = "El lugar con más especies es: " + placeWithMoreSpecies.getName();
        return message;
    }
}
