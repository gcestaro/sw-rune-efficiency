package com.github.gcestaro.models;

import java.math.BigDecimal;

public enum RuneGrade {

	NORMAL(5),
	MAGIC(6),
	RARE(7),
	HERO(8),
	LEGENDARY(9);

	private final BigDecimal maxHits;

	RuneGrade(int maxHits) {
		this.maxHits = BigDecimal.valueOf(maxHits);
	}

	public static RuneGrade randomGrade() {

		int randomNumber = (int) (Math.random() * 100) + 1;

		if (randomNumber > 90)
			return LEGENDARY;

		if (randomNumber > 60)
			return HERO;

		return RARE;
	}

	public BigDecimal getMaxHits() {
		return maxHits;
	}
}
