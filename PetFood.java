package com.kittypet.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PetFood {
	
	@Id
	private String id;
	private String title;
	private Double price;
	private String description;
	private String avatarUrl;
	private String imageUrl;
	private String animalType;
	
	
	public PetFood(String id, String title, Double price, String description, String avatarUrl, String imageUrl,
			String animalType) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.avatarUrl = avatarUrl;
		this.imageUrl = imageUrl;
		this.animalType = animalType;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAvatarUrl() {
		return avatarUrl;
	}


	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getAnimalType() {
		return animalType;
	}


	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}


	@Override
	public String toString() {
		return "PetFood [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", avatarUrl=" + avatarUrl + ", imageUrl=" + imageUrl + ", animalType=" + animalType + "]";
	}	

}
