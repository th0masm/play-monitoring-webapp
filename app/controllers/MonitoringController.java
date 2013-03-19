package controllers;

import play.mvc.Controller;

public class MonitoringController extends Controller {

	/**
	 * Create page from null args
	 * 
	 */
	public static void create() {
		createForm("");
	}

	public static void createForm(String monitoring_server) {
		params.flash();
		renderTemplate("MonitoringController/create.html");
	}

	public static void createNew(String monitoring_server) {

		validation.required(monitoring_server);
		validation.isTrue(monitoring_server != null && (monitoring_server.startsWith("http://")));

		if (validation.hasErrors()) {
			params.flash();
			validation.keep();
			createForm(monitoring_server);
		}

		//Connection to BSM
  
		Boolean result = true;

		if (result != null) {
			flash.success("Connection success %s", result.toString());
		}
	}
	
	public static void charts(){
		render();
	}

	
}
