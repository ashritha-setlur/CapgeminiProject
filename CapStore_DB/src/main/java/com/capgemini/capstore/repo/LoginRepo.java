package com.capgemini.capstore.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.capstore.beans.Authentication;

@Repository
@Transactional
public class LoginRepo {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<String> getRoleNames(String mobileNumber) {
		String sql = "select userAccess from Authentication where mobileNo = :mobileNo";
		Query query = this.entityManager.createQuery(sql, String.class);
		query.setParameter("mobileNo", mobileNumber);
		return query.getResultList();
	}

	public Authentication findUserAccount(String mobile_no) {
		String sql = "Select e from " + Authentication.class.getName() + " e " //
				+ " Where e.mobileNo = :mobileNo ";
		Query query = entityManager.createQuery(sql, Authentication.class);
		query.setParameter("mobileNo", mobile_no);
		return (Authentication) query.getSingleResult();
	}
}
