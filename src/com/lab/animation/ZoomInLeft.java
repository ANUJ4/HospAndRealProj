package com.lab.animation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class ZoomInLeft extends AnimationFX {

	public ZoomInLeft(Node node) {
		super(node);
	}

	public ZoomInLeft() {
	}

	protected AnimationFX resetNode() {
		getNode().setOpacity(1);
		getNode().setScaleX(1);
		getNode().setScaleY(1);
		getNode().setScaleZ(1);
		getNode().setTranslateX(0);
		return this;
	}

	protected void initTimeline() {
		setTimeline(new Timeline(
				new KeyFrame(Duration.millis(0),
						new KeyValue(getNode().translateXProperty(), -1000,
								Interpolator.SPLINE(0.55, 0.055, 0.675, 0.19)),
						new KeyValue(getNode().opacityProperty(), 0, Interpolator.SPLINE(0.55, 0.055, 0.675, 0.19)),
						new KeyValue(getNode().scaleXProperty(), 0.1, Interpolator.SPLINE(0.55, 0.055, 0.675, 0.19)),
						new KeyValue(getNode().scaleYProperty(), 0.1, Interpolator.SPLINE(0.55, 0.055, 0.675, 0.19)),
						new KeyValue(getNode().scaleZProperty(), 0.1, Interpolator.SPLINE(0.55, 0.055, 0.675, 0.19))),
				new KeyFrame(Duration.millis(400),
						new KeyValue(getNode().opacityProperty(), 1, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)),
						new KeyValue(getNode().translateXProperty(), 10, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)),
						new KeyValue(getNode().scaleXProperty(), 0.475, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)),
						new KeyValue(getNode().scaleYProperty(), 0.475, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)),
						new KeyValue(getNode().scaleZProperty(), 0.475, Interpolator.SPLINE(0.175, 0.885, 0.32, 1))),
				new KeyFrame(Duration.millis(1100),
						new KeyValue(getNode().translateXProperty(), 0, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)),
						new KeyValue(getNode().opacityProperty(), 1, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)),
						new KeyValue(getNode().scaleXProperty(), 1, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)),
						new KeyValue(getNode().scaleYProperty(), 1, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)),
						new KeyValue(getNode().scaleZProperty(), 1, Interpolator.SPLINE(0.175, 0.885, 0.32, 1)))));
	}

}
