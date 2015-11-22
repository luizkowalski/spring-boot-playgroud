package tv.tweek.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tv.tweek.model.Test;
import tv.tweek.services.URLMinifierService;

@RestController
@EnableAutoConfiguration
public class IndexController {
	
	@Value("${app.url}")
	private String appDomain;
	
	@Autowired
	private URLMinifierService service;

	@RequestMapping(method = RequestMethod.GET, path="/{url}")
	public ResponseEntity<String> getUrlFrom(@PathVariable String url) {
		try{
			return new ResponseEntity<String>(service.decode(url), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createMinifiedUrl(@RequestParam(value="url") String url) {
		try{
			return new ResponseEntity<String>(appDomain + service.minify(url), HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(path="/test")
	public Test getTest(){
		return new Test();
	}
}
