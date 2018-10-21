package com.ucad.chat.entites;

import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessagesDecoder implements Decoder.Text<Messages>{

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Messages decode(final String textMessage) throws DecodeException {
		Messages message = new Messages();
		JsonObject jsonObject = Json.createReader(new StringReader(textMessage)).readObject();
		message.setContenu(jsonObject.getString("message"));
        message.setUtilisateur((Utilisateurs) jsonObject.getValue("utilisateur"));
        message.setDateEnvoie((new Date()));
		return message;
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		return false;
	}

}
