package utils;

import java.util.List;

public class ProjectConstants {

    public static final List<String> EXPECTED_STATES_NAMES = List.of(
            "Alabama", "Alaska", "Arizona", "Arkansas", "California",
            "Colorado", "Connecticut", "Delaware", "District of Columbia",
            "Florida", "Georgia", "Hawai`i", "Idaho", "Illinois", "Indiana",
            "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
            "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
            "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
            "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
            "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
            "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
            "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
    );

    public static final List<String> EXPECTED_WEATHER_PARAMETERS = List.of(
            "Temperature", "Min temperature", "Max temperature", "Feels like",
            "Wind (speed, direction)", "Pressure", "Humidity", "Clouds",
            "Weather conditions", "Rain", "Snow"
    );

    public static final String EXPECTED_WEATHER_PARAMETERS_AS_STRING =
            "Temperature, Min temperature, Max temperature, "
                    + "Feels like, Wind (speed, direction), Pressure, "
                    + "Humidity, Clouds, Weather conditions, Rain, Snow";

    public static final String WIDGETS_KEY = "057fdd4683cc49fa82b0cb45a668f0ad";

    public static final String FIRST_NAME = "Test";
    public static final String LAST_NAME = "User";
    public static final String PHONE_NUMBER = "1234567890";
    public static final String EMAIL = "test@example.com";
    public static final String SUBJECT = "Other";
    public static final String MESSAGE_TEXT = "Message";

    public static final int WIDTH_HAMBURGER_MENU = 1020;
    public static final int HEIGHT_HAMBURGER_MENU = 880;
}
