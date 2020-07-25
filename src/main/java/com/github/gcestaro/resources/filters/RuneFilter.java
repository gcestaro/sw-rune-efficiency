package com.github.gcestaro.resources.filters;

import com.github.gcestaro.models.RuneSet;
import com.github.gcestaro.models.RuneStat;

import lombok.Data;

@Data
public class RuneFilter {

	private RuneSet set;

	private Integer slot;

	private Integer level;

	private RuneStat primaryStat;

	private RuneOrderFilter orderBy;

	public boolean isOrderedResult() {
		return orderBy != null;
	}

	public boolean filterByLevel() {
		return level != null;
	}

	public boolean filterByPrimaryStat() {
		return primaryStat != null;
	}

	public boolean filterBySlot() {
		return slot != null;
	}

	public boolean filterByRuneSet() {
		return set != null;
	}
}
