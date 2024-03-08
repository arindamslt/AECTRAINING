package com.arindam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer foodid;
	@Column(length = 25)
private String foodnm;
private Double price;
}
