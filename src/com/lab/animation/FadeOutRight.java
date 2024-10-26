package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeOutRight extends AnimationFX {

	public FadeOutRight(Node node) {
		super(node);
	}

	public FadeOutRight() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		getNode().setTranslateX(0);
		return this;
	}

	protected void initTimeline() {
		setTimeline(new Timeline(new KeyFrame(Duration.millis(0),
				new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE),
				new KeyValue(getNode().translateXProperty(), 0, AnimateFXInterpolator.EASE)

		), new KeyFrame(Duration.millis(1000), new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE),
				new KeyValue(getNode().translateXProperty(), getNode().getBoundsInParent().getWidth(),
						AnimateFXInterpolator.EASE)

		)));
	}
}
