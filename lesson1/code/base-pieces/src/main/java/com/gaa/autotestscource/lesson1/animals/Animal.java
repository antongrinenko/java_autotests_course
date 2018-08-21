package com.gaa.autotestscource.lesson1.animals;

public class Animal {
	private int age;
	private float weight;
	protected String name;
	public boolean isWild;

	public Animal(int age, float weight, String name, boolean isWild) {
		this.age = age;
		this.weight = weight;
		this.name = name;
		this.isWild = isWild;
	}

	public String getInfo() {
		return "\n" +
				"--------------------\n" +
				"Name: " + name + "\n" +
				"Age: " + age + "\n" +
				"Weight: " + weight + " kg\n" +
				"Is wild: " + isWild;
	}
}
