package pl.sda.partyorganising.web.controller;

import pl.sda.partyorganising.entity.AccessToEvent;

import java.sql.Date;

public class CreateEventRequest {
    public Date date;
    public String name;
    public String address;
    public AccessToEvent accessToEvent;
}
