package com.github.gcestaro.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class StarDefaultValueFactory {

	public static RuneStat getDefaultValue(Stat stat, Integer stars) {
		return new RuneStat(Stat.ATK, RUNE_POOL.stream()
				.filter(rune -> rune.stars == stars)
				.filter(rune -> rune.stat == stat)
				.findAny()
				.orElseThrow(IllegalArgumentException::new)
				.getInitialValue());
	}

	public static RuneStat getDefaultValue(Integer slot, Integer stars) {

		final Stat stat;
		if (slot == 1) {
			stat = Stat.ATK;
		} else if (slot == 3) {
			stat = Stat.DEF;
		} else if (slot == 5) {
			stat = Stat.HP;
		} else {
			return null;
		}

		return getDefaultValue(stat, stars);
	}

	public static final PrimaryStatChanges HP_FLAT_RUNE_5 = new PrimaryStatChanges(5, Stat.HP, 270, 105, 2088);
	public static final PrimaryStatChanges HP_RUNE_5 = new PrimaryStatChanges(5, Stat.HP_PERCENT, 8.0, 2.45, 51.0);
	public static final PrimaryStatChanges ATK_FLAT_RUNE_5 = new PrimaryStatChanges(5, Stat.ATK, 15, 7, 135);
	public static final PrimaryStatChanges ATK_RUNE_5 = new PrimaryStatChanges(5, Stat.ATK_PERCENT, 8.0, 2.45, 51.0);
	public static final PrimaryStatChanges DEF_FLAT_RUNE_5 = new PrimaryStatChanges(5, Stat.DEF, 15, 7, 135);
	public static final PrimaryStatChanges DEF_RUNE_5 = new PrimaryStatChanges(5, Stat.DEF_PERCENT, 8.0, 2.45, 51.0);
	public static final PrimaryStatChanges SPD_RUNE_5 = new PrimaryStatChanges(5, Stat.SPEED, 5, 2, 39);
	public static final PrimaryStatChanges CR_RUNE_5 = new PrimaryStatChanges(5, Stat.CRITICAL_RATE, 5.0, 2.45, 47.0);
	public static final PrimaryStatChanges CD_RUNE_5 = new PrimaryStatChanges(5, Stat.CRITICAL_DMG, 8.0, 3.33, 65.0);
	public static final PrimaryStatChanges RES_RUNE_5 = new PrimaryStatChanges(5, Stat.RESISTANCE, 9.0, 2.45, 51.0);
	public static final PrimaryStatChanges ACC_RUNE_5 = new PrimaryStatChanges(5, Stat.ACCURACY, 9.0, 2.45, 51.0);

	public static final PrimaryStatChanges HP_FLAT_RUNE_6 = new PrimaryStatChanges(6, Stat.HP, 360, 120, 2448);
	public static final PrimaryStatChanges HP_RUNE_6 = new PrimaryStatChanges(6, Stat.HP_PERCENT, 11.0, 3.0, 63.0);
	public static final PrimaryStatChanges ATK_FLAT_RUNE_6 = new PrimaryStatChanges(6, Stat.ATK, 22, 8, 160);
	public static final PrimaryStatChanges ATK_RUNE_6 = new PrimaryStatChanges(6, Stat.ATK_PERCENT, 11.0, 3.0, 63.0);
	public static final PrimaryStatChanges DEF_FLAT_RUNE_6 = new PrimaryStatChanges(6, Stat.DEF, 22, 8, 160);
	public static final PrimaryStatChanges DEF_RUNE_6 = new PrimaryStatChanges(6, Stat.DEF_PERCENT, 11.0, 3.0, 63.0);
	public static final PrimaryStatChanges SPD_RUNE_6 = new PrimaryStatChanges(6, Stat.SPEED, 7, 2, 42);
	public static final PrimaryStatChanges CR_RUNE_6 = new PrimaryStatChanges(6, Stat.CRITICAL_RATE, 7.0, 3.0, 58.0);
	public static final PrimaryStatChanges CD_RUNE_6 = new PrimaryStatChanges(6, Stat.CRITICAL_DMG, 11.0, 4.0, 80.0);
	public static final PrimaryStatChanges RES_RUNE_6 = new PrimaryStatChanges(6, Stat.RESISTANCE, 12.0, 3.0, 64.0);
	public static final PrimaryStatChanges ACC_RUNE_6 = new PrimaryStatChanges(6, Stat.ACCURACY, 12.0, 3.0, 64.0);

	public static final Set<PrimaryStatChanges> RUNE_POOL = new HashSet<>();

	static {
		RUNE_POOL.add(HP_FLAT_RUNE_5);
		RUNE_POOL.add(HP_RUNE_5);
		RUNE_POOL.add(ATK_FLAT_RUNE_5);
		RUNE_POOL.add(ATK_RUNE_5);
		RUNE_POOL.add(DEF_FLAT_RUNE_5);
		RUNE_POOL.add(DEF_RUNE_5);
		RUNE_POOL.add(SPD_RUNE_5);
		RUNE_POOL.add(CR_RUNE_5);
		RUNE_POOL.add(CD_RUNE_5);
		RUNE_POOL.add(RES_RUNE_5);
		RUNE_POOL.add(ACC_RUNE_5);

		RUNE_POOL.add(HP_FLAT_RUNE_6);
		RUNE_POOL.add(HP_RUNE_6);
		RUNE_POOL.add(ATK_FLAT_RUNE_6);
		RUNE_POOL.add(ATK_RUNE_6);
		RUNE_POOL.add(DEF_FLAT_RUNE_6);
		RUNE_POOL.add(DEF_RUNE_6);
		RUNE_POOL.add(SPD_RUNE_6);
		RUNE_POOL.add(CR_RUNE_6);
		RUNE_POOL.add(CD_RUNE_6);
		RUNE_POOL.add(RES_RUNE_6);
		RUNE_POOL.add(ACC_RUNE_6);
	}

	public static final Set<PrimaryStatChanges> FIVE_STAR_RUNE_POOL = new HashSet<>();
	
	static {
		FIVE_STAR_RUNE_POOL.add(HP_FLAT_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(HP_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(ATK_FLAT_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(ATK_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(DEF_FLAT_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(DEF_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(SPD_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(CR_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(CD_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(RES_RUNE_5);
		FIVE_STAR_RUNE_POOL.add(ACC_RUNE_5);
	}
	
	public static final Set<PrimaryStatChanges> SIX_STAR_RUNE_POOL = new HashSet<>();
	
	static {
		SIX_STAR_RUNE_POOL.add(HP_FLAT_RUNE_6);
		SIX_STAR_RUNE_POOL.add(HP_RUNE_6);
		SIX_STAR_RUNE_POOL.add(ATK_FLAT_RUNE_6);
		SIX_STAR_RUNE_POOL.add(ATK_RUNE_6);
		SIX_STAR_RUNE_POOL.add(DEF_FLAT_RUNE_6);
		SIX_STAR_RUNE_POOL.add(DEF_RUNE_6);
		SIX_STAR_RUNE_POOL.add(SPD_RUNE_6);
		SIX_STAR_RUNE_POOL.add(CR_RUNE_6);
		SIX_STAR_RUNE_POOL.add(CD_RUNE_6);
		SIX_STAR_RUNE_POOL.add(RES_RUNE_6);
		SIX_STAR_RUNE_POOL.add(ACC_RUNE_6);
	}
	
	private StarDefaultValueFactory() {
	}

	static class PrimaryStatChanges {

		private final BigDecimal initialValue;
		private final BigDecimal upgradePerLevelValue;
		private final BigDecimal maximumValue;
		private final Integer stars;
		private final Stat stat;

		public PrimaryStatChanges(
				Integer stars,
				Stat stat,
				BigDecimal initialValue,
				BigDecimal upgradePerLevelValue,
				BigDecimal maximumValue) {

			this.stars = stars;
			this.stat = stat;
			this.initialValue = initialValue;
			this.maximumValue = maximumValue;
			this.upgradePerLevelValue = upgradePerLevelValue;
		}

		public PrimaryStatChanges(
				Integer stars,
				Stat stat,
				Integer initialValue,
				Integer upgradePerLevelValue,
				Integer maximumValue) {

			this(stars, stat,
					BigDecimal.valueOf(initialValue),
					BigDecimal.valueOf(upgradePerLevelValue),
					BigDecimal.valueOf(maximumValue));
		}

		public PrimaryStatChanges(
				Integer stars,
				Stat stat,
				Double initialValue,
				Double upgradePerLevelValue,
				Double maximumValue) {

			this(stars, stat,
					BigDecimal.valueOf(initialValue),
					BigDecimal.valueOf(upgradePerLevelValue),
					BigDecimal.valueOf(maximumValue));
		}

		public BigDecimal getInitialValue() {
			return initialValue;
		}

		public BigDecimal getMaximumValue() {
			return maximumValue;
		}

		public BigDecimal getUpgradePerLevelValue() {
			return upgradePerLevelValue;
		}
	}
}
