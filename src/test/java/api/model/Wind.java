package api.model;

public class Wind {
    private Double speed;
    private Integer deg;

    public Wind() {
    }

    public Wind(Double speed, Integer deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }
}
