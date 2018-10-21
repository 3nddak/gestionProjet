package com.ucad.chat.entites;

import javax.json.Json;
import javax.json.JsonValue;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessagesEncoder implements Encoder.Text<Messages>{

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(final Messages message) throws EncodeException {
		
		return Json.createObjectBuilder()
				.add("contenu", message.getContenu())
				.add("utilisateur", (JsonValue) message.getUtilisateur())
				.add("dateEnvoie", (JsonValue) message.getDateEnvoie())
				.build().toString();
	}

}
