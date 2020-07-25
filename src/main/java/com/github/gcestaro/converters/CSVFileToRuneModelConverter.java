package com.github.gcestaro.converters;

import java.util.List;
import java.util.stream.Collectors;

import com.github.gcestaro.models.Rune;
import com.github.gcestaro.models.RuneGrade;
import com.github.gcestaro.models.RuneSlot;
import com.github.gcestaro.models.RuneStat;
import com.github.gcestaro.models.StarDefaultValueFactory;
import com.github.gcestaro.models.io.FileInfo;

public class CSVFileToRuneModelConverter {

	public static List<Rune> convert(List<FileInfo> fileData) {

		return fileData.stream().map(data -> {
			RuneStat primaryStat;

			if (data.getPrimaryStat() == null) {
				primaryStat = StarDefaultValueFactory.getDefaultValue(data.getSlot(), data.getStars());
			} else {
				primaryStat = new RuneStat(data.getPrimaryStat(), data.getPrimaryValue());
			}

			RuneStat innateStat = new RuneStat(data.getInnateStat(), data.getInnateValue());

			RuneSlot slot = new RuneSlot(data.getSlot(), data.getStars(), primaryStat, innateStat);
			slot.addSubStat(new RuneStat(data.getSub1Stat(), data.getSub1Value()));
			slot.addSubStat(new RuneStat(data.getSub2Stat(), data.getSub2Value()));
			slot.addSubStat(new RuneStat(data.getSub3Stat(), data.getSub3Value()));
			slot.addSubStat(new RuneStat(data.getSub4Stat(), data.getSub4Value()));

			RuneGrade defaultGrade = data.isDefaultLegend() ? RuneGrade.LEGENDARY : RuneGrade.RARE;

			Rune rune = new Rune(slot, defaultGrade, data.getSet());
			rune.setLevel(data.getLevel());

			return rune;

		}).collect(Collectors.toList());
	}
}
