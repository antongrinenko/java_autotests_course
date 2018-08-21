package com.gaa.autotestscource.lesson1.animals;

public class Cat extends Animal {
	private String ownerName;

	public Cat(String ownerName) {
		super(2, 3.5F, "Tomas", false);
		this.ownerName = ownerName;
	}
}
