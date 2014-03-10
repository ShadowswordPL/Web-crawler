package Demo1;

import java.net.URISyntaxException;
import java.util.TreeMap;

import pl.edu.mimuw.crawler.aj334557.Crawler;
import pl.edu.mimuw.crawler.aj334557.ExternalDomainCondition;
import pl.edu.mimuw.crawler.aj334557.InternetPageInfo;
import pl.edu.mimuw.crawler.aj334557.PageInfo;
import pl.edu.mimuw.crawler.aj334557.PageInfoQueue;
import pl.edu.mimuw.crawler.aj334557.SameDomainCondition;
import pl.edu.mimuw.crawler.aj334557.Statistics;
import pl.edu.mimuw.crawler.aj334557.TreeMapSort;

public class Main {

	public static void main(String[] args) throws URISyntaxException {
		
		PageInfo pi = new InternetPageInfo(args[0]);
		Crawler c = new Crawler(pi);
		SameDomainCondition s = new SameDomainCondition(pi.getDomain());
		PageInfoQueue q = c.Crawl(1000000, s);
		
		TreeMap<String, Integer> tm = Statistics.countDomains(q, new ExternalDomainCondition(pi.getDomain()));
		TreeMapSort<String, Integer> TMS = new TreeMapSort<String, Integer>();
		System.out.println(TMS.Sort(tm));		
		
	}

}
