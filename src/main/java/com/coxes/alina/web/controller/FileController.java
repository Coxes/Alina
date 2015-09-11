package com.coxes.alina.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping(value = "/file")
public class FileController {
	@ResponseBody
	@RequestMapping(value = "/upload")
	public Object upload(@RequestParam CommonsMultipartFile file) {
		Map<String, String> s = new HashMap<String, String>();
		s.put("0", file.getName());
		return s;
	}
}
