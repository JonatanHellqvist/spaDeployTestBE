package com.kattspa.kattspa.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Bookings")
public class Bookings {
	@Id
	private String id;
	private Date date;
	private String slot;
	@Field("package")
	private String spaPackage;
	private String name;
	private String email;
	
	public Bookings(String id, Date date, String slot, String spaPackage, String name, String email) {
		this.id = id;
		this.date = date;
		this.slot = slot;
		this.spaPackage = spaPackage;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	@JsonProperty("package")
	public String getSpaPackage() {
		return spaPackage;
	}

	@JsonProperty("package")
	public void setSpaPackage(String spaPackage) {
		this.spaPackage = spaPackage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}





	// "id": "99f9",
    //   "date": "2024-04-25",
    //   "slot": "Eftermiddag",
    //   "package": "Cold",
    //   "name": "kalle",
    //   "email": "kalle@kalle.com"