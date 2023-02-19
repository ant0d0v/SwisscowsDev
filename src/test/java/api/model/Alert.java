package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Alert {
    private String sender_name;
    private String event;
    private Integer start;
    private Integer end;
    private String description;
    private ArrayList<String> tags;

    public Alert() {
    }

    public Alert(String sender_name, String event, Integer start, Integer end,
                 String description, ArrayList<String> tags) {
        this.sender_name = sender_name;
        this.event = event;
        this.start = start;
        this.end = end;
        this.description = description;
        this.tags = tags;
    }

    public String getEvent() {
        return event;
    }

    public String getSender_name() {
        return sender_name;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
