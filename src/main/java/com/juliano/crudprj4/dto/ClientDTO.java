package com.juliano.crudprj4.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.juliano.crudprj4.entities.Client;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "name can't be empty")
	@Length(min = 3, max = 40, message = "Length must be between 4 and 40")
	private String name;
	@NotEmpty(message = "cpf can't be empty")
	@Length(min = 11, max = 11, message = "Length must be size 11")
	private String cpf;
	@NotEmpty(message = "income can't be empty")
	private Double income;
	@NotEmpty(message = "birthDate can't be empty")
	@Past(message = "birthDate must be in the past")
	private Instant birthDate;
	@NotEmpty(message = "children can't be empty")
	private Integer children;

	public ClientDTO() {
	}

	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.birthDate = entity.getBirthDate();
		this.children = entity.getChildren();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Client toEntity() {
		return new Client(id, name, cpf, income, birthDate, children);
	}	
}
