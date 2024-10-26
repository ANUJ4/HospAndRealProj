package com.lab.animation;

import com.lab.modifier.Modifier;
import com.lab.modifier.ScaleModifier;
import javafx.scene.Node;

public abstract class ScaleAnimation extends AnimationFX {

	protected Double beginScale;
	protected Double endScale;

	public ScaleAnimation() {
	}

	public ScaleAnimation(Node node) {
		super(node);
	}

	public AnimationFX applyAnimationModifier(Modifier modifier) {
		if (modifier == null)
			throw new NullPointerException("modifier cannot be null");

		if (!(modifier instanceof ScaleModifier))
			throw new IllegalArgumentException(
					"The modifier instance must be from type ScaleModifier, is: " + modifier.getClass().getName());
		ScaleModifier sm = (ScaleModifier) modifier;
		beginScale = sm.getBeginScale().doubleValue();
		endScale = sm.getEndScale().doubleValue();

		initTimeline();
		setAnimationStoppedListener();
		return this;
	}
}
