package com.lab.util;

import com.lab.animation.AnimationFX;
import javafx.animation.Animation;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class SequentialAnimationFX {

	private Animation.Status status;

	private ObjectProperty<Node> node;

	private boolean reset;

	public final ObjectProperty<Node> nodeProperty() {
		if (node == null) {
			node = new SimpleObjectProperty<>(this, "node", null);
		}
		return node;
	}

	private ObservableList<AnimationFX> animations = FXCollections.observableArrayList();

	public SequentialAnimationFX(Node node) {
		nodeProperty().set(node);
		reset = false;
	}

	public SequentialAnimationFX(Node node, AnimationFX... animations) {
		nodeProperty().set(node);
		getAnimation().setAll(animations);
		reset = false;
	}

	public SequentialAnimationFX(AnimationFX... animations) {
		getAnimation().setAll(animations);
		reset = false;
	}

	public SequentialAnimationFX() {
	}

	public final ObservableList<AnimationFX> getAnimation() {
		return animations;
	}

	public void setNode(Node value) {
		if ((node != null) || (value != null)) {
			nodeProperty().set(value);
		}
	}

	public void play() {
		initAnimations();
		getAnimation().get(0).play();
		status = Animation.Status.RUNNING;
	}

	private void initAnimations() {
		for (int i = 0; i < getAnimation().size() - 1; i++) {
			if (nodeProperty().get() != null) {
				if (getAnimation().get(i).getNode() == null) {
					getAnimation().get(i).setNode(nodeProperty().get());
				}
			}
			if (getAnimation().get(i + 1) != null) {
				getAnimation().get(i).playOnFinished(getAnimation().get(i + 1));
			}
		}
		
		if (nodeProperty().get() != null) {
			if (getAnimation().get(getAnimation().size() - 1).getNode() == null) {
				getAnimation().get(getAnimation().size() - 1).setNode(nodeProperty().get());
			}
		}
		if (reset) {
			getAnimation().get(getAnimation().size() - 1).setResetOnFinished(true);
		}
	}

	public void stop() {
		status = Animation.Status.STOPPED;
		for (AnimationFX animationFX : animations) {
			animationFX.stop();
		}
	}

	public Animation.Status getStatus() {
		return status;
	}

	public void setResetOnFinished(boolean value) {
		this.reset = value;
	}
}
