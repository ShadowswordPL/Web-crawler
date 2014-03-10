package pl.edu.mimuw.crawler.aj334557;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class FullPage {
	protected Document doc; /** all links from page content */
	
	/**
	 * 
	 * @return Method return all links located on this page
	 */
	public Elements getAllLinks(){
		if (doc != null){
			return doc.select("a[href]");
		}
		else{
			return null;
		}
	}
}
