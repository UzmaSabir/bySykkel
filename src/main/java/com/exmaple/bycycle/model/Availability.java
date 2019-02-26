package com.exmaple.bycycle.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bikes", "locks", "overflow_capacity" })
public class Availability {

	@JsonProperty("bikes")
	private Integer bikes;
	@JsonProperty("locks")
	private Integer locks;
	@JsonProperty("overflow_capacity")
	private Boolean overflowCapacity;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("bikes")
	public Integer getBikes() {
		return bikes;
	}

	@JsonProperty("bikes")
	public void setBikes(Integer bikes) {
		this.bikes = bikes;
	}

	@JsonProperty("locks")
	public Integer getLocks() {
		return locks;
	}

	@JsonProperty("locks")
	public void setLocks(Integer locks) {
		this.locks = locks;
	}

	@JsonProperty("overflow_capacity")
	public Boolean getOverflowCapacity() {
		return overflowCapacity;
	}

	@JsonProperty("overflow_capacity")
	public void setOverflowCapacity(Boolean overflowCapacity) {
		this.overflowCapacity = overflowCapacity;
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