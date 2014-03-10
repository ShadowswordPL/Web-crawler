package pl.edu.mimuw.crawler.aj334557;

import org.jsoup.Jsoup;

public class InternetFullPage extends FullPage {

	/**
	 * Constructor download page from internet and make FullPage object
	 * @param pi PageInfo of new FullPage
	 */
	public InternetFullPage(InternetPageInfo pi){
		doc = null;
		try {
			doc = Jsoup.connect("http://" + pi.getDomain()+pi.getPath()).get();
		} 
		catch (Exception e) {
			System.out.println("Cannot connect to http://" + pi.getDomain( ) + pi.getPath());
			return;
		}
	}	
}
