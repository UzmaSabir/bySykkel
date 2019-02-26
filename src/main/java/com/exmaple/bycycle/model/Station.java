package com.exmaple.bycycle.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "in_service", "title", "subtitle", "number_of_locks", "center", "bounds" })
public class Station {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("in_service")
	private Boolean inService;
	@JsonProperty("title")
	private String title;
	@JsonProperty("subtitle")
	private String subtitle;
	@JsonProperty("number_of_locks")
	private Integer numberOfLocks;
	@JsonProperty("center")
	private Center center;
	@JsonProperty("bounds")
	private List<Bound> bounds = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("in_service")
	public Boolean getInService() {
		return inService;
	}

	@JsonProperty("in_service")
	public void setInService(Boolean inService) {
		this.inService = inService;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("subtitle")
	public String getSubtitle() {
		return subtitle;
	}

	@JsonProperty("subtitle")
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@JsonProperty("number_of_locks")
	public Integer getNumberOfLocks() {
		return numberOfLocks;
	}

	@JsonProperty("number_of_locks")
	public void setNumberOfLocks(Integer numberOfLocks) {
		this.numberOfLocks = numberOfLocks;
	}

	@JsonProperty("center")
	public Center getCenter() {
		return center;
	}

	@JsonProperty("center")
	public void setCenter(Center center) {
		this.center = center;
	}

	@JsonProperty("bounds")
	public List<Bound> getBounds() {
		return bounds;
	}

	@JsonProperty("bounds")
	public void setBounds(List<Bound> bounds) {
		this.bounds = bounds;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
