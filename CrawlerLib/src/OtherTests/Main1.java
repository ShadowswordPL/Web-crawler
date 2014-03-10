package OtherTests;

import java.util.TreeMap;
import pl.edu.mimuw.crawler.aj334557.AlwaysTrueCondition;
import pl.edu.mimuw.crawler.aj334557.Condition;
import pl.edu.mimuw.crawler.aj334557.Crawler;
import pl.edu.mimuw.crawler.aj334557.InternetPageInfo;
import pl.edu.mimuw.crawler.aj334557.PageInfo;
import pl.edu.mimuw.crawler.aj334557.PageInfoQueue;
import pl.edu.mimuw.crawler.aj334557.Statistics;
import pl.edu.mimuw.crawler.aj334557.TreeMapSort;

public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		PageInfo pi = new InternetPageInfo(args[0]);
		Crawler c = new Crawler(pi);
		Condition s = new AlwaysTrueCondition();
		PageInfoQueue q = c.Crawl(1, s);
		
		TreeMap<String, Integer> tm = Statistics.countDomains(q, s);
		TreeMapSort<String, Integer> TMS = new TreeMapSort<String, Integer>();
		System.out.println(TMS.Sort(tm));		
		
	}

}
