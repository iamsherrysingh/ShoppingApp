package com.sherry.frauddetection.model.gson;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sherry.frauddetection.model.Order;

import lombok.NoArgsConstructor;

import com.google.gson.stream.JsonToken;

@NoArgsConstructor
public class OrderAdapter extends TypeAdapter<Order>{

	@Override
	public void write(JsonWriter writer, Order value) throws IOException {
		writer.beginObject(); 
		writer.name("userId"); 
		writer.value(value.getUserId().toString()); 
		writer.name("nbOfItems"); 
		writer.value(value.getNbOfItems()); 
		writer.name("totalAmount"); 
		writer.value(value.getTotalAmount()); 
		writer.endObject(); 	
	}

	@Override
	public Order read(JsonReader reader) throws IOException {
	      Order order = new Order(); 
	      reader.beginObject(); 
	      String fieldname = null; 
	      
	      while (reader.hasNext()) { 
	    	  JsonToken token = reader.peek();            
	         
	         if (token.equals(JsonToken.NAME)) {     
	            //get the current token 
	            fieldname = reader.nextName(); 
	         } 
	         
	         if ("userId".equals(fieldname)) {       
	            //move to next token 
	            token = reader.peek(); 
	            order.setUserId(reader.nextString()); 
	         } 
	         
	         if("nbOfItems".equals(fieldname)) { 
	            //move to next token 
	            token = reader.peek(); 
	            order.setNbOfItems(reader.nextInt()); 
	         }        
	         
	         if("totalAmount".equals(fieldname)) { 
		            //move to next token 
		            token = reader.peek(); 
		            order.setTotalAmount((float)(reader.nextDouble())); 
		         }  
	      } 
	      reader.endObject(); 
	      return order; 
	}

}
