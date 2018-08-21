package com.gaa.autotestscource.lesson1;

import com.gaa.autotestscource.lesson1.animals.Animal;
import com.gaa.autotestscource.lesson1.animals.Bear;
import com.gaa.autotestscource.lesson1.animals.Cat;

import java.util.ArrayList;
import java.util.List;

public class BasePieces {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Cat("Alona"));
		animals.add(new Bear());

		int counter = 0;
		while (counter < 3) {
			animals.add(new Cat("Alona"));
			counter = counter + 1;
		}

		for (Animal animal : animals) {
			System.out.println(animal.getInfo());
		}
	}
}
