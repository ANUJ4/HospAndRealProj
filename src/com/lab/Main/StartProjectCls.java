package com.lab.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartProjectCls extends Application {

	public static Stage stage;

	
	public void start(Stage primaryStage) {
		try {

			primaryStage.initStyle(StageStyle.UNDECORATED);
			stage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("/fxaml/sample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
	}

	public void closeStage() {
		stage.close();
	}

}
