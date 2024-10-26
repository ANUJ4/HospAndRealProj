package com.lab.animation.partial;

import com.lab.animation.AnimateFXInterpolator;
import com.lab.animation.AnimationFX;
import com.lab.animation.ScaleAnimation;
import com.lab.modifier.IllegalModifierException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class Contract extends ScaleAnimation {

	public Contract(Node node) {
		super(node);
	}

	protected AnimationFX resetNode() {
		getNode().setScaleX(beginScale);
		getNode().setScaleY(beginScale);
		getNode().setScaleZ(beginScale);
		return this;
	}

	protected void initTimeline() {
		Double beginScale = this.beginScale;
		Double endScale = this.endScale;

		if (beginScale == null)
			beginScale = 1.05;

		if (endScale == null)
			endScale = 1.0;

		if (beginScale < endScale)
			throw new IllegalModifierException("beginScale must be bigger than endScale. Consider using the Expand animation.");

		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().scaleXProperty(), beginScale, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().scaleYProperty(), beginScale, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().scaleZProperty(), beginScale, AnimateFXInterpolator.EASE)),
				new KeyFrame(Duration.millis(500),
						new KeyValue(getNode().scaleXProperty(), endScale, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().scaleYProperty(), endScale, AnimateFXInterpolator.EASE),
						new KeyValue(getNode().scaleZProperty(), endScale, AnimateFXInterpolator.EASE))));
	}
}
