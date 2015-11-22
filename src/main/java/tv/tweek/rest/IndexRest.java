package tv.tweek.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tv.tweek.services.URLMinifierService;

@RestController
@EnableAutoConfiguration
public class IndexRest {
	
	@Value("${app.url}")
	private String appDomain;
	
	@Autowired
	private URLMinifierService service;

	@RequestMapping(method = RequestMethod.GET, path="/{url}")
	public String getUrlFrom(@PathVariable String url) {
		return service.decode(url);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createMinifiedUrl(@RequestParam(value="url") String url, HttpServletRequest req) {
		try{
			return appDomain + service.minify(url);
		} catch(Exception e){
			return "Error: "+e;
		}
		
	}
}
