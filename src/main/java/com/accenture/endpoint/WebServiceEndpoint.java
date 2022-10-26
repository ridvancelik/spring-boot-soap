package com.accenture.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ptl.PushPtlData;
import ptl.ObjectFactory;
import ptl.OutputSOATest;

@Endpoint
public class WebServiceEndpoint {

	private static final String NAMESPACE_URI = "urn:PTL";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "pushPtlData")
	@ResponsePayload
	public OutputSOATest hello(@RequestPayload PushPtlData request) {

		String outputString = "Hello " + request.getTest() + "!";

		ObjectFactory factory = new ObjectFactory();
		OutputSOATest response = factory.createOutputSOATest();
		response.setResult(outputString);

		return response;
	}
}
