package model;
import java.util.Date;

public class Controller {

    // Crear un voluntario
    public Volunteer createVolunteer(String name, String id) {
        return new Volunteer(name, id);
    }

    // Crear una caminata
    public Walk createWalk(int participants, int guides, double temperature, double humidity, Route route) {
        return new Walk(participants, guides, temperature, humidity, route);
    }

    // Crear un lugar biodiverso
    public BiodiversePlace createBiodiversePlace(String name, Department department, double area, String photo, Date inauguration, double budget, Community community, Specie[] species) {
        return new BiodiversePlace(name, department, area, photo, inauguration, budget, community, species);
    }

    // Crear una comunidad
    public Community createCommunity(String name, TypeCommunity type, Representative representative, int population, Problem problem) {
        return new Community(name, type, representative, population, problem);
    }

    // Crear una especie
    public Specie createSpecie(String name, TypeSpecie type, String photo, int number) {
        return new Specie(name, type, photo, number);
    }

    // Crear una ruta
    public Route createRoute(Date start, Date end, String meetingPoint, TypeRoute type) {
        return new Route(start, end, meetingPoint, type);
    }

    // Crear un tipo de ruta
    public TypeRoute createTypeRoute(String type) {
        return new TypeRoute(type);
    }

    // Crear un tipo de especie
    public TypeSpecie createTypeSpecie(String type) {
        return new TypeSpecie(type);
    }

    // Crear un tipo de comunidad
    public TypeCommunity createTypeCommunity(String type) {
        return new TypeCommunity(type);
    }

    // Crear un problema en la comunidad
    public Problem createProblem(String type) {
        return new Problem(type);
    }

    // Crear un representante
    public Representative createRepresentative(String name, String phone) {
        return new Representative(name, phone);
    }

    // Crear un departamento
    public Department createDepartment(String type) {
        return new Department(type);
    }

    // Ordenar lugares por área
    public BiodiversePlace[] sortPlacesByArea(BiodiversePlace[] places) {
        // Implementación del algoritmo para ordenar los lugares por área
        return places;
    }

    // Departamento con más lugares
    public Department departmentWithMorePlaces(BiodiversePlace[] places) {
        // Lógica para encontrar el departamento con más lugares
        return new Department("Ejemplo");
    }

    // Cambiar los datos de una especie en un lugar
    public void changeSpecie(BiodiversePlace[] places, int option) {
        // Lógica para cambiar la especie en el lugar seleccionado
    }

    // Asociar una caminata a un voluntario
    public void asociateWalkToVolunteer(Volunteer volunteer, Walk walk) {
        volunteer.addWalk(walk);
    }

    // Asociar una ruta a una caminata
    public void asociateRouteToWalk(Walk walk, Route route) {
        walk.setRoute(route);
    }

    // Asociar una especie a un lugar biodiverso
    public void asociateSpecieToPlace(Specie specie, BiodiversePlace place) {
        place.addSpecies(specie);
    }

    // Asociar una comunidad a un lugar biodiverso
    public void asociateCommunityToPlace(Community community, BiodiversePlace place) {
        place.setCommunity(community);
    }

    // Consultar las comunidades con problemas
    public Community[] consultCommunityProblem(BiodiversePlace[] places) {
        // Lógica para devolver las comunidades con problemas
        return new Community[0];
    }

    // Consultar el lugar con más especies
    public BiodiversePlace placeWithMoreSpecies(BiodiversePlace[] places) {
        // Lógica para encontrar el lugar con más especies
        return places[0];
    }
}


