package com.github.gcestaro.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.gcestaro.converters.CSVFileConverter;
import com.github.gcestaro.converters.CSVFileToRuneModelConverter;
import com.github.gcestaro.models.Rune;
import com.github.gcestaro.models.io.FileInfo;
import com.github.gcestaro.repositories.RuneRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RuneService {

	private RuneRepository repository;

	public RuneService(RuneRepository repository) {
		this.repository = repository;
	}

	public void load(MultipartFile file) {
		log.info("converting file to file info");
		List<FileInfo> fileData = CSVFileConverter.loadObjectList(FileInfo.class, file);

		log.info("converting file info to rune model");
		List<Rune> runes = CSVFileToRuneModelConverter.convert(fileData);

		log.info("saving rune model");
		repository.saveAll(runes);
	}

	public Collection<Rune> getAllRunes() {
		return repository.findAll();
	}
}
