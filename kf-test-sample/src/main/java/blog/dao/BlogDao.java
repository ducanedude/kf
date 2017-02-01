package blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import blog.model.Blog;

/**
 * This class is used to access data for the Blog entity.
 */
@Repository
@Transactional
public class BlogDao {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	public void create(Blog blog) {
		entityManager.persist(blog);
		return;
	}

	public void delete(Blog blog) {
		if (entityManager.contains(blog))
			entityManager.remove(blog);
		else
			entityManager.remove(entityManager.merge(blog));
		return;
	}

	/**
	 * Return all the blog entry stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Blog> getAll() {
		return entityManager.createQuery("from Blog").getResultList();
	}

	/*
	 * Get the matching entries either in title or body
	 */
	@SuppressWarnings("unchecked")
	public List<Blog> getMatchingBlog(String criteria) {
		String likeStr = "%" + criteria + "%";

		return entityManager
				.createQuery("from Blog b where lower(title) LIKE :titleSearch or lower(body) LIKE :bodySearch")
				.setParameter("titleSearch", likeStr).setParameter("bodySearch", likeStr).getResultList();
	}

	/**
	 * Update the passed blog entry in the database.
	 */
	public void update(Blog blog) {
		entityManager.merge(blog);
		return;
	}

}
