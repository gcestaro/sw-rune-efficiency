package com.github.gcestaro.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class RuneHitCounter {

	public static BigDecimal countHits(RuneStat runeStat) {

		return HIT_RUNES_POOL
				.stream()
				.filter(hit -> hit.getStat() == runeStat.getStat())
				.findFirst()
				.map(hit -> runeStat.getValue().divide(hit.getMaxHit(), 5, RoundingMode.HALF_EVEN))
				.orElse(BigDecimal.ZERO);
	}

	private static final RuneHit ACCURACY_HIT = new RuneHit(Stat.ACCURACY, 8);
	private static final RuneHit RESISTANCE_HIT = new RuneHit(Stat.RESISTANCE, 8);
	private static final RuneHit HP_PERCENT_HIT = new RuneHit(Stat.HP_PERCENT, 8);
	private static final RuneHit DEF_PERCENT_HIT = new RuneHit(Stat.DEF_PERCENT, 8);
	private static final RuneHit ATK_PERCENT_HIT = new RuneHit(Stat.ATK_PERCENT, 8);

	private static final RuneHit CD_HIT = new RuneHit(Stat.CRITICAL_DMG, 7);

	private static final RuneHit SPEED_HIT = new RuneHit(Stat.SPEED, 6);
	private static final RuneHit CR_HIT = new RuneHit(Stat.CRITICAL_RATE, 6);

	private static final RuneHit DEF_HIT = new RuneHit(Stat.DEF, 20);
	private static final RuneHit ATK_HIT = new RuneHit(Stat.ATK, 20);

	private static final RuneHit HP_HIT = new RuneHit(Stat.HP, 375);

	public static final Set<RuneHit> HIT_RUNES_POOL = new HashSet<>();

	static {
		HIT_RUNES_POOL.add(ACCURACY_HIT);
		HIT_RUNES_POOL.add(RESISTANCE_HIT);
		HIT_RUNES_POOL.add(HP_PERCENT_HIT);
		HIT_RUNES_POOL.add(DEF_PERCENT_HIT);
		HIT_RUNES_POOL.add(ATK_PERCENT_HIT);

		HIT_RUNES_POOL.add(CD_HIT);

		HIT_RUNES_POOL.add(SPEED_HIT);
		HIT_RUNES_POOL.add(CR_HIT);

		HIT_RUNES_POOL.add(DEF_HIT);
		HIT_RUNES_POOL.add(ATK_HIT);

		HIT_RUNES_POOL.add(HP_HIT);
	}

	public static class RuneHit {

		private final Stat stat;
		private final BigDecimal maxHit;

		public RuneHit(Stat stat, int maxHit) {
			this.stat = stat;
			this.maxHit = BigDecimal.valueOf(maxHit);
		}

		public BigDecimal getMaxHit() {
			return maxHit;
		}

		public Stat getStat() {
			return stat;
		}
	}
}
