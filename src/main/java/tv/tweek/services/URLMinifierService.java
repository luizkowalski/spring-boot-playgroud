package tv.tweek.services;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

@Component
public class URLMinifierService {
	private StringRedisTemplate template;
	
	@Autowired
	public URLMinifierService(StringRedisTemplate template) {
		this.template = template;
	}
	
	public String minify(String url) throws Exception{
		if(!UrlValidator.getInstance().isValid(url)){
			throw new Exception("URL "+url+" is invalid");
		}
		String hash = Hashing.murmur3_32().hashString(url, Charsets.UTF_8).toString();
		template.opsForValue().set(hash, url);
		return hash;
	}
	
	public String decode(String shortcut){
		return template.opsForValue().get(shortcut);
	}
	
}
