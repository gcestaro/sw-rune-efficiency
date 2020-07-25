package com.github.gcestaro.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RuneStat {

	private Stat stat;

	private BigDecimal value;

	@Deprecated
	public RuneStat() {
	}

	public RuneStat(Stat stat, BigDecimal value) {
		this.stat = stat;
		this.value = value;
	}

	public RuneStat(Stat stat, Long value) {
		this(stat, BigDecimal.valueOf(value));
	}

	public RuneStat(Stat stat, Integer value) {
		this(stat, BigDecimal.valueOf(value));
	}

	public RuneStat(Stat stat, Double value) {
		this(stat, BigDecimal.valueOf(value));
	}

	public Stat getStat() {
		return stat;
	}

	public BigDecimal getValue() {
		return value;
	}
}
