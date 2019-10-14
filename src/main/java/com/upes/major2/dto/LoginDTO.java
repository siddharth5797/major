package com.upes.major2.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {
    private String date;
    private String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
