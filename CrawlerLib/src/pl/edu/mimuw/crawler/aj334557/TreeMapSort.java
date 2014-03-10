package pl.edu.mimuw.crawler.aj334557;

import java.util.TreeMap;

public class TreeMapSort<T, K extends Comparable<K>> {
	
	/**
	 * 
	 * @return String with sorted by key elements of TreeMap,
	 * every in format Key + " " + Value + "\n"
	 */
	public String Sort(TreeMap<T, K> tm){
		int count = tm.size();
		String result = "";
		for (int i = 0; i < count; i++){
			K MAX = tm.get(tm.firstKey());
			T MAXKey = tm.firstKey();
			for(T s : tm.keySet()){
				if (tm.get(s).compareTo(MAX) > 0){
					MAX = tm.get(s);
					MAXKey = s;
				}
			}
			result = result + MAXKey + " " + MAX + "\n";
			tm.remove(MAXKey);
		}
		return result;
	}
	
}
