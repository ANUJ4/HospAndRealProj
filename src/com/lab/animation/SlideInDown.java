package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class SlideInDown extends SlideAnimation {

	public SlideInDown(Node node) {
		super(node);
	}

	public SlideInDown() {
	}

	protected AnimationFX resetNode() {
		getNode().setTranslateY(0);
		return this;
	}

	protected void initTimeline() {
		Double slideBy = this.slideBy;

		if (slideBy == null)
			slideBy = getNode().getBoundsInParent().getHeight();

		if (slideBy > 0.0)
			slideBy = -slideBy;

		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().translateYProperty(), slideBy, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().translateYProperty(), 0, AnimateFXInterpolator.EASE))));
	}
}
