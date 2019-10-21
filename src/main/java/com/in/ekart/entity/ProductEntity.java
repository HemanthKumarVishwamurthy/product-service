package com.in.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@ToString
public class ProductEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	
	@Column(name = "DESCRIPTION", length = 255)
	private String description;
	
	@Column(name = "PRICE")
	private Double price;
}
