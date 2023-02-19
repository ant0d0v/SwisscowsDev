package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    @JsonProperty("1h")
    private Double _1h;

    public Rain() {
    }

    public Rain(Double _1h) {
        this._1h = _1h;
    }

    public Double get_1h() {
        return _1h;
    }
}
