package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeInDown extends AnimationFX {

	public FadeInDown(Node node) {
		super(node);
	}

	public FadeInDown() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		getNode().setTranslateY(0);
		return this;
	}

	protected void initTimeline() {
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().translateYProperty(), -getNode().getBoundsInParent().getHeight(),
								AnimateFXInterpolator.EASE)),

				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().translateYProperty(), 0, AnimateFXInterpolator.EASE))));
	}
}