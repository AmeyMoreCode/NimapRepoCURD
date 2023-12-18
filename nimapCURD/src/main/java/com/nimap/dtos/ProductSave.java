package com.nimap.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductSave {
	
       
	    @JsonProperty("name") 
	    private String name;

	    @JsonProperty("price") 
	    private Integer price;

	    @JsonProperty("categoryId") 
	    private Integer categoryId;
        
		public ProductSave(String name, Integer price, Integer categoryId) {
			super();
			this.name = name;
			this.price = price;
			this.categoryId = categoryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		public Integer getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}

		@Override
		public String toString() {
			return "ProductSave [name=" + name + ", price=" + price + ", categoryId=" + categoryId + "]";
		}  
   
        
        
}
