import models.Message;
import play.jobs.Every;
import play.jobs.Job;
import controllers.BackgroundTaskWebSocket;

@Every("3s")
public class BackgroundJob extends Job {

	public void doJob() throws Exception {
		Message message = new Message();
		message.title = "Ping";
		message.content = "...";
		BackgroundTaskWebSocket.liveStream.publish(message);
	}
}
