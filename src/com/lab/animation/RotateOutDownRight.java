package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class RotateOutDownRight extends AnimationFX {

	private Rotate rotate;

	public RotateOutDownRight(Node node) {
		super(node);
	}

	public RotateOutDownRight() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		rotate.setAngle(0);
		return this;
	}

	protected void initTimeline() {
		rotate = new Rotate(0, getNode().getBoundsInLocal().getWidth(), getNode().getBoundsInLocal().getHeight());
		getNode().getTransforms().add(rotate);
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0), new KeyValue(rotate.angleProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(rotate.angleProperty(), -45, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE))));
	}
}
