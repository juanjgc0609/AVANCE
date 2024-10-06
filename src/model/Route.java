package model;

import java.time.LocalTime;

public class Route {
    private LocalTime start;
    private LocalTime end;
    private String meetingPoint;
    private TypeRoute type;

    public Route(String start, String end, String meetingPoint, String type) {
        setStart(start);
        setEnd(end);
        this.meetingPoint = meetingPoint;
        setType(type);
    }

    // Obtener la hora de inicio
    public LocalTime getStart() {
        return start;
    }

    // Establecer la hora de inicio
    public void setStart(String start) {
        this.start = LocalTime.parse(start);
    }

    // Obtener la hora de fin
    public LocalTime getEnd() {
        return end;
    }

    // Establecer la hora de fin
    public void setEnd(String end) {
        this.end = LocalTime.parse(end);
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
