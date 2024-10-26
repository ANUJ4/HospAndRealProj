package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class RotateOut extends AnimationFX {

	public RotateOut(Node node) {
		super(node);
	}

	public RotateOut() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		getNode().setRotate(0);
		return this;
	}

	protected void initTimeline() {
		getNode().setRotationAxis(Rotate.Z_AXIS);
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().rotateProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().rotateProperty(), 200, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE))));
	}
}
