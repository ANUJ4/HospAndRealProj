package com.lab.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class HomeController implements Initializable {

	@FXML
	private Label label;

	@FXML
	private VBox pnl_scroll;

	@FXML
	private void handleButtonAction(MouseEvent event) {
		refreshNodes();
	}

	public void initialize(URL url, ResourceBundle rb) {
		refreshNodes();
	}

	private void refreshNodes() {
		pnl_scroll.getChildren().clear();

		Node[] nodes = new Node[15];

		for (int i = 0; i < 10; i++) {
			try {
				nodes[i] = (Node) FXMLLoader.load(getClass().getResource("/fxaml/Item.fxml"));
				pnl_scroll.getChildren().add(nodes[i]);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

}
