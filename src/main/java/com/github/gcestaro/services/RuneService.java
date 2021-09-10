package com.github.gcestaro.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.gcestaro.converters.CSVFileConverter;
import com.github.gcestaro.converters.CSVFileToRuneModelConverter;
import com.github.gcestaro.models.Rune;
import com.github.gcestaro.models.io.FileInfo;
import com.github.gcestaro.repositories.RuneRepository;
import com.github.gcestaro.resources.filters.RuneFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RuneService {

	private final RuneRepository repository;

	private final MongoTemplate mongoTemplate;

	public RuneService(RuneRepository repository, MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		this.repository = repository;
	}

	public Collection<Rune> getAllRunes(RuneFilter filter) {
		Query query = buildCriteria(filter);

		List<Rune> runes = mongoTemplate.find(query, Rune.class);

		if (filter.isOrderedResult()) {
			return runes
					.stream()
					.sorted(filter.getOrderBy().getComparator())
					.collect(Collectors.toList());
		}

		return runes;
	}

	private Query buildCriteria(RuneFilter filter) {
		Query query = new Query();

		if (filter.filterByLevel()) {
			query.addCriteria(Criteria.where("level").gte(filter.getLevel()));
		}

		if (filter.filterBySlot()) {
			query.addCriteria(Criteria.where("slot.slot").is(filter.getSlot()));
		}

		if (filter.filterByPrimaryStat()) {
			query.addCriteria(Criteria.where("primaryStat").is(filter.getPrimaryStat()));
		}

		if (filter.filterByRuneSet()) {
			query.addCriteria(Criteria.where("set").is(filter.getSet()));
		}

		return query;
	}

	public void deleteAll() {
		log.info("deleting all runes");
		repository.deleteAll();
	}

	@Transactional
	public void load(MultipartFile file) {
		this.deleteAll();

		log.info("converting file to file info");
		List<FileInfo> fileData = CSVFileConverter.loadObjectList(FileInfo.class, file);

		log.info("converting file info to rune model");
		List<Rune> runes = CSVFileToRuneModelConverter.convert(fileData);

		log.info("saving rune model");
		repository.saveAll(runes);
	}
}
