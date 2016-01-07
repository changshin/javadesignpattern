package com.chang.oodp.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class TopicSubscriberObserverMain {
	public static void main(String[] args) {
		// create subject
		MyTopic topic = new MyTopic();

		// create observers
		Subscriber observer1 = new MyTopicSubscriber("Obj1");
		Subscriber observer2 = new MyTopicSubscriber("Obj2");
		Subscriber observer3 = new MyTopicSubscriber("Obj3");

		// register observers to the subject
		topic.register(observer1);
		topic.register(observer2);
		topic.register(observer3);

		// attach observer to subject
		observer1.setTopic(topic);
		observer2.setTopic(topic);
		observer3.setTopic(topic);

		// check if any update is available
		observer1.update();

		// now send message to subject
		topic.postMessage("Hello!, New Message");
	}

}

class MyTopic implements Topic {

	private List<Subscriber> observers;
	private String message;
	private boolean changed;
	//private final Object MUTEX = new Object();

	public MyTopic() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void register(Subscriber obj) {
		if (obj == null)
			throw new NullPointerException("Null Observer");
		//synchronized (MUTEX) {
		synchronized (this) {
			if (!observers.contains(obj))
				observers.add(obj);
		}
	}

	@Override
	public void unregister(Subscriber obj) {
		//synchronized (MUTEX) {
		synchronized (this) {
			observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Subscriber> observersLocal = null;
		// synchronization is used to make sure any observer registered after
		// message is received is not notified
		//synchronized (MUTEX) {
		synchronized (this) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed = false;
		}
		for (Subscriber observer : observersLocal) {
			observer.update();
		}

	}

	@Override
	public Object getUpdate() {
		return this.message;
	}

	// method to post message to the topic
	public void postMessage(String msg) {
		System.out.println("Message Posted to Topic:" + msg);
		this.message = msg;
		this.changed = true;
		notifyObservers();
	}

}

interface Topic {

	// methods to register and unregister observers
	public void register(Subscriber obj);

	public void unregister(Subscriber obj);

	// method to notify observers of change
	public void notifyObservers();

	// method to get updates from subject
	public Object getUpdate();

}

class MyTopicSubscriber implements Subscriber {

	private String name;
	private Topic topic;

	public MyTopicSubscriber(String nm) {
		this.name = nm;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate();
		if (msg == null) {
			System.out.println(name + ":: No new message");
		} else
			System.out.println(name + ":: Consuming message::" + msg);
	}

	@Override
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}

interface Subscriber {

	// method to update the observer, used by subject
	public void update();

	// attach with subject to observe
	public void setTopic(Topic topic);
}
