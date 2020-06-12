package com.app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CustomModel {
	
	private Integer personId;
	
	private String personName;

	public CustomModel(Integer personId, String personName) {
		super();
		this.personId = personId;
		this.personName = personName;
	}
	
}
