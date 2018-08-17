package com.capgemini.capstore.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Image {

	private String  imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
