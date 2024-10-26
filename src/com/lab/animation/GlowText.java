package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Labeled;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class GlowText extends AnimationFX {

	private final Paint originalPaint;

	public GlowText(Labeled node, Paint colorA, Paint colorB) {
		super(node);
		this.originalPaint = getNode().textFillProperty().get();
		getTimeline().getKeyFrames().addAll(
				new KeyFrame(Duration.millis(0), new KeyValue(getNode().textFillProperty(), colorA)),
				new KeyFrame(Duration.millis(500), new KeyValue(getNode().textFillProperty(), colorB)),
				new KeyFrame(Duration.millis(1000), new KeyValue(getNode().textFillProperty(), colorA)));
	}

	public GlowText(Paint originalPaint, Paint colorA, Paint colorB) {
		this.originalPaint = originalPaint;
	}

	public Labeled getNode() {
		return (Labeled) super.getNode();
	}

	protected AnimationFX resetNode() {
		getNode().setTextFill(originalPaint);
		return this;
	}

	protected void initTimeline() {
		setTimeline(new Timeline());
	}

}
