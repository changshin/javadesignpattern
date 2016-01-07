package com.chang.oodp.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// http://javapapers.com/design-patterns/observer-design-pattern/

public class BlogUserObserverMain {
	public static void main(String args[]) {
		BlogImpl blog = new BlogImpl();
		User user1 = new User("user1");
		User user2 = new User("user2");
		
		//blog.registerObserver(user1);
		//blog.registerObserver(user2);
		//user1.setBlog(blog);
		//user2.setBlog(blog);
		
		List<Observer> observers = new ArrayList<Observer>();
		observers.add(user1);
		observers.add(user2);
		for ( Observer observer: observers ) {
			blog.registerObserver(observer);
			observer.setBlog(blog);
		}
		
		System.out.println("======"+user1.getArticle());		
		System.out.println("======"+user2.getArticle());		
		blog.postNewArticle();
		System.out.println("======"+user1.getArticle());
		System.out.println("======"+user2.getArticle());
	}

}


class BlogImpl implements Blog {

	private List<Observer> observersList;
	private boolean stateChange;

	public BlogImpl() {
		this.observersList = new ArrayList<Observer>();
		stateChange = false;
	}

	public void registerObserver(Observer observer) {
		observersList.add(observer);
	}

	public void unRegisterObserver(Observer observer) {
		observersList.remove(observer);
	}

	public void notifyObserver() {

		if (stateChange) {
			for (Observer observer : observersList) {
				observer.update();
			}
		}
	}

	public Object getUpdate() {
		Object changedState = null;
		// should have logic to send the
		// state change to querying observer
		if (stateChange) {
			changedState = "changed new Article Design Pattern";
		}
		return changedState;
	}

	public void postNewArticle() {
		stateChange = true;
		notifyObserver();
	}

}

interface Blog {
	public void registerObserver(Observer observer);
	public void notifyObserver();
	public void unRegisterObserver(Observer observer);
	public Object getUpdate();
}

class User implements Observer {

	private String article;
	private Blog blog;
	private String name;

	public User(String name) {
		this.name = name;
	}
	
	@Override
	public void setBlog(Blog blog) {
		this.blog = blog;
		article = "No New Article!";	// default value
	}

	@Override
	public void update() {
		//System.out.println(name + ",State change reported by Subject.");
		article = (String) blog.getUpdate();
		System.out.println(name + ",article="+ article);
	}

	public String getArticle() {
		return article;
	}
}

interface Observer {
	public void update();
	public void setBlog(Blog blog);
}

