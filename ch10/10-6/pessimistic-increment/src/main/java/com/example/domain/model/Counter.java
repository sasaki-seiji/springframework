package com.example.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "counter")
public class Counter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// 2018.12.17 modify: Sequence "HIBERNATE_SEQUENCE" not found
	// see https://stackoverflow.com/questions/39807483/sequence-hibernate-sequence-not-found-sql-statement
	//@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "count")
	private Integer count;
	
	@Version
	@Column(name = "version")
	private Integer version;
	

	public Integer getId() { return this.id; }
	public void setId(Integer id) { this.id = id; }
	
	public Integer getCount() { return this.count; }
	public void setCount(Integer count) { this.count = count; }
	
	public String toString() {
		return "{ id: " + id + ", count: " + count + ", version: " + version + " }";
	}

}
