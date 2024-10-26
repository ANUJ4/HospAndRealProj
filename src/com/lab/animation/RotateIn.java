package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class RotateIn extends AnimationFX {

	public RotateIn(Node node) {
		super(node);
	}

	public RotateIn() {
	}

	protected AnimationFX resetNode() {
		getNode().setRotate(0);
		getNode().setOpacity(1);
		return this;
	}

	protected void initTimeline() {
		getNode().setRotationAxis(Rotate.Z_AXIS);
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().rotateProperty(), -200, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().rotateProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE))));
	}

}
