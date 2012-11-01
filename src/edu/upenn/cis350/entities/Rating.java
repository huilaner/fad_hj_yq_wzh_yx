package edu.upenn.cis350.entities;

import java.io.Serializable;

public class Rating implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long user_id;
	private Long provider_id;
	private String date;
	private String review;
	private Integer rating;
	private Integer communication_rating = 0;
	private Integer office_environment_rating = 0;
	private Integer friendliness_rating = 0;
	private Integer professional_rating = 0;

	private Integer costs_rating = 0;
	private Integer availability_rating = 0;
	
	public Rating(long user, long provider, String date, String desc, int rate,
			int communication_rating, int office_environment_rating,
			int friendliness_rating, int professional_rating, int costs_rating,
			int availability_rating) {
		this.user_id = user;
		this.provider_id = provider;
		this.date = date;
		this.review = desc;
		this.rating = rate;
		this.communication_rating = communication_rating;
		this.office_environment_rating = office_environment_rating;
		this.friendliness_rating = friendliness_rating;
		this.professional_rating = professional_rating;
		this.costs_rating = costs_rating;
		this.availability_rating = availability_rating;
	}
	
	public Rating(long user, long provider, String date, String desc, int rate) {
		this.user_id = user;
		this.provider_id = provider;
		this.date = date;
		this.review = desc;
		this.rating = rate;
	}

	public Long getUser(){
		return user_id;
	}
	public Long getProvider(){
		return provider_id;
	}
	public String getDate(){
		return date;
	}
	public String getReview(){
		return review;
	}
	public Integer getRating(){
		return rating;
	}
	
	public Integer getCommunication_rating() {
		return communication_rating;
	}

	public Integer getOffice_environment_rating() {
		return office_environment_rating;
	}

	public Integer getFriendliness_rating() {
		return friendliness_rating;
	}
	
	public Integer getProfessional_rating() {
		return professional_rating;
	}

	public Integer getCosts_rating() {
		return costs_rating;
	}

	public Integer getAvailability_rating() {
		return availability_rating;
	}
}
