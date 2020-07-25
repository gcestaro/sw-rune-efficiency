package com.github.gcestaro.resources.filters;

import java.util.Comparator;

import com.github.gcestaro.models.Rune;

public enum RuneOrderFilter {

	EFFICIENCY_ASC(Comparator.comparing(Rune::getEfficiency)),
	EFFICIENCY_DESC(Comparator.comparing(Rune::getEfficiency).reversed()),
	LEVEL(Comparator.comparing(Rune::getLevel));

	private final Comparator<Rune> comparator;

	RuneOrderFilter(Comparator<Rune> comparator) {
		this.comparator = comparator;
	}

	public Comparator<Rune> getComparator() {
		return comparator;
	}
}
