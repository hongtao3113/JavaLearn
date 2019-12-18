package com.google.base.classes;

public class Cat extends Animals{



	public Cat() {

	}

	@Override
	public void walk() {
		System.out.println("我是猫，我会跑");
	}

	public static void main(String[] args) {
		Animals animals = new Cat();
		animals.setAnimalName("cat");
		System.out.println(animals.animalName);
		animals.walk();
	}

}
