package model;

public class Walk {
    private Route route;
    private int participants;
    private int guides;
    private double temperature;
    private double humidity;
    private Volunteer volunteer;

    /**
     * Constructor para crear una nueva caminata.
     * @param route Ruta de la caminata.
     * @param participants Número de participantes.
     * @param guides Número de guías.
     * @param volunteer Voluntario responsable de la caminata.
     * @param temperature Temperatura durante la caminata.
     * @param humidity Humedad durante la caminata.
     */
    public Walk(Route route, int participants, int guides, Volunteer volunteer, double temperature, double humidity) {
        this.route = route;
        this.guides = guides;
        this.participants = participants;
        this.volunteer = volunteer;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    /**
     * Obtiene la cantidad de guías en la caminata.
     * @return Número de guías.
     */
    public int getGuides() {
        return guides;
    }

    /**
     * Obtiene la cantidad de participantes en la caminata.
     * @return Número de participantes.
     */
    public int getParticipants() {
        return participants;
    }

    /**
     * Calcula el total de personas en la caminata (guías + participantes).
     * @return Total de personas.
     */
    public int calculateTotalPeople() {
        return participants + guides;
    }

    /**
     * Calcula la cantidad de buses necesarios para la caminata.
     * Asume que cada bus tiene una capacidad de 25 personas.
     * @param totalPeople Número total de personas en la caminata.
     * @return Número de buses necesarios.
     */
    public int calculateBusesNeeded(int totalPeople) {
        return (int) Math.ceil(totalPeople / 25.0); // Cada bus tiene capacidad para 25 personas
    }

    /**
     * Verifica si las condiciones climáticas son adecuadas para la caminata.
     * Considera que la temperatura debe estar entre 15 y 30 grados y la humedad debe ser menor al 60%.
     * @return true si el clima es adecuado, de lo contrario false.
     */
    public boolean goodWeather() {
        return temperature >= 15 && temperature <= 30 && humidity < 60;
    }

    /**
     * Obtiene la ruta de la caminata.
     * @return La ruta de la caminata.
     */
    public Route getRoute() {
        return route;
    }

    /**
     * Establece una nueva ruta para la caminata.
     * @param route Nueva ruta.
     */
    public void setRoute(Route route) {
        this.route = route;
    }

    /**
     * Establece el número de participantes en la caminata.
     * @param participants Número de participantes.
     */
    public void setParticipants(int participants) {
        this.participants = participants;
    }

    /**
     * Establece el número de guías en la caminata.
     * @param guides Número de guías.
     */
    public void setGuides(int guides) {
        this.guides = guides;
    }

    /**
     * Obtiene la temperatura registrada durante la caminata.
     * @return Temperatura.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Establece una nueva temperatura para la caminata.
     * @param temperature Nueva temperatura.
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Obtiene la humedad registrada durante la caminata.
     * @return Humedad.
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Establece una nueva humedad para la caminata.
     * @param humidity Nueva humedad.
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * Obtiene el voluntario responsable de la caminata.
     * @return Voluntario de la caminata.
     */
    public Volunteer getVolunteer() {
        return volunteer;
    }

    /**
     * Establece un nuevo voluntario responsable de la caminata.
     * @param volunteer Nuevo voluntario.
     */
    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    /**
     * Método toString para describir la caminata.
     * @return Una cadena que describe la caminata con la ruta, cantidad de guías y participantes.
     */
    @Override
    public String toString() {
        return "Caminata: " + route.getType() + ", Guías: " + guides + ", Participantes: " + participants;
    }
}
