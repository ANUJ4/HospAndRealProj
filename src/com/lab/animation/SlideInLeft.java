package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class SlideInLeft extends SlideAnimation {

	public SlideInLeft(Node node) {
		super(node);
	}

	public SlideInLeft() {
	}

	protected AnimationFX resetNode() {
		getNode().setTranslateX(0);
		return this;
	}

	protected void initTimeline() {
		Double slideBy = this.slideBy;

		if (slideBy == null)
			slideBy = getNode().getBoundsInParent().getWidth();

		if (slideBy > 0.0)
			slideBy = -slideBy;

		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().translateXProperty(), slideBy, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().translateXProperty(), 0, AnimateFXInterpolator.EASE))));
	}
}
