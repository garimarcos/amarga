package packbarbestial;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// hasieran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> berria=new Node<T>(elem);
		if(count==1){
			berria.next=first;
			berria.prev=first;
			first.next=berria;
			first.prev=berria;
			first=berria;
		}else if(isEmpty()){
			first=berria;
			first.prev=first;
			first.next=first;
		}else{
		berria.next=first;
		berria.prev=first.prev;
		first.prev.next=berria;
		first.prev=berria;
		first=berria;
		}
		count++;
		//O(1)
	}

	public void addToRear(T elem) {
	// bukaeran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> berria=new Node<T>(elem);
		if (isEmpty()){
			first=berria;
			first.next=first;
			first.prev=first;
		}else if(count==1){
			first.next=berria;
			first.prev=berria;
			berria.next=first;
			berria.prev=first;
		}
		else{
			berria.next=first;
			berria.prev=first.prev;
			first.prev.next=berria;
			first.prev=berria;
		}
		count++;
		//O(1)
	}
	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		Node<T> current=first;
		boolean aurkituta=false;
		while (!aurkituta /*current!=first.prev*/){//TARGET ZERRENDAN DAGO
			if (current.data.equals(target)){
				aurkituta=true;
			}else{
				current=current.next;
			}
		}
		if (!aurkituta && current.data.equals(target)){
			aurkituta=true;
		}
		if (aurkituta){
			Node<T> berria=new Node<T>(elem);
			berria.prev=current;
			berria.next=current.next;
			current.next=berria;
			current.next.prev=berria;
		}
		//O(N) N listaren elementu kopurua izanik
	}

}
