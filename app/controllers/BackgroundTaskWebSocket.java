package controllers;

import models.Message;
import play.libs.F.EventStream;
import play.mvc.WebSocketController;

import com.google.gson.Gson;

public class BackgroundTaskWebSocket extends WebSocketController {
	
	public static EventStream<Message> liveStream = new EventStream<Message>();

	public static void pushNewMessage() {
		while (inbound.isOpen()) {
			Message message = await(liveStream.nextEvent());
			if (message != null) {
				String json = new Gson().toJson(message);
				outbound.send(json);
			}
		}
	}
}
