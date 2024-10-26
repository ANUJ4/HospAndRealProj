package com.lab.animation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.transform.Shear;
import javafx.util.Duration;

public class LightSpeedOut extends AnimationFX {

	private Shear shear;

	public LightSpeedOut(Node node) {
		super(node);
	}

	public LightSpeedOut() {
	}

	protected AnimationFX resetNode() {
		shear.setX(0);
		shear.setY(0);
		getNode().setOpacity(1);
		getNode().setTranslateX(0);
		return this;
	}

	protected void initTimeline() {
		shear = new Shear();
		getNode().getTransforms().add(shear);
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0), new KeyValue(shear.xProperty(), 0), new KeyValue(shear.yProperty(), 0),
						new KeyValue(getNode().opacityProperty(), 1, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1000),
						new KeyValue(getNode().translateXProperty(), getNode().getBoundsInParent().getWidth(),
								Interpolator.EASE_IN),
						new KeyValue(shear.xProperty(), 0.30), new KeyValue(shear.yProperty(), 0),
						new KeyValue(getNode().opacityProperty(), 0, Interpolator.EASE_IN))));
	}

}
