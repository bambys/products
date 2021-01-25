package com.petrbambas.rest.products.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petrbambas.rest.products.model.Stock;

@Repository
public class StockDaoImpl implements StockDao {

	private EntityManager em;
	
	@Autowired
	// instance of EntityManager
	public StockDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public List<Stock> findAll() {
		Session currentSession = em.unwrap(Session.class);
		// construction of the SQL command
		Query<Stock> query=currentSession.createQuery("from Stock", Stock.class);
		//  get result list
		List<Stock> stocks = query.getResultList();
		return stocks;
	}

	
	@Override
	@Transactional
	public  List<Stock> findByProductId(int id) {
		Session currentSession = em.unwrap(Session.class);
		// get product from database by Id
		Query<Stock> query=currentSession.createQuery("from Stock where product_id=:product_id", Stock.class);
		query.setParameter("product_id", id);
		List<Stock> stocks = query.getResultList();
		return stocks;
		}

}
