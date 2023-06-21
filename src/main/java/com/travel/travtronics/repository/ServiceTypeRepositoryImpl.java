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

import com.travel.travtronics.dto.PaginationFetchDto;
import com.travel.travtronics.dto.PaginationFetchGroupDto;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.ServiceMenuType;
import com.travel.travtronics.model.ServiceTypesHeader;

@Component
public class ServiceTypeRepositoryImpl implements ServiceTypeCustomRepository {

	@PersistenceContext
	@Autowired
	EntityManager em;

	@Override
	public Page<ServiceTypesHeader> fetchPaginationList(PaginationFetchDto service, Pageable pageable) {
		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<ServiceTypesHeader> criteria = builder.createQuery(ServiceTypesHeader.class);

		Root<ServiceTypesHeader> serviceRoot = criteria.from(ServiceTypesHeader.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		/*
		 * check each predicate and add size to predicate array to finalize query
		 */
		if (service.getOrganizationId() != null && !service.getOrganizationId().isEmpty()) {
			predicates.add(builder.equal(serviceRoot.get("organizationId"), service.getOrganizationId()));
		}
		if (service.getDepartmentId() != null && !service.getDepartmentId().isEmpty()) {
			predicates.add(builder.equal(serviceRoot.get("departmentId"), service.getDepartmentId()));
		}
		if (service.getParentId() != null && !service.getParentId().isEmpty()) {
			predicates.add(builder.equal(serviceRoot.get("parentId"), service.getParentId()));
		}
		if (service.getStatus() != null) {
			predicates.add(builder.equal(serviceRoot.get("status"), service.getStatus()));
		}
		if (service.getServiceClass() != null) {
		    predicates.add(builder.equal(serviceRoot.get("serviceClass"), service.getServiceClass()));
		}
		if (service.getServiceCategory() != null) {
		    predicates.add(builder.equal(serviceRoot.get("serviceCategory"), service.getServiceCategory()));
		}
		if (service.getServiceType() != null) {
		    predicates.add(builder.equal(serviceRoot.get("serviceType"), service.getServiceType()));
		}
		if (service.getIsProcess() != null && service.getIsProcess()) {
		    predicates.add(builder.isTrue(serviceRoot.get("isProcess")));
		}
		if (service.getIsStage() != null && service.getIsStage()) {
		    predicates.add(builder.isTrue(serviceRoot.get("isStage")));
		}
		if (service.getIsPricing() != null && service.getIsPricing()) {
		    predicates.add(builder.isTrue(serviceRoot.get("isPricing")));
		}
		if (service.getIsDynamicForm() != null) {
		    predicates.add(builder.equal(serviceRoot.get("isDynamicForm"),service.getIsDynamicForm()));
		}
		if (service.getName() != null && !service.getName().isBlank()) {

			predicates.add(builder.like(builder.lower(serviceRoot.<String>get("name")),
					"%" + service.getName().toLowerCase() + "%"));
		}
		
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((service.getSortType() == SortType.asc || Objects.isNull(service.getSortType()))
				&& service.getSortBy() != null && !service.getSortBy().isEmpty()) {
			criteria.orderBy(builder.asc(serviceRoot.get(service.getSortBy())));
		}
		if (service.getSortType() == SortType.desc && service.getSortBy() != null && !service.getSortBy().isEmpty()) {
			criteria.orderBy(builder.desc(serviceRoot.get(service.getSortBy())));
		}

		/*
		 * This query fetches the serviceTypeHeader as per the Page Limit
		 */
		List<ServiceTypesHeader> resultList = em.createQuery(criteria)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();

		/*
		 * create a count query
		 */
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<ServiceTypesHeader> serviceRootCount = countQuery.from(ServiceTypesHeader.class);
		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		/*
		 * Fetches the count of all service Types as per given criteria
		 */
		Long count = em.createQuery(countQuery).getSingleResult();

		Page<ServiceTypesHeader> finalList = new PageImpl<>(resultList, pageable, count);
		return finalList;
	}

	@Override
	public Page<ServiceMenuType> fetchServiceTypeMenuPagination(String name, Long organization, Pageable pageable,
			String sortBy, SortType sortType) {
		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<ServiceMenuType> createQuery = builder.createQuery(ServiceMenuType.class);

		Root<ServiceMenuType> root = createQuery.from(ServiceMenuType.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		/*
		 * check each predicate and add size to predicate array to finalize query
		 */

		if (organization != null && organization != 0) {
			predicates.add(builder.equal(root.<Long>get("organization"), organization));
		}
		if (name != null && !name.isBlank()) {

			predicates.add(builder.like(builder.lower(root.<String>get("name")), "%" + name.toLowerCase() + "%"));

		}

		createQuery.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((sortType == SortType.asc || Objects.isNull(sortType)) && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.asc(root.get(sortBy)));
		}
		if (sortType == SortType.desc && sortBy != null && !sortBy.isEmpty()) {
			createQuery.orderBy(builder.desc(root.get(sortBy)));
		}
		List<ServiceMenuType> resultList = em.createQuery(createQuery)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();

		/*
		 * Fetches the count of all service Types as per given criteria
		 */

		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);

		Root<ServiceMenuType> serviceRootCount = countQuery.from(ServiceMenuType.class);
		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		Long count = em.createQuery(countQuery).getSingleResult();
		Page<ServiceMenuType> finalList = new PageImpl<>(resultList, pageable, count);

		return finalList;
	}

