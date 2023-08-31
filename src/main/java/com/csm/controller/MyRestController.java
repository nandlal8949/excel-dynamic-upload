package com.csm.controller;

import java.io.File;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csm.service.ExcelService;


/** By Nandlal git(nandlal8949)  */
@RestController
public class MyRestController {
	@Autowired
	private ExcelService excelService;
	
	@GetMapping // default
	public ResponseEntity<String> saveList(@RequestParam MultipartFile file){	
		String result = excelService.saveData(file);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
