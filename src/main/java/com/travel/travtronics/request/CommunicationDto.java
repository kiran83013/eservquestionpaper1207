package com.travel.travtronics.request;

public class CommunicationDto {
	
	private Integer id;

	private String channel;
	
	private String channelReference;


	private Integer customerId;

	
	private Integer moduleId;

	private String moduleReference;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getChannelReference() {
		return channelReference;
	}

	public void setChannelReference(String channelReference) {
		this.channelReference = channelReference;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleReference() {
		return moduleReference;
	}

	public void setModuleReference(String moduleReference) {
		this.moduleReference = moduleReference;
	}
	
	
	

}
