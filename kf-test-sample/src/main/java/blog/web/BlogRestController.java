package blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blog.service.BlogDTO;
import blog.service.BlogService;

@RestController
public class BlogRestController {

	@Autowired
	BlogService blogService;
	
	@RequestMapping(value = "/search", method=RequestMethod.POST)
	public List<BlogDTO> getSearchResults(@RequestParam(value="criteria", defaultValue="") String crit) {
		return blogService.search(crit);
	}

}
