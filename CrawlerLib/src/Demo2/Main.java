package Demo2;

import java.util.TreeMap;
import pl.edu.mimuw.crawler.aj334557.Condition;
import pl.edu.mimuw.crawler.aj334557.Crawler;
import pl.edu.mimuw.crawler.aj334557.HDDPageInfo;
import pl.edu.mimuw.crawler.aj334557.PageInfo;
import pl.edu.mimuw.crawler.aj334557.PageInfoQueue;
import pl.edu.mimuw.crawler.aj334557.SamePageRootCondition;
import pl.edu.mimuw.crawler.aj334557.Statistics;

public class Main {

	/**
	 * @param args 
	 */
	public static void main(String[] args){		
		PageInfo pi = new HDDPageInfo(args[0]);
		Crawler c = new Crawler(pi);
		Condition s = new SamePageRootCondition(PageInfo.getFolder(args[0]));
		int argInt = args[1].charAt(0) - '0';
		PageInfoQueue q = c.Crawl(argInt, s);
		TreeMap<String, Integer> tm = Statistics.countPages(q, s);
		int mainpage = 0;
		if(!tm.containsKey(args[0])){
			mainpage++;
		}
		System.out.println(tm.size()+mainpage);
		
	}

}
