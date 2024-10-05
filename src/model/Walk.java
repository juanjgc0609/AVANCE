package model;

public class Walk {
    private Route route;
    private int participants;
    private int guides;
    private double temperature;
    private double humidity;
    private Volunteer volunteer;

    // Constructor para Walk
    public Walk(Route route, int participants, int guides, Volunteer volunteer, double temperature, double humidity) {
        this.route = route;
        this.guides = guides;
        this.participants = participants;
        this.volunteer = volunteer;
        this.temperature = temperature;
        this.humidity = humidity;
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
    public int calculateTotalPeople() {
        return participants + guides;
    }

    // Calcular la cantidad de buses necesarios (asumiendo capacidad de 40 personas
    // por bus)
    public int calculateBusesNeeded(int totalPeople) {
        return (int) Math.ceil(totalPeople / 25.0); // Cada bus tiene capacidad para 40 personas
    }

    // Verificar si el clima es adecuado (ejemplo con temperatura entre 15 y 30
    // grados y humedad < 60%)
    public boolean goodWeather() {
        return temperature >= 15 && temperature <= 30 && humidity < 60;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public void setGuides(int guides) {
        this.guides = guides;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    // Método toString para describir la caminata
    @Override
    public String toString() {
        return "Caminata: " + route.getType() + ", Guías: " + guides + ", Participantes: " + participants;
    }
}
