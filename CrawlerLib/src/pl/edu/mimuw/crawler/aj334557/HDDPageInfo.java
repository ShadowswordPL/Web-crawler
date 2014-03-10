package pl.edu.mimuw.crawler.aj334557;

public class HDDPageInfo extends PageInfo {
		
	/**
	 * Shorter version of constructor, makes PageInfo of local
	 * page from local path, so return domain adress as "unknown" 
	 * @param url is string with url adress of local page
	 */
	
	public HDDPageInfo(String url){
		this.domain = "unknown";
		this.root = getFolder(url);
		this.path = url.substring(root.length(), url.length());
	}
	
	/** This constructor make PageInfo object from url path
	 * 	of page and it's real domain
	 * 	@param domain is real domain name
	 * 	@param HDDRoot is location of page root directory on HDD
	 *  @param HDDPath is location of page on HDD
	 */
	
	public HDDPageInfo(String domain, String HDDRoot, String HDDPath){
		
		this.domain = domain;
		this.path = HDDPath;
		this.root = HDDRoot;
	}
	
	@Override
	public FullPage makeFullPage() {
		return new HDDFullPage(this);
	}

	@Override
	public String toString() {
		return "file://" + this.getRoot()+this.getPath();
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash*31 + domain.hashCode();
		hash = hash*11 + path.hashCode();
		hash = hash*3 + root.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object o) {
		return this.hashCode() == o.hashCode();
	}
}
