package com.chang.oodp.behavioral.iterator;

// http://www.tutorialspoint.com/design_pattern/iterator_pattern.htm

public class NameRepositoryMain {
	public static void main(String[] args) {
		NameRepository namesRepository = new NameRepository();

		for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.println("Name : " + name);
		}
		
		//namesRepository = new NameRepository();
		Iterator iter = namesRepository.getIterator();
		while (iter.hasNext()) {
			String name = (String) iter.next();
			System.out.println("Name : " + name);
		}
	}
}

class NameRepository implements Container {
	public String names[] = { "Robert", "John", "Julie", "Lora" };

	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		int index;

		@Override
		public boolean hasNext() {

			if (index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {

			//if (this.hasNext()) {
				return names[index++];
			//}
			//return null;
		}
	}
}

interface Container {
	public Iterator getIterator();
}

interface Iterator {
	public boolean hasNext();

	public Object next();
}