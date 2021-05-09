package com.sherry.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Data
public class Customer {

	@Id
	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "password")
	private String password;

	@Override
	public String toString() {
		return "Customer{" + "customerName='" + customerName + '\'' + ", password='" + password + '\'' + '}';
	}
}
