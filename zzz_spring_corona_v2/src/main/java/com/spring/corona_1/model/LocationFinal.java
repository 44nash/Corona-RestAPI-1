package com.spring.corona_1.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@NamedQuery(name = "DeleteMarkers", query = "DELETE  FROM location where killdate <= curdate()")
@Table(name = "locationfinal")
public class LocationFinal {
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    

	@Column(name = "place")
	private String place;

	@Column(name = "renderdate")
	private  Date renderdate;

	@Column(name = "killdate")
	private  Date killdate;

	@Column(name = "color")
	private  int color;

	public LocationFinal(String place, Date renderdate, Date killdate, int color) {
		this.place = place;
		this.renderdate = renderdate;
		this.killdate = killdate;
		this.color = color;
	}

	
	
	
	
	
	public LocationFinal() {

	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getRenderdate() {
		return renderdate;
	}

	public void setRenderdate(Date renderdate) {
		this.renderdate = renderdate;
	}

	public  Date getKilldate() {
		return killdate;
	}

	public  void setKilldate(Date killdate) {
		this.killdate = killdate;
	}

	public  int getColor() {
		return color;
	}

	public  void setColor(int color) {
		this.color = color;
	}






	@Override
	public String toString() {
		return "Location [place=" + place + ", renderdate=" + renderdate + ", killdate=" + killdate + ", color=" + color
				+ "]";
	}

	
	
	//Not needed probably but will keep in case
//	public Location() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	
	
	
	
	
}
