package com.petrbambas.rest.products.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petrbambas.rest.products.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private EntityManager em;

	@Autowired
	// instance of EntityManager
	public ProductDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public List<Product> findAll() {
		Session currentSession = em.unwrap(Session.class);
		// construction of the SQL command
		Query<Product> query = currentSession.createQuery("from Product", Product.class);
		// get result list
		List<Product> products = query.getResultList();
		return products;
	}

	@Override
	public Product findById(int id) {
		Session currentSession = em.unwrap(Session.class);
		// get product from database by Id
		Product product = currentSession.get(Product.class, id);
		return product;
	}

	@Override
	public void save(Product product) {
		// save new or update already saved product
		Session currentSession = em.unwrap(Session.class);
		currentSession.saveOrUpdate(product);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = em.unwrap(Session.class);
		// construction of the query
		Query query = currentSession.createQuery("delete from Product where id=:productId");
		query.setParameter("productId", id);
		query.executeUpdate();
	}
}
