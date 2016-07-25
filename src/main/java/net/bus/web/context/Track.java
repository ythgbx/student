package net.bus.web.context;

/**
 * Created by Edifi_000 on 2016-07-21.
 */
public class Track {

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Long getStation() {
        return station;
    }

    public void setStation(Long station) {
        this.station = station;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        Start, Goto, Arrive,End
    }

    private Position pos;
    private Long station;
    private Status status;

}
