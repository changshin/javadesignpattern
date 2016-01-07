package com.chang.oodp.behavioral.observer;

import java.util.ArrayList;

public class JobSeekHeadHunterMain {
	public static void main(String[] args) {
		HeadHunter hh = new HeadHunter();
		hh.registerObserver(new JobSeeker("Mike"));
		hh.registerObserver(new JobSeeker("Chris"));
		hh.registerObserver(new JobSeeker("Jeff"));

		// Each time, a new job is added, all registered job seekers will get
		// noticed.
		hh.addJob("Google Job");
		hh.addJob("Yahoo Job");
	}
}

class HeadHunter implements Subject {

	// define a list of users, such as Mike, Bill, etc.
	private ArrayList<JobObserver> userList;
	private ArrayList<String> jobs;

	public HeadHunter() {
		userList = new ArrayList<JobObserver>();
		jobs = new ArrayList<String>();
	}

	@Override
	public void registerObserver(JobObserver o) {
		userList.add(o);
	}

	@Override
	public void removeObserver(JobObserver o) {
	}

	@Override
	public void notifyAllObservers() {
		for (JobObserver o : userList) {
			o.update(this);
		}
	}

	public String getUpdate() {
		return jobs.toString();
	};

	public void addJob(String job) {
		this.jobs.add(job);
		notifyAllObservers();
	}

	public ArrayList<String> getJobs() {
		return jobs;
	}

	public String toString() {
		return jobs.toString();
	}
}


interface Subject {
	public void registerObserver(JobObserver o);
	public void removeObserver(JobObserver o);
	public void notifyAllObservers();
	public String getUpdate();
}

class JobSeeker implements JobObserver {

	private String name;

	public JobSeeker(String name) {
		this.name = name;
	}

	@Override
	public void update(Subject s) {
		System.out.println(this.name + " got notified!");
		// print job list
		System.out.println(s.getUpdate());
		//System.out.println(s);
	}
}

interface JobObserver {
	public void update(Subject s);
}