package com.infobip.api.code.examples.model;

import java.util.List;

import lombok.Data;

@Data
public class Sms {

    private List<Message> messages;
}
