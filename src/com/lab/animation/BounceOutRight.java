package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class BounceOutRight extends AnimationFX {

	public BounceOutRight(final Node node) {
		super(node);
	}

	public BounceOutRight() {
	}

	protected AnimationFX resetNode() {
		getNode().setTranslateX(0);
		getNode().setOpacity(1);
		return this;
	}

	protected void initTimeline() {
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(200),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().translateXProperty(), -20, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().translateXProperty(), 2000, AnimateFXInterpolator.EASE))));
	}

}
