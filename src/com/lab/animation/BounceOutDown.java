package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class BounceOutDown extends AnimationFX {

	public BounceOutDown(final Node node) {
		super(node);
	}

	public BounceOutDown() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		getNode().setTranslateY(0);
		return this;
	}

	protected void initTimeline() {
		double endY = getNode().getScene().getHeight() - getNode().localToScene(0, 0).getY();
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(200),
						new KeyValue(getNode().translateYProperty(), 10, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(400),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().translateYProperty(), -20, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().translateYProperty(), endY))));
	}

}
