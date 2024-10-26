package com.lab.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class GlowBackground extends AnimationFX {

	private final Background originalBackground;
	private CornerRadii originalRadii;
	private Insets originalInsets;

	public GlowBackground(Region node, Color colorA, Color colorB, int colorSteps) {
		super(node);
		this.originalBackground = getNode().backgroundProperty().get();
		if (originalBackground != null && !originalBackground.getFills().isEmpty()) {
			BackgroundFill lastFill = originalBackground.getFills().get(originalBackground.getFills().size() - 1);
			originalRadii = lastFill.getRadii();
			originalInsets = lastFill.getInsets();
		} else {
			originalRadii = CornerRadii.EMPTY;
			originalInsets = Insets.EMPTY;
		}

		int totalFrames = colorSteps * 2;
		double millisPerFrame = 1000 / totalFrames;
		for (int i = 0; i < totalFrames; i++) {
			Color color;
			double frac = i * 2.0 / totalFrames;
			Duration dur = Duration.millis(i * millisPerFrame);
			if (i <= colorSteps) {
				color = colorA.interpolate(colorB, frac);
			} else {
				color = colorB.interpolate(colorA, frac - 1);
			}
			getTimeline().getKeyFrames().add(new KeyFrame(dur, new KeyValue(getNode().backgroundProperty(),
			new Background(new BackgroundFill(color, originalRadii, originalInsets)))));
		}

	}

	public GlowBackground(Background originalBackground) {
		this.originalBackground = originalBackground;
	}

	public Region getNode() {
		return (Region) super.getNode();
	}

	protected AnimationFX resetNode() {
		getNode().setBackground(originalBackground);
		return this;
	}

	protected void initTimeline() {
		setTimeline(new Timeline());
	}

}
