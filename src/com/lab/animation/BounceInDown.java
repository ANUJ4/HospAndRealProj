package com.lab.animation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class BounceInDown extends AnimationFX {

	public BounceInDown(Node node) {
		super(node);
	}

	public BounceInDown() {
	}

	
	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		getNode().setTranslateY(0);
		return this;
	}

	
	protected void initTimeline() {
		this.setTimeline(new Timeline(

				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().opacityProperty(), 0, Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000)),
						new KeyValue(getNode().translateYProperty(), -3000,
								Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000))),
				new KeyFrame(Duration.millis(600),
						new KeyValue(getNode().opacityProperty(), 1, Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000)),
						new KeyValue(getNode().translateYProperty(), 25,
								Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000))),
				new KeyFrame(Duration.millis(750),
						new KeyValue(getNode().translateYProperty(), -10,
								Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000))),
				new KeyFrame(Duration.millis(900),
						new KeyValue(getNode().translateYProperty(), 5,
								Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000))),
				new KeyFrame(Duration.millis(1000), new KeyValue(getNode().translateYProperty(), 0,
						Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000)))));
	}

}
