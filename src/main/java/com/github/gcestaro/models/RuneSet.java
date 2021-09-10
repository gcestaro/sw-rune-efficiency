package com.github.gcestaro.models;

import java.util.stream.Stream;

public enum RuneSet {
	ENERGY,
	GUARD,
	SWIFT,
	BLADE,
	RAGE,
	FOCUS,
	ENDURE,
	FATAL,
	DESPAIR,
	VAMPIRE,
	VIOLENT,
	NEMESIS,
	WILL,
	SHIELD,
	REVENGE,
	DESTROY,
	FIGHT,
	DETERMINATION,
	ENHANCE,
	ACCURACY,
	TOLERANCE;

	public static RuneSet randomSet() {
		return Stream.of(values()).findAny().get();
	}
}
