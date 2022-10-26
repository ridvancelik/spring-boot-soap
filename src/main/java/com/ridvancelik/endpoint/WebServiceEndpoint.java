package com.ridvancelik.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.github_com.ridvancelik.HelloWorldRes;
import https.github_com.ridvancelik.HelloWorldReq;

@Endpoint
public class WebServiceEndpoint {

    private static final String NAMESPACE_URI = "https://github.com/ridvancelik";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "helloWorldReq")
    @ResponsePayload
    public HelloWorldRes sayHello(@RequestPayload HelloWorldReq request) {
        String outputString = "Hello " + request.getName() + "!";

        HelloWorldRes response = new HelloWorldRes();
        response.setGreetingMessage(outputString);

        return response;
    }
}