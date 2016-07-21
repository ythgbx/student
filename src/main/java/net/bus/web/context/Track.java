package net.bus.web.context;

/**
 * Created by Edifi_000 on 2016-07-21.
 */
public class Track {

    public enum Status {
        Goto, Arrive
    }

    public enum Direction {
        Forward, Reverse
    }

    private Position pos;
    private Long station;
    private Status status;
    private Direction direction;
}
