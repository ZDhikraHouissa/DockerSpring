package com.dhikra.zak.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@GetMapping("/all")
	public List<Map<String, String>> getBooks() {
		Map<String, String> map1 = new HashMap<>();
		map1.put("name", "Book 1");
		map1.put("author", "author 1");
		Map<String, String> map2 = new HashMap<>();
		map2.put("name", "Book 2");
		map2.put("author", "author 2");

		List<Map<String, String>> list = new ArrayList<>();

		list.add(map1);
		list.add(map2);
		return list;
	}
}
