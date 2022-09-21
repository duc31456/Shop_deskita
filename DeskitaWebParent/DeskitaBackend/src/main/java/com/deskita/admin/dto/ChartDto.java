package com.deskita.admin.dto;

public class ChartDto {
	private Integer id;
	private float total;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "ChartDto [id=" + id + ", total=" + total + "]";
	}
	public ChartDto(Integer id, float total) {
		this.id = id;
		this.total = total;
	}
	
	public ChartDto() {
	}
	
}
