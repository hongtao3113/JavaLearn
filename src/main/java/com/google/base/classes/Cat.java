package com.google.base.classes;

public class Cat extends Animals{
	
	
	
	public Cat() {
		
	}
	
	public void run() {
		System.out.println("����è���һ���");
	}
	
	public static void main(String[] args) {
		Animals animals = new Cat();
		animals.setAnimalName("cat");
		System.out.println(animals.animalName);
		animals.walk();
	}

}
