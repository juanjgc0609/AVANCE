package model;
import java.sql.Time;

public class Route {
    private Time start;
    private Time end;
    private String meetingPoint;
    private String attribute;

    // Obtener la hora de inicio
    public Time getStart() {
        return start;
    }

    // Establecer la hora de inicio
    public void setStart(Time start) {
        this.start = start;
    }

    // Obtener la hora de fin
    public Time getEnd() {
        return end;
    }

    // Establecer la hora de fin
    public void setEnd(Time end) {
        this.end = end;
    }

    // Obtener el punto de encuentro
    public String getMeetingPoint() {
        return meetingPoint;
    }

    // Establecer el punto de encuentro
    public void setMeetingPoint(String meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    // Obtener el atributo
    public String getAttribute() {
        return attribute;
    }

    // Establecer el atributo
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}

