package com.lab.animation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class Bounce extends AnimationFX {

	public Bounce(Node node) {
		super(node);
	}

	public Bounce() {
		super();
	}

	
	public AnimationFX resetNode() {
		getNode().setTranslateY(0);
		return this;
	}

	
	protected void initTimeline() {
		setTimeline(new Timeline(

				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().translateYProperty(), 0,
								Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000))),
				new KeyFrame(Duration.millis(400),
						new KeyValue(getNode().translateYProperty(), -30,
								Interpolator.SPLINE(0.755, 0.050, 0.855, 0.060))),
				new KeyFrame(Duration.millis(550),
						new KeyValue(getNode().translateYProperty(), 0,
								Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000))),
				new KeyFrame(Duration.millis(700),
						new KeyValue(getNode().translateYProperty(), -15,
								Interpolator.SPLINE(0.755, 0.050, 0.855, 0.060))),
				new KeyFrame(Duration.millis(800),
						new KeyValue(getNode().translateYProperty(), 0,
								Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000))),
				new KeyFrame(Duration.millis(900),
						new KeyValue(getNode().translateYProperty(), -5,
								Interpolator.SPLINE(0.755, 0.050, 0.855, 0.060))),
				new KeyFrame(Duration.millis(1000), new KeyValue(getNode().translateYProperty(), 0,
						Interpolator.SPLINE(0.215, 0.610, 0.355, 1.000)))

		));
	}
}
