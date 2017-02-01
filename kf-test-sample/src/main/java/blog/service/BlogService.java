package blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.dao.BlogDao;
import blog.model.Blog;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	/*
	 * static helper method to perform the search and return a DTO.
	 * Appropriate data structure must be used based on the result set size
	 */
	public List<BlogDTO> search(String criteria) {
		List<BlogDTO> returnList = new ArrayList<BlogDTO>();
		
		// convert the entity to a transfer object, can use parallelism if the hardware is multi-core
		List<Blog> queryResult = blogDao.getMatchingBlog(criteria);
		returnList.addAll(
				queryResult.stream()
				.map(b -> new BlogDTO(b.getTitle(),b.getBody()))
				.collect(Collectors.toList())
				);
		
		return returnList;
	}
}
