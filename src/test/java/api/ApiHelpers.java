package api;

import org.json.JSONObject;

import java.util.List;

public class ApiHelpers {

    public static String getFormattedResult(List<String> list) {
        return list
                .toString()
                .replaceAll(".$", "")
                .replaceAll("^.", "");
    }

    public static String getEightDaysForecastCalendar(JSONObject weatherObj) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            sb
                    .append(new java.util.Date((
                                    (weatherObj
                                            .getJSONArray("daily")
                                            .getJSONObject(0)
                                            .getLong("dt")) * 1000)
                            )
                                    .toString()
                                    .split(" ")[j]
                    )
                    .append(" ");
        }

        return sb.toString();
    }

    public static String getEightDaysForecastCalendarWithSeparator(JSONObject weatherObj) {
        String separator;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                separator = (j == 1) ? " " : ", ";
                sb
                        .append(new java.util.Date(((
                                        weatherObj
                                                .getJSONArray("daily")
                                                .getJSONObject(i)
                                                .getLong("dt")) * 1000)
                                )
                                        .toString()
                                        .split(" ")[j]
                        )
                        .append(separator);
            }
        }

        return sb.toString();
    }

    public static String getCurrentTemp(JSONObject weatherObj) {
        StringBuilder sb = new StringBuilder();

        sb.append(Math.round(weatherObj.getJSONObject("current")
                .getDouble("temp")));

        return sb.toString();
    }

    public static String getCurrentPressure(JSONObject obj) {

        return String.valueOf(obj.getJSONObject("current").getInt("pressure"));
    }

    public static String getCurrentHumidity(JSONObject obj) {

        return String.valueOf(obj.getJSONObject("current").getInt("humidity"));
    }
}
