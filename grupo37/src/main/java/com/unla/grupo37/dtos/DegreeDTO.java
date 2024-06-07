package com.unla.grupo37.dtos;

public class DegreeDTO {
	private int id;
	private String name;
	private String institution;
	private int year;

	public DegreeDTO() {}
	
	public DegreeDTO(int id, String name, String institution, int year) {
		this.setId(id);
		this.name = name;
		this.institution = institution;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}