	@Override
	public Page<ServiceTypesHeader> fetchPaginationGroupList(PaginationFetchGroupDto service, Pageable pageable) {
		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<ServiceTypesHeader> criteria = builder.createQuery(ServiceTypesHeader.class);

		Root<ServiceTypesHeader> serviceRoot = criteria.from(ServiceTypesHeader.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		/*
		 * check each predicate and add size to predicate array to finalize query
		 */
		if (service.getOrganizationId() != null && !service.getOrganizationId().isEmpty()) {
			predicates.add(builder.equal(serviceRoot.get("organizationId"), service.getOrganizationId()));
		}
		if (service.getDepartmentId() != null && !service.getDepartmentId().isEmpty()) {
			predicates.add(builder.equal(serviceRoot.get("departmentId"), service.getDepartmentId()));
		}
		if (service.getServiceTypeGroup() != null && !service.getServiceTypeGroup().isEmpty()) {
			predicates.add(builder.equal(serviceRoot.get("serviceTypeGroup"), service.getServiceTypeGroup()));
		}
		if (service.getStatus() != null) {
			predicates.add(builder.equal(serviceRoot.get("status"), service.getStatus()));
		}

		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		if ((service.getSortType() == SortType.asc || Objects.isNull(service.getSortType()))
				&& service.getSortBy() != null && !service.getSortBy().isEmpty()) {
			criteria.orderBy(builder.asc(serviceRoot.get(service.getSortBy())));
		}
		if (service.getSortType() == SortType.desc && service.getSortBy() != null && !service.getSortBy().isEmpty()) {
			criteria.orderBy(builder.desc(serviceRoot.get(service.getSortBy())));
		}

		/*
		 * This query fetches the serviceTypeHeader as per the Page Limit
		 */
		List<ServiceTypesHeader> resultList = em.createQuery(criteria)
				.setFirstResult(Math.toIntExact(pageable.getOffset())).setMaxResults(pageable.getPageSize())
				.getResultList();

		/*
		 * create a count query
		 */
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<ServiceTypesHeader> serviceRootCount = countQuery.from(ServiceTypesHeader.class);
		countQuery.select(builder.count(serviceRootCount))
				.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

		/*
		 * Fetches the count of all service Types as per given criteria
		 */
		Long count = em.createQuery(countQuery).getSingleResult();

		Page<ServiceTypesHeader> finalList = new PageImpl<>(resultList, pageable, count);
		return finalList;
	}

}
