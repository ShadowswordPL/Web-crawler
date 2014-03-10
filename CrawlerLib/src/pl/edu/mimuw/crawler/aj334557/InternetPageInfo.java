package pl.edu.mimuw.crawler.aj334557;

import java.net.URI;

public class InternetPageInfo extends PageInfo {
	
	/** This constructor make PageInfo object from url path
	 * 	@param fullHttpPath is full url path of page 
	 */
	
	public InternetPageInfo(String fullHttpPath){
		
		URI uri = null;
		try{
			uri = new URI(fullHttpPath);
			if (uri.getHost() == null){
				throw new Exception();
			}
		}
		catch(Exception e){
			System.out.println("Cannot parse " + fullHttpPath + " url");
			return;
		}
		
		domain = uri.getHost();
	    root = domain;
		
		if (domain.startsWith("www.")){
	    	domain = domain.substring(4);
	    }
		
	    path = uri.getPath();
	}
	
	@Override
	public FullPage makeFullPage() {
		return new InternetFullPage(this);
	}

	@Override
	public String toString() {
		return this.getDomain() + this.getPath();
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash*23 + domain.hashCode();
		hash = hash*7 + path.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object o) {
		return this.hashCode() == o.hashCode();
	}

}
