package pl.edu.mimuw.crawler.aj334557;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PageInfoQueue implements Queue<PageInfo> {
	LinkedList<PageInfo> list;
	
	/**
	 * Constructor makes standard linked list
	 * implemetation of Queue, parametrised 
	 * to contain PageInfo objects, with nw
	 * addCorrect method
	 */
	public PageInfoQueue(){
		list = new LinkedList<PageInfo>();
	}

	/** Funcion add arg0 only when it's correctly recived PageInfo */
	public void addCorrect(PageInfo arg0){
		if(arg0.isCorrect()){
			offer(arg0);
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends PageInfo> arg0) {
		int var = this.size();
		for(PageInfo arg : arg0){
			this.add(arg);
		}
		int var2 = this.size();
		return var == var2;
	}

	@Override
	public void clear() {
		list.clear();
		
	}

	@Override
	public boolean contains(Object arg0) {
		return list.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return list.contains(arg0);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<PageInfo> iterator() {
		return list.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return list.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		int var = this.size();
		for(Object arg : arg0){
			this.remove(arg);
		}
		int var2 = this.size();
		return var == var2;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return list.retainAll(arg0);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return list.toArray(arg0);
	}

	@Override
	public boolean add(PageInfo arg0) {
		return list.add(arg0);
	}

	@Override
	public PageInfo element() {
		return list.getLast();
	}

	@Override
	public boolean offer(PageInfo arg0) {
		return add(arg0);
	}

	@Override
	public PageInfo peek() {
		if(size() == 0){
			return null;
		}
		return element();
	}

	@Override
	public PageInfo poll() {
		if(size() == 0){
			return null;
		}
		return remove();
	}

	@Override
	public PageInfo remove() {
		PageInfo n = list.getFirst();
		list.removeFirst();
		return n;
	}
	
}
