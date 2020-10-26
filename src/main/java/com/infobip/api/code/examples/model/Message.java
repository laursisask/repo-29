package com.infobip.api.code.examples.model;

import java.util.List;

import lombok.Data;

@Data
public class Message {

    private String from;
    private List<Destination> destinations;
    private String text;
}
