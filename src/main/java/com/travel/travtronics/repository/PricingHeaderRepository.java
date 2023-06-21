package com.travel.travtronics.repository;

import com.travel.travtronics.model.PricingHeader;
import com.travel.travtronics.request.PricingJoinDto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PricingHeaderRepository extends JpaRepository<PricingHeader, Long> {

    @Query(value = "SELECT bu.Name  AS businessUnitName,\r\n" + "mu.Name  AS organizationName,\r\n"
            + "md.Name departnemtName FROM e_services.pricing_header sth\r\n"
            + "LEFT JOIN masters_srm.master_business_unit bu ON sth.BusinessUnit=bu.BusinessUnitId\r\n"
            + "LEFT JOIN masters_srm.master_organization mu ON sth.Organization=mu.OrganizationId\r\n"
            + "LEFT JOIN masters_srm.master_departments md ON sth.Dapartment=md.DepartmentId\r\n"
            + "WHERE sth.ID= :id", nativeQuery = true)
    PricingJoinDto getSalaryNames(@Param("id") Long id);

	List<PricingHeader> findAllByOrganization(Long organization);

	Page<PricingHeader> findByOrganization(Long organization, Pageable pageable);
}
