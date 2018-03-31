package packbarbestial;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		Node<T> berria=new Node<T>(elem);
		if (isEmpty()){
			first=berria;
			count++;
		}
		else if (count==1){
			if(first.data.compareTo(elem)<0){
				berria.prev=first;
				berria.next=first;
				first.prev=berria;
				first.next=berria;
				count++;
			}else{
				berria.next=first;
				berria.prev=first;
				first.next=berria;
				first.prev=berria;
				first=berria;
				count++;
			}
		}else{
			boolean handiagoa=false;
			Node<T> current=first;
			while(!handiagoa && current!=first.prev){
				if(current.data.compareTo(elem)>0){
					handiagoa=true;
				}else{
					current=current.next;
				}
			}if(current.data.compareTo(elem)>0 && current==first.prev){
				handiagoa=true;
			}
				if (handiagoa){
				berria.prev=current.prev;
				berria.next=current;
				current.prev.next=berria;
				current.prev=berria;
				if(current==first) first=berria;
				count++;
			}else{
				berria.prev=first.prev;
				berria.next=first;
				first.prev.next=berria;
				first.prev=berria;
				count++;
			}
		}
		//O(N) N listaren elementu kopurua izanik
		// KODEA OSATU ETA KOSTUA KALKULATU



	}


}
