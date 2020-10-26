package com.infobip.api.code.examples;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infobip.api.code.examples.model.Destination;
import com.infobip.api.code.examples.model.Message;
import com.infobip.api.code.examples.model.Sms;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendSms {

    private static final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    public static void main(String[] args)
        throws IOException {

        // Your settings
        String baseUrl = "insert_base_url_here";
        String receiverPhoneNumber = "insert_receiver_phone_number_here";

        Destination destination = new Destination();
        destination.setTo(receiverPhoneNumber);

        Message message = new Message();
        message.setFrom("InfoSMS");
        message.setDestinations(List.of(destination));
        message.setText("Hello from Infobip!");

        Sms sms = new Sms();
        sms.setMessages(List.of(message));

        String json = gson.toJson(sms);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(json, mediaType);

        Request request = new Request.Builder()
            .url(String.format("https://%s/sms/2/text/advanced", baseUrl))
            .method("POST", body)
            .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
    }
}
