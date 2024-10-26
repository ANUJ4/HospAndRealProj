package com.lab.animation;

import static javafx.scene.transform.Rotate.Y_AXIS;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.util.Duration;

public class FlipOutY extends AnimationFX {

	public FlipOutY(Node node) {
		super(node);
	}

	public FlipOutY() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		getNode().setRotate(0);
		return this;
	}

	protected void initTimeline() {
		getNode().getScene().setCamera(new PerspectiveCamera());
		getNode().setRotationAxis(Y_AXIS);
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(225),
						new KeyValue(getNode().rotateProperty(), 15, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(750),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().rotateProperty(), -90, AnimateFXInterpolator.EASE))));
		getTimeline().setOnFinished(event -> getNode().getScene().setCamera(new ParallelCamera()));

	}

}
