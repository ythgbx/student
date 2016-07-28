package net.bus.web.controller.dto;

/**
 * Created by sky on 16/7/28.
 */
public class SignResult extends BaseResult {


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private int points;
}
