package com.github.gcestaro.resources;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gcestaro.models.Rune;
import com.github.gcestaro.services.RuneService;

@RestController
@RequestMapping("/runes")
public class RuneResource {

	RuneService runeService;

	public RuneResource(RuneService runeService) {
		this.runeService = runeService;
	}

	@GetMapping
	public Collection<Rune> findAll() {
		return runeService.getAllRunes();
	}

	@DeleteMapping
	public void deleteAll() {
		runeService.deleteAll();
	}
}
