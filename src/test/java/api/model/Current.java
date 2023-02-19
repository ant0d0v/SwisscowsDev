package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    private Integer sunrise;
    private Double temp;
    private Integer visibility;
    private Integer uvi;
    private Integer pressure;
    private Integer clouds;
    private Double feels_like;
    private Integer dt;
    private Integer wind_deg;
    private Double dew_point;
    private Integer sunset;
    private ArrayList<Weather> weather;
    private Integer humidity;
    private Double wind_speed;

    public Current() {
    }

    public Current(Integer sunrise, Double temp, Integer visibility, Integer uvi, Integer pressure, Integer clouds,
                   Double feels_like, Integer dt, Integer wind_deg, Double dew_point, Integer sunset,
                   ArrayList<Weather> weather, Integer humidity, Double wind_speed) {
        this.sunrise = sunrise;
        this.temp = temp;
        this.visibility = visibility;
        this.uvi = uvi;
        this.pressure = pressure;
        this.clouds = clouds;
        this.feels_like = feels_like;
        this.dt = dt;
        this.wind_deg = wind_deg;
        this.dew_point = dew_point;
        this.sunset = sunset;
        this.weather = weather;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getUvi() {
        return uvi;
    }

    public void setUvi(Integer uvi) {
        this.uvi = uvi;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(Integer wind_deg) {
        this.wind_deg = wind_deg;
    }

    public Double getDew_point() {
        return dew_point;
    }

    public void setDew_point(Double dew_point) {
        this.dew_point = dew_point;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }
}
