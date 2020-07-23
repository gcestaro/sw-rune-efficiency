package com.github.gcestaro.models.io;

import java.math.BigDecimal;

import com.github.gcestaro.models.RuneSet;
import com.github.gcestaro.models.Stat;

import lombok.Data;

@Data
public class FileInfo {

	private RuneSet set;

	private int stars;

	private int slot;

	private int level;

	private Stat innateStat;

	private BigDecimal innateValue;

	private Stat primaryStat;

	private BigDecimal primaryValue;

	private boolean defaultLegend;

	private Stat sub1Stat;

	private BigDecimal sub1Value;

	private Stat sub2Stat;

	private BigDecimal sub2Value;

	private Stat sub3Stat;

	private BigDecimal sub3Value;

	private Stat sub4Stat;

	private BigDecimal sub4Value;
}
