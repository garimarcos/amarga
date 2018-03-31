package packbarbestial;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
	protected Node<T> first; // lehenengoaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count;

	public DoubleLinkedList() {
		first = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String ize) {
	  deskr = ize;
	}

	public String getDeskr() {
	  return deskr;
	}

	public T removeFirst() {
	// listako lehen elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		// KODEA OSATU ETA KOSTUA KALKULATU
		if(count==1) {
			T elem=first.data;
			first=null;
			count--;
			return elem;
		}
		//else if (isEmpty()) return null; AURREBALDINTZA
		else{
			T elem=first.data;
			first.next.prev=first.prev;
			first.prev.next=first.next;
			first=first.next;
			count--;
			return elem;
		}
		//O(1)
	}

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		// KODEA OSATU ETA KOSTUA KALKULATU
	    if(count==1) {
	    	T elem=first.data;
	    	first=null;
	    	count--;
	    	return elem;
	    }//else if (isEmpty()) return null; AURREBALDINTZA 
	    else{
	    T elem=first.prev.data;
	    first.prev.prev.next=first;
	    first.prev=first.prev.prev;
	    count--;
	    return elem;
	    }
	    //O(1)
    }


	public T remove(T elem) {
	// Aurrebaldintza: zerrenda ez da hutsa
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
        //  bueltatuko du (null ez baldin badago)
		//if(isEmpty()) return null; AURREBALDINTZA
		if(first.data.equals(elem)){
			T b=first.data;
			first.prev.next=first.next;
			first=first.next;
			count--;
			return b;
		}
		else{
			Iterator<T> itr=iterator();
			boolean found=false;
			Node<T> current=first;
		while(!found && itr.hasNext()){
			if (current.data.equals(elem)){
				found=true;
			}else{
				current=current.next;
			}	
		}
		if (found){
			T b=current.data;
			current.prev.next=current.next;
			current.next.prev=current.prev;
			count--;
			return b;
		}
		}
		return null;
		//O(n) n listaren elementu kopurua izanik
		// KODEA OSATU ETA KOSTUA KALKULATU
        }

	public T first() {
	// listako lehen elementua ematen du
	      if (isEmpty())
	          return null;
	      else return first.data;
	      //O(1)
	}

	public T last() {
	// listako azken elementua ematen du
	      if (isEmpty())
	          return null;
	      else if (count==1) return first.data;
	      else return first.prev.data;
	      //O(1)
	}

	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		      if (isEmpty())
		          return false;
		      Iterator<T> itr=this.iterator();
		      while(itr.hasNext()){
		    	  T aux=itr.next();
		    	  if (aux.equals(elem)) return true;
		      }
		      return false;
		      //O(N) N listaren elementu kopurua izanik
		      		// KODEA OSATU ETA KOSTUA KALKULATU
		   }

	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela
		if (isEmpty())
	          return null;
	      Iterator<T> itr=this.iterator();
	      while(itr.hasNext()){
	    	  T aux=itr.next();
	    	  if (aux.equals(elem)) return elem;
	      }
	      return null;
		//O(N) N listaren elementu kopurua izanik
		// KODEA OSATU ETA KOSTUA KALKULATU
	}

	public boolean isEmpty() 
	{ return first == null;};
	
	public int size() 
	{ return count;};
	
	public void clear(){
		first=null;
		count=0;
	}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 
		// KODEA OSATU 
		   Node<T> current=first;
		  int i=1;
		   public boolean hasNext(){
			   if(isEmpty()) return false;
			   return i<=count;
		   }
		   
		   public T next(){
			   if (!hasNext()) throw new NoSuchElementException();
			   T elem=current.data;
			   current=current.next;
			   i++;
			   return elem;
		   }
			   
			   public void remove(){
				   try {
					throw new Exception("Not implemented");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		   
	   } // private class
		
		
		public void adabegiakInprimatu() {
			if(first==null) System.out.println("null");
			else{
				System.out.println(this.toString());
				//System.out.println(first.prev.data);
			}

		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result;
		}

}
