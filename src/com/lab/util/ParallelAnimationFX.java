package com.lab.util;

import com.lab.animation.AnimationFX;
import javafx.animation.Animation;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class ParallelAnimationFX {

	private Animation.Status status;

	private ObjectProperty<Node> node;

	public final ObjectProperty<Node> nodeProperty() {
		if (node == null) {
			node = new SimpleObjectProperty<>(this, "node", null);
		}
		return node;
	}

	private ObservableList<AnimationFX> animations = FXCollections.observableArrayList();

	public ParallelAnimationFX(Node node) {
		nodeProperty().set(node);
	}

	public ParallelAnimationFX(Node node, AnimationFX... animations) {
		nodeProperty().set(node);
		getAnimation().setAll(animations);
	}

	public ParallelAnimationFX(AnimationFX... animations) {
		getAnimation().setAll(animations);
	}

	public ParallelAnimationFX() {
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
		for (AnimationFX animation : animations) {
			if (nodeProperty().get() != null) {
				if (animation.getNode() == null) {
					animation.setNode(nodeProperty().get());
				}
			}
			animation.play();
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

	}
}
