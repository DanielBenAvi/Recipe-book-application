package application;

import Controller.Controller;
import Model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainCookingBookNoFXML extends Application {

	@Override
	public void start(Stage primaryStage) {
		Model Model = new Model();
		View.View_All view_all = new View.View_All(primaryStage);
		@SuppressWarnings("unused")

		Controller theController = new Controller(Model, view_all);
	}

	public static void main(String[] args) {

		
			launch(args);

	}
}
