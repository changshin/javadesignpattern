package com.chang.oodp.creational.prototype;

import java.util.Hashtable;

// http://java.dzone.com/articles/design-patterns-prototype
// Does not work

public class ItemPriceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemRegistry registry = new ItemRegistry();
		Item myBook = registry.createBasicItem("Book");
		myBook.setTitle("Custom Title");  
	}

}

class ItemRegistry {
	private Hashtable<String,Item> map  = new Hashtable<String,Item>(); 
	
    public ItemRegistry() {
	   loadCache();
	}
	
	
    public Item createBasicItem(String type) { 
    	Item item = (Item) map.get(type);
	   return item.clone();
	   
	}

    private void loadCache()  {
	    Book book = new Book();
		book.setTitle("Design Patterns"); 
		book.setPrice(20.00);
		map.put("Book", book); 
		
		CD cd = new CD();
		cd.setTitle("Various"); 
		cd.setPrice(10.00);
		map.put("CD", cd); 
		
    }
}


class Item {
	private String title;
	private double price;

	public Item clone() {
		Item clonedItem = null;
		try {
			// use default object clone.
			clonedItem = (Item) super.clone();
			// specialised clone
			clonedItem.setPrice(price);
			clonedItem.setTitle(title);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} // catch
		return clonedItem;

	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}
}

class Book extends Item {
	// extra book stuff
}

class CD extends Item {
	// extra cd stuff

}