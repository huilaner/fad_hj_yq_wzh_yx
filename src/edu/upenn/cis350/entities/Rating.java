package edu.upenn.cis350.entities;

import java.io.Serializable;

public class Rating implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long user_id;
	private Long provider_id;
	private String user_name;
	private String date;
	private String review_summary;
	private String review;
	private Integer rating;
	private Integer communication_rating = 0;
	private Integer office_environment_rating = 0;
	private Integer friendliness_rating = 0;
	private Integer professional_rating = 0;
	private Integer costs_rating = 0;
	private Integer availability_rating = 0;
	private Integer con1 = 0;
	private Integer con2 = 0;
	private Integer con3 = 0;
	private Integer pro1 = 0;
	private Integer pro2 = 0;
	private Integer pro3 = 0;


	public Rating(long user, long provider, String user_name, String date, String review_summary, String desc, int rate,
			int communication_rating, int office_environment_rating,
			int friendliness_rating, int professional_rating, int costs_rating,
			int availability_rating, int pro1, int pro2, int pro3, int con1, int con2, int con3) {
		this.user_id = user;
		this.provider_id = provider;
		this.user_name = user_name;
		this.date = date;
		this.review_summary = review_summary;
		this.review = desc;
		this.rating = rate;
		this.communication_rating = communication_rating;
		this.office_environment_rating = office_environment_rating;
		this.friendliness_rating = friendliness_rating;
		this.professional_rating = professional_rating;
		this.costs_rating = costs_rating;
		this.availability_rating = availability_rating;
		this.pro1 = pro1;
		this.pro2 = pro2;
		this.pro3 = pro3;
		this.con1 = con1;
		this.con2 = con2;
		this.con3 = con3;
	}

	public Rating(long user, long provider, String review_summary, String date, String desc, int rate) {
		this.user_id = user;
		this.provider_id = provider;
		this.date = date;
		this.review_summary = review_summary;
		this.review = desc;
		this.rating = rate;
	}

	public Long getUser(){
		return user_id;
	}
	public Long getProvider(){
		return provider_id;
	}
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getReview_summary() {
		return review_summary;
	}

	public Integer getCon1() {
		return con1;
	}

	public void setCon1(Integer con1) {
		this.con1 = con1;
	}

	public Integer getCon2() {
		return con2;
	}

	public void setCon2(Integer con2) {
		this.con2 = con2;
	}

	public Integer getCon3() {
		return con3;
	}

	public void setCon3(Integer con3) {
		this.con3 = con3;
	}

	public Integer getPro1() {
		return pro1;
	}

	public void setPro1(Integer pro1) {
		this.pro1 = pro1;
	}

	public Integer getPro2() {
		return pro2;
	}

	public void setPro2(Integer pro2) {
		this.pro2 = pro2;
	}

	public Integer getPro3() {
		return pro3;
	}

	public void setPro3(Integer pro3) {
		this.pro3 = pro3;
	}
}