package com.lab.animation;

import static javafx.scene.transform.Rotate.X_AXIS;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.util.Duration;

public class FlipInX extends AnimationFX {

	public FlipInX(Node node) {
		super(node);
	}

	public FlipInX() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		getNode().setRotate(0);
		return this;
	}

	protected void initTimeline() {
		getNode().getScene().setCamera(new PerspectiveCamera());
		getNode().setRotationAxis(X_AXIS);
		setTimeline(new Timeline(

				new KeyFrame(Duration.millis(0), new KeyValue(getNode().opacityProperty(), 0, Interpolator.EASE_IN),
						new KeyValue(getNode().rotateProperty(), -90, Interpolator.EASE_IN)

				), new KeyFrame(Duration.millis(400), new KeyValue(getNode().rotateProperty(), 20, Interpolator.EASE_IN)

				),
				new KeyFrame(Duration.millis(600), new KeyValue(getNode().rotateProperty(), -10, Interpolator.EASE_IN)

				),
				new KeyFrame(Duration.millis(800), new KeyValue(getNode().rotateProperty(), 5, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1000), new KeyValue(getNode().opacityProperty(), 1, Interpolator.EASE_IN),
						new KeyValue(getNode().rotateProperty(), 0, Interpolator.EASE_IN))

		));
		getTimeline().setOnFinished(event -> getNode().getScene().setCamera(new ParallelCamera()));

	}

}
