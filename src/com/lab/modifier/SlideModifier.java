package com.lab.modifier;

public class SlideModifier implements Modifier {

	private Number slideBy;

	public SlideModifier() {
	}

	public SlideModifier(Number slideBy) {
		this.slideBy = slideBy;
	}

	public Number getSlideBy() {
		return slideBy;
	}

	public void setSlideBy(Number slideBy) {
		this.slideBy = slideBy;
	}
}
