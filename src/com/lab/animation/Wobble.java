package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class Wobble extends AnimationFX {

	public Wobble(Node node) {
		super(node);
	}

	public Wobble() {
	}

	protected AnimationFX resetNode() {
		getNode().setTranslateX(0);
		getNode().setRotate(0);
		return this;
	}

	protected void initTimeline() {
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().translateXProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().rotateProperty(), -0, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(150),
						new KeyValue(getNode().translateXProperty(), -0.25 * getNode().getBoundsInParent().getWidth(),
								AnimateFXInterpolator.EASE),
						new KeyValue(getNode().rotateProperty(), -5, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(300),
						new KeyValue(getNode().translateXProperty(), 0.2 * getNode().getBoundsInParent().getWidth(),
								AnimateFXInterpolator.EASE),
						new KeyValue(getNode().rotateProperty(), 3, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(450),
						new KeyValue(getNode().translateXProperty(), -0.15 * getNode().getBoundsInParent().getWidth(),
								AnimateFXInterpolator.EASE),
						new KeyValue(getNode().rotateProperty(), -3, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(600),
						new KeyValue(getNode().translateXProperty(), 0.1 * getNode().getBoundsInParent().getWidth(),
								AnimateFXInterpolator.EASE),
						new KeyValue(getNode().rotateProperty(), 2, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(750),
						new KeyValue(getNode().translateXProperty(), -0.05 * getNode().getBoundsInParent().getWidth(),
								AnimateFXInterpolator.EASE),
						new KeyValue(getNode().rotateProperty(), -1, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().translateXProperty(), 0, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().rotateProperty(), 0, AnimateFXInterpolator.EASE))));
	}
}
