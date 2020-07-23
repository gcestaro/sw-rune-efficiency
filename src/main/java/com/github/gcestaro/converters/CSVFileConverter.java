package com.github.gcestaro.converters;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CSVFileConverter {

	public static <T> List<T> loadObjectList(Class<T> type, String fileName) {
		try {
			CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
			CsvMapper mapper = new CsvMapper();

			File file = new ClassPathResource(fileName).getFile();

			MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file);
			return readValues.readAll();
		} catch (Exception e) {
			log.error("Error occurred while loading object list from file " + fileName, e);
			return Collections.emptyList();
		}
	}

	public static <T> List<T> loadObjectList(Class<T> type, MultipartFile file) {
		try {
			CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();

			CsvMapper mapper = new CsvMapper();
			mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

			MappingIterator<T> readValues = mapper
					.readerFor(type)
					.with(bootstrapSchema)
					.readValues(file.getInputStream());

			return readValues.readAll();
		} catch (Exception e) {
			log.error("Error occurred while loading object list from file " + file.getName(), e);
			return Collections.emptyList();
		}
	}
}
