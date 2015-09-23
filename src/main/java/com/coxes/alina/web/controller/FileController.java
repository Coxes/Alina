package com.coxes.alina.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping(value = "/file")
public class FileController {
	@RequestMapping(value = "/upload")
	public void upload(@RequestParam CommonsMultipartFile file, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getOutputStream().write("{\"0\":1}".getBytes());
	}
}
