package com.crud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crud.Enums.ProductType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
public class Product {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue
	private long id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String code;
	
	@Getter
	@Setter
	private Double price;
	
	@Getter
	@Setter
	private ProductType type;
	
	@Getter
	@Setter
	private Integer availableCount;

}
