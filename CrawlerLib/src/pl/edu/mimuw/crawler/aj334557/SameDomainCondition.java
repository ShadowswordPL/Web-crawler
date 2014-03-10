package pl.edu.mimuw.crawler.aj334557;

public class SameDomainCondition implements Condition {

	String domain;
	
	/**
	 * 
	 * @param domain is local domain given by String
	 */
	public SameDomainCondition(String domain){
		this.domain = domain;
	}
	
	/**
	 * 
	 * @return true if page from pi is located inside this.domain domain
	 */
	@Override
	public boolean condition(PageInfo pi) {
		return domain.equals(pi.getDomain());
	}

}
