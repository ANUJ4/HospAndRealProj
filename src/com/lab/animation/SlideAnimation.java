package com.lab.animation;

import com.lab.modifier.Modifier;
import com.lab.modifier.SlideModifier;

import javafx.scene.Node;

public abstract class SlideAnimation extends AnimationFX {

	protected Double slideBy;

	public SlideAnimation(Node node) {
		super(node);
	}

	public SlideAnimation() {
	}

	public AnimationFX applyAnimationModifier(Modifier modifier) {
		if (modifier == null)
			throw new NullPointerException("modifier cannot be null");

		if (!(modifier instanceof SlideModifier))
			throw new IllegalArgumentException(
					"The modifier instance must be from type SlideModifier, is: " + modifier.getClass().getName());

		slideBy = ((SlideModifier) modifier).getSlideBy().doubleValue();

		initTimeline();
		setAnimationStoppedListener();
		return this;
	}
}
