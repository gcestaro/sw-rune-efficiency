package com.github.gcestaro.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import lombok.Data;

@Data
public class RuneSlot {

	private Integer slot;

	private Integer stars;

	private RuneStat primaryStat;

	private RuneStat innateStat;

	private Set<RuneStat> subStats;

	public RuneSlot(Integer slot, Integer stars, RuneStat primaryStat, RuneStat innateStat) {
		this.slot = slot;
		this.stars = stars;
		this.innateStat = innateStat;
		this.subStats = new HashSet<>(4);

		this.primaryStat = primaryStat == null
				? StarDefaultValueFactory.getDefaultValue(slot, stars)
				: primaryStat;

		validatePrimaryStatMandatory();
	}

	public Optional<RuneStat> getInnateStat() {
		return Optional.ofNullable(innateStat);
	}

	public Set<RuneStat> getSubStats() {
		return Collections.unmodifiableSet(subStats);
	}

	public void addSubStat(RuneStat subStat) {
		if (subStats.size() < 4) {
			subStats.add(subStat);
		}
	}

	private void validatePrimaryStatMandatory() {
		if (this.primaryStat == null) {
			throw new IllegalArgumentException("Trying to create a rune without mainStat - " + this);
		}
	}

	public static RuneSlot randomSlot(RuneGrade grade) {
		return null;
	}
}
