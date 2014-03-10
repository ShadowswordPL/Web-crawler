package pl.edu.mimuw.crawler.aj334557;

public class ExternalDomainCondition implements Condition {
	
	String domain;
	
	/**
	 * 
	 * @param domain is local domain given by String
	 */
	public ExternalDomainCondition(String domain){
		this.domain = domain;
	}
	
	/**
	 * 
	 * @return true if page from pi is located outside this.domain domain
	 */
	
	@Override
	public boolean condition(PageInfo pi) {
		return !domain.equals(pi.getDomain());
	}

}
