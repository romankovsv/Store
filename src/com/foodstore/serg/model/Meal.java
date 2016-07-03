package com.foodstore.serg.model;

import java.math.BigDecimal;

public class  Meal {
	
	private final long id;
	private final String title;
	private final String description;
	private final String type;
	private final Boolean available;
	private final BigDecimal price;
	private final String owner;
		
	private static long countId = 0;
	
	private Meal(MealBuilder builder){
		this.id = builder.id;
		this.title = builder.title;
		this.description = builder.description;
		this.type = builder.type;
		this.available = builder.available;
		this.price = builder.price;
		this.owner = builder.owner;
	}
	
	
	public static class MealBuilder{
		private long id;
		private String title;
		private String description;
		private String type;
		private Boolean available;
		private BigDecimal price;
		private String owner;
		
		public MealBuilder(){//TODO Make constructor for mandatory fields 
			
		}
		
		public MealBuilder title(final String  title){
			this.title = title;
			return this;
		}
		
		public MealBuilder description(final String  description){
			this.description = description;
			return this;
		}
		
		public MealBuilder type(final String  type){
			this.type = type;
			return this;
		}
		
		public MealBuilder available(final Boolean available){
			this.available = available;
			return this;
		}
		
		public MealBuilder price(final String price){
			this.price = new BigDecimal(price);
			return this;
		}
		
		public MealBuilder owner(final String  owner){
			this.owner = owner;
			return this;
		}
		
		public MealBuilder id(){
			this.id = ++countId;
			return this;
		}
		
		public Meal build(){
			return new Meal(this);
		}
	}
	
	
	public long getId(){
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getOwner() {
		return owner;
	}

	
	@Override
	public String toString(){
		StringBuilder strBuilder = new StringBuilder();
		
		return	strBuilder.append("Meal{ Id=")
				.append(id)
				.append(", Title=")
				.append(title)
				.append(", Type=")
				.append(type)
				.append(", Price=")
				.append(price)
				.append(", Owner=")
				.append(owner)
				.append(", is available=")
				.append(available)
				.append("}")
				.toString();
	}
}
