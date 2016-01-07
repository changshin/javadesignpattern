package com.chang.oodp.creational.prototype;

// http://www.avajava.com/tutorials/lessons/prototype-pattern.html

public class PersonDogMain {
	public static void main(String[] args) {
		Person person1 = new Person("Fred");
		System.out.println("person 1:" + person1);
		Person person2 = (Person) person1.doClone();
		System.out.println("person 2:" + person2);

		Dog dog1 = new Dog("Wooof!");
		System.out.println("dog 1:" + dog1);
		Dog dog2 = (Dog) dog1.doClone();
		System.out.println("dog 2:" + dog2);
	}
}

interface Prototype {
	public Prototype doClone();
}

class Person implements Prototype {

	String name;
	public Person(String name) {
		this.name = name;
	}

	@Override
	public Prototype doClone() {
		return new Person(name);
	}

	public String toString() {
		return "This person is named " + name;
	}
}

class Dog implements Prototype {

	String sound;
	public Dog(String sound) {
		this.sound = sound;
	}

	@Override
	public Prototype doClone() {
		return new Dog(sound);
	}

	public String toString() {
		return "This dog says " + sound;
	}
}