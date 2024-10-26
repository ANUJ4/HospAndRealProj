package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class Flash extends AnimationFX {

	public Flash(Node node) {
		super(node);
	}

	public Flash() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		return this;
	}

	protected void initTimeline() {
		setTimeline(new Timeline(

				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(250),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(500),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(750),
						new KeyValue(getNode().opacityProperty(), 0, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().opacityProperty(), 1, AnimateFXInterpolator.EASE))

		));
	}

}
