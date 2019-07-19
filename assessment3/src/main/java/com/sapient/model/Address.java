package com.sapient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	 @Id
	    @Column(name="u_id")
	 	private long id;
	    private String city;
	    private String state;
	    private String zipCode;
		@Override
		public String toString() {
			return "Address [id=" + id + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
		}


}
