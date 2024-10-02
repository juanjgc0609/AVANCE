package model;

public class Walk {
    private Route route;
    private int guides;
    private int participants;
    private Volunteer volunteer;

    // Constructor para Walk
    public Walk(Route route, int guides, int participants, Volunteer volunteer) {
        this.route = route;
        this.guides = guides;
        this.participants = participants;
        this.volunteer = volunteer;
    }

    // Obtener la cantidad de guías
    public int getGuides() {
        return guides;
    }

    // Obtener la cantidad de participantes
    public int getParticipants() {
        return participants;
    }

    // Calcular el total de personas (guías + participantes)
    public int calculateTotalPeople(int participants, int guides) {
        return participants + guides;
    }

    // Calcular la cantidad de buses necesarios (asumiendo capacidad de 40 personas por bus)
    public int calculateBusesNeeded(int totalPeople) {
        return (int) Math.ceil(totalPeople / 40.0); // Cada bus tiene capacidad para 40 personas
    }

    // Verificar si el clima es adecuado (ejemplo con temperatura entre 15 y 30 grados y humedad < 60%)
    public boolean goodWeather(double temperature, double humidity) {
        return temperature >= 15 && temperature <= 30 && humidity < 60;
    }

    // Obtener la ruta asociada
    public Route getRoute() {
        return route;
    }

    // Método toString para describir la caminata
    @Override
    public String toString() {
        return "Caminata: " + route.getAttribute() + ", Guías: " + guides + ", Participantes: " + participants;
    }
}


