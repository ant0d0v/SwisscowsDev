package api.model;

public class Weather {
    private String icon;
    private String description;
    private String main;
    private Integer id;

    public Weather() {
    }

    public Weather(String icon, String description, String main, Integer id) {
        this.icon = icon;
        this.description = description;
        this.main = main;
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
