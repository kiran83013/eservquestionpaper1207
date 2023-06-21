package com.travel.travtronics.repository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.TaxSlabLines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaxLinesRepository extends JpaRepository<TaxSlabLines, Long> {
    List<TaxSlabLines> findAllByTaxSlabHeaderIdAndStatus(Long id, Status active);
}
