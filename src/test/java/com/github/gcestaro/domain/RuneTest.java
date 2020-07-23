package com.github.gcestaro.domain;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.github.gcestaro.models.Rune;
import com.github.gcestaro.models.RuneGrade;
import com.github.gcestaro.models.RuneSet;
import com.github.gcestaro.models.RuneSlot;
import com.github.gcestaro.models.RuneStat;
import com.github.gcestaro.models.Stat;

class RuneTest {

	@Test
	void perfectRuneTest() {
		RuneStat innateStat = new RuneStat(Stat.ACCURACY, 8);

		RuneSlot slot = new RuneSlot(1, 6, null, innateStat);

		RuneStat hpSub = new RuneStat(Stat.HP_PERCENT, 40);
		slot.addSubStat(hpSub);

		RuneStat atkSub = new RuneStat(Stat.ATK_PERCENT, 8);
		slot.addSubStat(atkSub);

		RuneStat crSub = new RuneStat(Stat.CRITICAL_RATE, 6);
		slot.addSubStat(crSub);

		RuneStat cdSub = new RuneStat(Stat.CRITICAL_DMG, 7);
		slot.addSubStat(cdSub);

		Rune rune = new Rune(slot, RuneGrade.LEGENDARY, RuneSet.ENDURE);

		System.out.println(rune);

		BigDecimal effiency = rune.getEfficiency();

		System.out.println("Efficiency: " + effiency + "%");
	}

	@Test
	void realRuneTest() {
		RuneStat innateStat = new RuneStat(Stat.ACCURACY, 7);

		RuneSlot slot = new RuneSlot(5, 6, null, innateStat);

		RuneStat hpSub = new RuneStat(Stat.HP_PERCENT, 10);
		slot.addSubStat(hpSub);

		RuneStat atkSub = new RuneStat(Stat.ATK_PERCENT, 33);
		slot.addSubStat(atkSub);

		RuneStat defSub = new RuneStat(Stat.DEF_PERCENT, 17);
		slot.addSubStat(defSub);

		RuneStat spdSub = new RuneStat(Stat.SPEED, 12);
		slot.addSubStat(spdSub);

		Rune rune = new Rune(slot, RuneGrade.LEGENDARY, RuneSet.WILL);

		System.out.println(rune);

		BigDecimal effiency = rune.getEfficiency();

		System.out.println("Efficiency: " + effiency + "%");
	}

	@Test
	void realRuneTest2() {
		RuneSlot slot = new RuneSlot(5, 6, null, null);

		RuneStat accSub = new RuneStat(Stat.ACCURACY, 8);
		slot.addSubStat(accSub);

		RuneStat cdSub = new RuneStat(Stat.CRITICAL_DMG, 7);
		slot.addSubStat(cdSub);

		RuneStat atkSub = new RuneStat(Stat.ATK_PERCENT, 32);
		slot.addSubStat(atkSub);

		RuneStat crSub = new RuneStat(Stat.CRITICAL_RATE, 5);
		slot.addSubStat(crSub);

		Rune rune = new Rune(slot, RuneGrade.HERO, RuneSet.WILL);

		System.out.println(rune);

		BigDecimal effiency = rune.getEfficiency();

		System.out.println("Efficiency: " + effiency + "%");
	}
}
