package com.chang.oodp.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// http://javapapers.com/design-patterns/observer-design-pattern/
/*
 * one-to-many dependency between objects so that when one object changes state, 
 * all its dependents are notified and updated automatically. 
 */
public class BlogUserObserverMain {
	public static void main(String args[]) {
		BlogImpl blog = new BlogImpl();
		User user1 = new User("user Chang");
		User user2 = new User("user Jeffrey");
		
		//blog.registerObserver(user1);
		//blog.registerObserver(user2);
		//user1.setBlog(blog);
		//user2.setBlog(blog);
		
		List<Observer> observers = new ArrayList<Observer>();
		observers.add(user1);
		observers.add(user2);
		String article = "No Aricale";
		for ( Observer observer: observers ) {
			blog.registerObserver(observer);
			observer.setBlog(blog,article);	// interface
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
				observer.update();	// interface
			}
		}
	}

	public Object getUpdate() {
		Object changedState = null;
		// should have logic to send the state change to querying observer
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
//	public void registerObserver(Observer observer);
//	public void unRegisterObserver(Observer observer);
//	public void notifyObserver();
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
	public void setBlog(Blog blog,String article) {
		this.blog = blog;
		this.article =article;	// default value
	}

	//@Override
	public void update() {
		//System.out.println(name + ",State change reported by Subject.");
		article = (String) blog.getUpdate();
		//System.out.println(name + ",article="+ article);
	}

	public String getArticle() {
		return article;
	}
}

interface Observer {
	public void update();
	public void setBlog(Blog blog,String article);
}

