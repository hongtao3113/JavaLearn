package com.google.base.classes;

public abstract class Animals {

	String animalName = "";

	public Animals() {
		System.out.println("父类无参构造方法");
	}


	public Animals(String animalName) {
		super();
		this.animalName = animalName;
		System.out.println("父类有参构造方法");
	}



	public static void main(String[] args) {

	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public void walk() {
		System.out.println("动物都会走");
	}
}
