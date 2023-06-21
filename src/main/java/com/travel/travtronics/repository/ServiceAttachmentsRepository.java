package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceAttachments;

public interface ServiceAttachmentsRepository extends JpaRepository<ServiceAttachments, Long> {

//	List<ServiceAttachments> findByHeaderId(Long headerId);

	List<ServiceAttachments> findByHeaderIdAndStatus(Long headerId, Status active);

	@Query(value = "SELECT \r\n"
			+ "sa.AttachmentsId AS attachmentsId,sa.`Name` AS name, mdf.`name` AS fileType FROM service_attachments AS sa\r\n"
			+ "INNER JOIN master_document_format AS mdf ON sa.`AllowedExtensions` = mdf.`ID`\r\n"
			+ "WHERE sa.`HeaderId` = ?1 AND sa.Status='Active'", nativeQuery = true)
	List<Map<String, String>> findAttachmentsByHeaderId(Long headerId);

	Page<ServiceAttachments> findByOrganizationId(Long organizationId, Pageable pageable);

	@Query(value = "SELECT docfor.name FROM `master_document_format` docfor WHERE  docfor.ID=?1", nativeQuery = true)
	Optional<String> getFileType(Long id);

}
