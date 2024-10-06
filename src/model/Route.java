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

    public LocalTime getStart() {
        return start;
    }

    public void setStart(int hour, int minute) {
        this.start = LocalTime.of(hour, minute);
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(int hour, int minute) {
        this.end = LocalTime.of(hour, minute);
    }

    public String getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(String meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    public TypeRoute getType() {
        return type;
    }

    public void setType(String type) {
        this.type = TypeRoute.valueOf(type.toUpperCase());
    }

    @Override
    public String toString() {
        return "¡Excelente! La Ruta de " + type.toString().toLowerCase() + " tiene como punto de encuentro "
                + meetingPoint + " iniciando a las " + start.toString() + ", y termina a las " + end.toString();
    }
}
