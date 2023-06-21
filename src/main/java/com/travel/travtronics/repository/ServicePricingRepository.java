package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServicePricing;

public interface ServicePricingRepository extends JpaRepository<ServicePricing, Long> {

//	List<ServicePricing> findByHeaderId(Long headerId);

	List<ServicePricing> findByHeaderIdAndStatusAndServicePriceType(Long headerId, Status active, Integer priceType);

	List<ServicePricing> findByHeaderIdAndServicePriceTypeAndStatus(Long headerId, Integer pricingType, Status active);

	List<ServicePricing> findByHeaderIdAndStatus(Long srHeaderId, Status active);

//	@Query(value = "SELECT * FROM service_pricing AS sp WHERE sp.HeaderId = ?1 AND sp.service_price_type = 3 AND sp.Status = \"Active\"",nativeQuery = true)
//	Long headerId = Long.parseLong(product.get("id").toString());

//	List<ServicePricing> getByHeaderIdAndStatus(int headerId2, Status active);

}
