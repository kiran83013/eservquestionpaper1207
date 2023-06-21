package com.travel.travtronics.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.travel.travtronics.dto.EServiceRegisterCustomRepository;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.Agreement;
import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.model.FieldProcessHeader;
import com.travel.travtronics.model.InputTypeConfig;
import com.travel.travtronics.model.Item;
import com.travel.travtronics.model.PricingHeader;
import com.travel.travtronics.model.ServiceTypeGroup;
import com.travel.travtronics.model.TaxSlabHeader;

@Component
public class EServiceRegisterRepositoryImpl implements EServiceRegisterCustomRepository {

	@PersistenceContext
	@Autowired
	EntityManager em;

	@Override
	public Page<EServiceRegister> fetchEServiceRegisterPagination(String serviceName, Long organizationId,
			Pageable pageable, String sortBy, SortType sortType) {
		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<EServiceRegister> createQuery = builder.createQuery(EServiceRegister.class);

		Root<EServiceRegister> root = createQuery.from(EServiceRegister.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (organizationId != null && organizationId != 0) {
			predicates.add(builder.equal(root.<Long>get("organizationId"), organizationId));
		}
		if (serviceName != null && !serviceName.isBlank()) {

			predicates.add(builder.like(builder.lower(root.<String>get("serviceName")),
					"%" + serviceName.toLowerCase() + "%"));

		}

		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		List<EServiceRegister> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();

		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<EServiceRegister> serviceRootCount = countQuery.from(EServiceRegister.class);

		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<EServiceRegister> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

	@Override
	public Page<InputTypeConfig> fetchInputTypeConfigPagination(String name, Long organizationId, Pageable pageable,
			String sortBy, SortType sortType) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<InputTypeConfig> createQuery = builder.createQuery(InputTypeConfig.class);
		
		Root<InputTypeConfig> root = createQuery.from(InputTypeConfig.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (organizationId != null && organizationId != 0) {
			predicates.add(builder.equal(root.<Long>get("organizationId"), organizationId));
		}
		if (name != null && !name.isBlank()) {

			predicates.add(builder.like(builder.lower(root.<String>get("name")),
					"%" + name.toLowerCase() + "%"));
		}
		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		
		List<InputTypeConfig> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();
		
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<InputTypeConfig> serviceRootCount = countQuery.from(InputTypeConfig.class);

		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<InputTypeConfig> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

	@Override
	public Page<ServiceTypeGroup> fetchServiceTypeGroupPagination(String name, Long organizationId,
			Pageable pageable, String sortBy, SortType sortType) {
			
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<ServiceTypeGroup> createQuery = builder.createQuery(ServiceTypeGroup.class);
		
		Root<ServiceTypeGroup> root = createQuery.from(ServiceTypeGroup.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (organizationId != null && organizationId != 0) {
			predicates.add(builder.equal(root.<Long>get("organizationId"), organizationId));
		}
		if (name != null && !name.isBlank()) {

			predicates.add(builder.like(builder.lower(root.<String>get("name")),
					"%" + name.toLowerCase() + "%"));
		}
		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		
		List<ServiceTypeGroup> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();
		
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<ServiceTypeGroup> serviceRootCount = countQuery.from(ServiceTypeGroup.class);

		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<ServiceTypeGroup> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

	@Override
	public Page<Item> fetchItemPagination(String name, Long organizationId, Pageable pageable, String sortBy,
			SortType sortType) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Item> createQuery = builder.createQuery(Item.class);
		
		Root<Item> root = createQuery.from(Item.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (organizationId != null && organizationId != 0) {
			predicates.add(builder.equal(root.<Long>get("organizationId"), organizationId));
		}
		if (name != null && !name.isBlank()) {

			predicates.add(builder.like(builder.lower(root.<String>get("name")),
					"%" + name.toLowerCase() + "%"));
		}
		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		
		List<Item> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();
		
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<Item> serviceRootCount = countQuery.from(Item.class);

		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<Item> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

	@Override
	public Page<PricingHeader> fetchPricingPagination(String name, Long organization, Pageable pageable, String sortBy,
			SortType sortType) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<PricingHeader> createQuery = builder.createQuery(PricingHeader.class);
		
		Root<PricingHeader> root = createQuery.from(PricingHeader.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (organization != null && organization != 0) {
			predicates.add(builder.equal(root.<Long>get("organization"), organization));
		}
		if (name != null && !name.isBlank()) {

			predicates.add(builder.like(builder.lower(root.<String>get("name")),
					"%" + name.toLowerCase() + "%"));
		}
		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		
		List<PricingHeader> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();
		
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<PricingHeader> serviceRootCount = countQuery.from(PricingHeader.class);

		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<PricingHeader> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

	@Override
	public Page<TaxSlabHeader> fetchTaxPagination(Long taxCategory, Long organizationId, Pageable pageable,
			String sortBy, SortType sortType) {
	CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<TaxSlabHeader> createQuery = builder.createQuery(TaxSlabHeader.class);
		
		Root<TaxSlabHeader> root = createQuery.from(TaxSlabHeader.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (organizationId != null && organizationId != 0) {
			predicates.add(builder.equal(root.<Long>get("organizationId"), organizationId));
		}

		if (taxCategory != null && taxCategory != 0) {
			predicates.add(builder.equal(root.<Long>get("taxCategory"), taxCategory));
		}
		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		
		List<TaxSlabHeader> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();
		
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<TaxSlabHeader> serviceRootCount = countQuery.from(TaxSlabHeader.class);

		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<TaxSlabHeader> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

	@Override
	public Page<Agreement> fetchAgreementPagination(String name, Long organizationId, Pageable pageable, String sortBy,
			SortType sortType) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Agreement> createQuery = builder.createQuery(Agreement.class);
		
		Root<Agreement> root = createQuery.from(Agreement.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (organizationId != null && organizationId != 0) {
			predicates.add(builder.equal(root.<Long>get("organizationId"), organizationId));
		}

		if (name != null && !name.isBlank()) {

			predicates.add(builder.like(builder.lower(root.<String>get("name")),
					"%" + name.toLowerCase() + "%"));
		}
		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		
		List<Agreement> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();
		
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<Agreement> serviceRootCount = countQuery.from(Agreement.class);

		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<Agreement> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

	@Override
	public Page<FieldProcessHeader> fetchFieldProcessHeaderPagination(String processName, Long organizationId,
			Pageable pageable, String sortBy, SortType sortType) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<FieldProcessHeader> createQuery = builder.createQuery(FieldProcessHeader.class);
		
		Root<FieldProcessHeader> root = createQuery.from(FieldProcessHeader.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (organizationId != null && organizationId != 0) {
			predicates.add(builder.equal(root.<Long>get("organizationId"), organizationId));
		}

		if (processName != null && !processName.isBlank()) {

			predicates.add(builder.like(builder.lower(root.<String>get("processName")),
					"%" + processName.toLowerCase() + "%"));
		}
		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		
		List<FieldProcessHeader> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();
		
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<FieldProcessHeader> serviceRootCount = countQuery.from(FieldProcessHeader.class);

		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<FieldProcessHeader> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

}
