package model;

import java.time.LocalTime;

public class Route {
    private LocalTime start;
    private LocalTime end;
    private String meetingPoint;
    private TypeRoute type;

    public Route(int startHour, int startMinute, int endHour, int endMinute, String meetingPoint, String type) {
        setStart(startHour, startMinute);
        setEnd(endHour, endMinute);
        this.meetingPoint = meetingPoint;
        setType(type);
    }

    // Obtener la hora de inicio
    public LocalTime getStart() {
        return start;
    }

    // Establecer la hora de inicio
    public void setStart(int hour, int minute) {
        this.start = LocalTime.of(hour, minute);
    }

    // Obtener la hora de fin
    public LocalTime getEnd() {
        return end;
    }

    // Establecer la hora de fin
    public void setEnd(int hour, int minute) {
        this.end = LocalTime.of(hour, minute);
    }

    // Obtener el punto de encuentro
    public String getMeetingPoint() {
        return meetingPoint;
    }

    // Establecer el punto de encuentro
    public void setMeetingPoint(String meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    // Obtener el tipo de ruta
    public TypeRoute getType() {
        return type;
    }

    // Establecer el tipo de ruta
    public void setType(String type) {
        this.type = TypeRoute.valueOf(type.toUpperCase());
    }
}
