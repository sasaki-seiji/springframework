package com.example.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.domain.model.Room;

public class RoomRepositoryImpl implements RoomRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Room> findByCriteria(RoomCriteria criteria) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Room> q = cb.createQuery(Room.class);
		Root<Room> r = q.from(Room.class);
		q.select(r);

		Predicate predWhere = null;
		ParameterExpression<String> paramLike = null;
		ParameterExpression<Integer> paramMin = null;
		ParameterExpression<Integer> paramMax = null;
		
		if (criteria.getRoomNameLike() != null) {
			paramLike = cb.parameter(String.class);		
			Predicate exp = cb.like(r.get("roomName"), paramLike);
			predWhere = (predWhere == null) ? exp : cb.and(predWhere, exp);
		}
		if (criteria.getCapacityMin() != null) {
			paramMin = cb.parameter(Integer.class);		
			Predicate exp = cb.greaterThanOrEqualTo(r.get("capacity"), paramMin);
			predWhere = (predWhere == null) ? exp : cb.and(predWhere, exp);
		}
		if (criteria.getCapacityMax() != null) {
			paramMax = cb.parameter(Integer.class);		
			Predicate exp = cb.lessThanOrEqualTo(r.get("capacity"), paramMax);
			predWhere = (predWhere == null) ? exp : cb.and(predWhere, exp);
		}
		
		if (predWhere != null) {
			q.where(predWhere);
		}
		
		TypedQuery<Room> query = entityManager.createQuery(q);

		if (paramLike != null) {
			query.setParameter(paramLike, criteria.getRoomNameLike());
		}
		if (paramMin != null) {
			query.setParameter(paramMin, criteria.getCapacityMin());
		}
		if (paramMax != null) {
			query.setParameter(paramMax, criteria.getCapacityMax());
		}
		
		List<Room> results = query.getResultList();		
		return results;
	}

}
