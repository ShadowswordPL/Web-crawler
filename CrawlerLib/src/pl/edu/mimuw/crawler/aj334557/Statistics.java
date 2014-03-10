package pl.edu.mimuw.crawler.aj334557;

import java.util.TreeMap;

public class Statistics {
	
	/**
	 * This method add to TreeMap all domains meeting given condition
	 * @param q is PageInfoQueue with queue of pages to count
	 * @return TreeMap<String, Integer> with all founded domains as key and number of occurrence as value
	 */
	static public TreeMap<String, Integer> countDomains(PageInfoQueue q, Condition condition){
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		while(!q.isEmpty()){
			PageInfo pi = q.poll();
			if(condition.condition(pi)){
				if(!tm.containsKey(pi.getDomain())){
					tm.put(pi.getDomain(), 1);
				}
				else{
					tm.put(pi.getDomain(), (tm.get(pi.getDomain())+1));
				}
			}
		}	
		return tm;
	}
	
	/**
	 * This method add to TreeMap all pages meeting given condition
	 * @param q is PageInfoQueue with queue of pages to count
	 * @return TreeMap<String, Integer> with all founded pages as key and number of occurrence as value
	 */
	static public TreeMap<String, Integer> countPages(PageInfoQueue q, Condition condition){
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		while(!q.isEmpty()){
			PageInfo pi = q.poll();
			if(condition.condition(pi)){
				if(!tm.containsKey(pi.getRoot()+pi.getPath())){
					tm.put(pi.getRoot()+pi.getPath(), 1);
				}
				else{
					tm.put(pi.getRoot()+pi.getPath(), (tm.get(pi.getRoot()+pi.getPath())+1));
				}
			}
		}	
		return tm;
	}
}
