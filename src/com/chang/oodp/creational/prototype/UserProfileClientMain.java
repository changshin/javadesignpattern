/**
 * 
 */
package com.chang.oodp.creational.prototype;

import java.util.Hashtable;

/**
 * This is the client class which will access ProfileRegistry
 * 
 * @author Idiotechie
 *         http://www.javacodegeeks.com/2012/11/prototype-design-pattern
 *         -creating-another-dolly.html
 */
public class UserProfileClientMain {
	public static void main(String args[]) {
		UserProfileRegistry.loadCache();
		// Client needs a new UserProfile object through getProfile() method
		Identity clonedIdentity = (Identity) UserProfileRegistry.getProfile("Charles Keating");
		System.out.println("UserProfile as cloned Identity");
		System.out.println("Name:" + clonedIdentity.getName());
		System.out.println("Date of Birth:" + clonedIdentity.getDob());
		BankDetails clonedBankDetails = (BankDetails) UserProfileRegistry.getProfile("Idiotechie");
		System.out.println("UserProfile as cloned BankDetail");
		System.out.println("Name:" + clonedBankDetails.getName());
		System.out.println("Bank Account Details:"
				+ clonedBankDetails.getBankAccount());
	}
}

class UserProfileRegistry {
	private static Hashtable<String, UserProfile> profileMap = new Hashtable<String, UserProfile>();

	// Get the profile data from client and return cloned object
	public static UserProfile getProfile(String profileData) {
		UserProfile cachedProfile = (UserProfile) profileMap.get(profileData);
		return (UserProfile) cachedProfile.clone();
	}

	/**
	 * This method currently creates two Profile objects - Identity and Bank
	 * account For each Profile object it might be an expensive query run, in
	 * case the calls are related to Database query. So run this query and
	 * instantiate and keep the details into the profileMap for later cloning.
	 */
	public static void loadCache() {
		// First copy of the object Identity(UserProfile) is created.
		// Only after this the cloning can be done.
		Identity identity = new Identity();
		identity.setName("Charles Keating");
		identity.setDob("01-Jan-1900");
		profileMap.put(identity.getName(), identity);
		// First copy of the object Bankline(UserProfile) is created.
		// Only after this the cloning can be done.
		BankDetails bankDetails = new BankDetails();
		bankDetails.setName("Idiotechie");
		bankDetails.setBankAccount(1234567890);
		profileMap.put(bankDetails.getName(), bankDetails);
	}
}

class UserProfile implements Cloneable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * This method creates and return the copy of the super class.
	 */
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;

	}

}

class BankDetails extends UserProfile {
	int bankAccount;

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}
}

class Identity extends UserProfile {
	private String dob;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}