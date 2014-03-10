package pl.edu.mimuw.crawler.aj334557;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;


public class HDDFullPage extends FullPage {

	/**
	 * Constructor for FullPage located on hard drive
	 * @param pi PageInfo of new FullPage
	 */
	public HDDFullPage(HDDPageInfo pi){
		File input = new File(pi.getRoot()+pi.getPath());
		doc = null;
		try {
			doc = Jsoup.parse(input, "UTF-8", pi.getDomain());
		} catch (IOException e) {
			System.out.println("Cannot open page from file " + pi.getRoot()+pi.getPath());
			return;
		}
	}
}
