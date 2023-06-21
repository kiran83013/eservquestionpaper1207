package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Predicate;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travtronics.model.CommunicationModuleLink;
import com.travel.travtronics.repository.CommunicationModuleRepository;
import com.travel.travtronics.request.CommunicationDto;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.MessageStatusResponse;

@Service
public class CommunicationLinkService {

	@Autowired
	CommunicationModuleRepository communicationModuleRepository;

	public MessageStatusResponse createCommunication(@Valid CommunicationModuleLink link) {
		communicationModuleRepository.save(link);
		return new MessageStatusResponse(200, "Created");
	}

	public APIResponse getCommunications(CommunicationDto dto) {

		List<CommunicationModuleLink> response = communicationModuleRepository.findAll((root, query, cb) -> {
			final Collection<Predicate> predicates = new ArrayList<>();
			if (Objects.nonNull(dto.getId()) && dto.getId() != 0)
				predicates.add(cb.equal(root.get("id"), dto.getId()));
			if (Objects.nonNull(dto.getChannel()) && !dto.getChannel().isBlank())
				predicates.add(cb.equal(root.get("channel"), dto.getChannel()));
			if (Objects.nonNull(dto.getChannelReference()) && !dto.getChannelReference().isBlank())
				predicates.add(cb.equal(root.get("channelReference"), dto.getChannelReference()));
			if (Objects.nonNull(dto.getCustomerId()) && dto.getCustomerId() != 0)
				predicates.add(cb.equal(root.get("customerId"), dto.getCustomerId()));
			if (Objects.nonNull(dto.getModuleId()) && dto.getModuleId() != 0)
				predicates.add(cb.equal(root.get("moduleId"), dto.getModuleId()));
			if (Objects.nonNull(dto.getModuleReference()) && !dto.getModuleReference().isBlank())
				predicates.add(cb.equal(root.get("moduleReference"), dto.getModuleReference()));
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		});
		return new APIResponse(200, "OK", response);
	}

}
