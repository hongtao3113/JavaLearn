package com.google.base.classes;

public abstract class Animals {
	
	String animalName = "";
	
	public Animals() {
		System.out.println("�����޲ι��췽��");
	}
	
	
	
	public Animals(String animalName) {
		super();
		this.animalName = animalName;
		System.out.println("�����вι��췽��");
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
		System.out.println("���ﶼ����");
	}
}
