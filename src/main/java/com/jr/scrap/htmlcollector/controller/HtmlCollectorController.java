/**
 * 
 */
package com.jr.scrap.htmlcollector.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author juan
 *
 */
@RestController
public class HtmlCollectorController {

	@GetMapping(path = "/html")
	public ResponseEntity<String> getOuterHtml(@RequestParam(required = true) String url) {		
		try {
			return new ResponseEntity<>(Jsoup.connect(url).get().outerHtml(), HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
