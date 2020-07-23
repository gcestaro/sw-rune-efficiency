package com.github.gcestaro.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "runes")
public class Rune {

	@Id
	private UUID uuid;

	private Integer level;

	private RuneSlot slot;

	private RuneGrade defaultGrade;

	private RuneSet set;

	public Rune() {
		this.uuid = UUID.randomUUID();
		this.level = 0;
		this.defaultGrade = RuneGrade.randomGrade();
		this.slot = RuneSlot.randomSlot(defaultGrade);
		this.set = RuneSet.randomSet();
	}

	public Rune(RuneSlot slot, RuneGrade defaultGrade, RuneSet set) {
		this.uuid = UUID.randomUUID();
		this.level = 0;
		this.defaultGrade = defaultGrade;
		this.slot = slot;
		this.set = set;
	}

	public BigDecimal getEfficiency() {
		Optional<RuneStat> innateStat = slot.getInnateStat();

		BigDecimal innateStatHit = innateStat
				.map(RuneHitCounter::countHits)
				.orElse(BigDecimal.ZERO);

		BigDecimal subStatsHits = slot.getSubStats().stream()
				.map(RuneHitCounter::countHits)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		return subStatsHits
				.add(innateStatHit)
				.divide(RuneGrade.LEGENDARY.getMaxHits(), 5, RoundingMode.HALF_EVEN)
				.multiply(BigDecimal.valueOf(100));
	}

	public RuneStat getPrimaryStat() {
		return slot.getPrimaryStat();
	}
}
