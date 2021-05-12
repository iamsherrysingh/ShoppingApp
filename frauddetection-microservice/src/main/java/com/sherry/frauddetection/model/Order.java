package com.sherry.frauddetection.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Order {
	   private String userId;
	   private int nbOfItems;
	   private float totalAmount;
}










