package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class VehiclePageRepositoryImpl implements VehiclePageRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Vehicle> findFromDateWithLimit(Timestamp createdAt, int limit) {
		return entityManager.createQuery("select v from Vehicle v where v.createdAt >= :createdAt",
		                                 Vehicle.class)
		                    .setParameter("createdAt", createdAt)
		                    .setMaxResults(limit)
		                    .getResultList();
	}
	
	public List<Vehicle> findByTimestamp(Timestamp createdAt, int limit) {
		return entityManager.createQuery("select v from Vehicle v where v.createdAt >= :createdAt",
		                                 Vehicle.class)
		                    .setParameter("createdAt", createdAt)
		                    .setMaxResults(limit)
		                    .getResultList();
	}
	
	public List<Vehicle> findOrderedByCreatedAtLimitedTo(int limit) {
		return entityManager.createQuery("SELECT p FROM Vehicle p ORDER BY p.createdAt",
		                                 Vehicle.class).setMaxResults(limit).getResultList();
	}
	
	@Override
	public List<Vehicle> findAll() {
		return null;
	}
	
	@Override
	public List<Vehicle> findAll(Sort sort) {
		return null;
	}
	
	@Override
	public Page<Vehicle> findAll(Pageable pageable) {
		return null;
	}
	
	@Override
	public List<Vehicle> findAllById(Iterable<Long> longs) {
		return null;
	}
	
	@Override
	public long count() {
		return 0;
	}
	
	@Override
	public void deleteById(Long aLong) {
	
	}
	
	@Override
	public void delete(Vehicle entity) {
	
	}
	
	@Override
	public void deleteAllById(Iterable<? extends Long> longs) {
	
	}
	
	@Override
	public void deleteAll(Iterable<? extends Vehicle> entities) {
	
	}
	
	@Override
	public void deleteAll() {
	
	}
	
	@Override
	public <S extends Vehicle> S save(S entity) {
		return null;
	}
	
	@Override
	public <S extends Vehicle> List<S> saveAll(Iterable<S> entities) {
		return null;
	}
	
	@Override
	public Optional<Vehicle> findById(Long id) {
		Query query = entityManager.createQuery("select v " +
				                                        "from Vehicle v " +
				                                        "where v.id = :id",
		                                        Vehicle.class);
		query.setParameter("id", id);
		return Optional.of((Vehicle) query.getSingleResult());
	}
	
	@Override
	public boolean existsById(Long aLong) {
		return false;
	}
	
	@Override
	public void flush() {
	
	}
	
	@Override
	public <S extends Vehicle> S saveAndFlush(S entity) {
		return null;
	}
	
	@Override
	public <S extends Vehicle> List<S> saveAllAndFlush(Iterable<S> entities) {
		return null;
	}
	
	@Override
	public void deleteAllInBatch(Iterable<Vehicle> entities) {
	
	}
	
	@Override
	public void deleteAllByIdInBatch(Iterable<Long> longs) {
	
	}
	
	@Override
	public void deleteAllInBatch() {
	
	}
	
	@Override
	public Vehicle getOne(Long aLong) {
		return null;
	}
	
	@Override
	public Vehicle getById(Long aLong) {
		return null;
	}
	
	@Override
	public Vehicle getReferenceById(Long aLong) {
		return null;
	}
	
	@Override
	public <S extends Vehicle> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}
	
	@Override
	public <S extends Vehicle> List<S> findAll(Example<S> example) {
		return null;
	}
	
	@Override
	public <S extends Vehicle> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}
	
	@Override
	public <S extends Vehicle> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}
	
	@Override
	public <S extends Vehicle> long count(Example<S> example) {
		return 0;
	}
	
	@Override
	public <S extends Vehicle> boolean exists(Example<S> example) {
		return false;
	}
	
	@Override
	public <S extends Vehicle, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
		return null;
	}
}
