package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.capstore.beans.Authentication;

@Repository
@Transactional
public class AuthenticationDAO {

	@Autowired
	private EntityManager entityManager;

	public List<String> getRoleNames(String mobileNumber) {
		/*String sql = "Select ur.userAccess from " + Authentication.class.getName() + " ur " //
				+ " where ur.Authentication.mobileNo = :mobileNo ";
		 */
		String sql = "select userAccess from Authentication where mobileNo = :mobileNo";
		Query query = this.entityManager.createQuery(sql, String.class);
		query.setParameter("mobileNo", mobileNumber);
		return query.getResultList();
	}


	public Authentication findUserAccount(String mobile_no) {
		try {
			String sql = "Select e from " + Authentication.class.getName() + " e " //
					+ " Where e.mobileNo = :mobileNo ";

			Query query = entityManager.createQuery(sql, Authentication.class);
			query.setParameter("mobileNo", mobile_no);

			return (Authentication) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}