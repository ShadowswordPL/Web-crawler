package pl.edu.mimuw.crawler.aj334557;

public interface Condition {
	/**
	 * 
	 * @param pi is PageInfo of page which will be tested
	 * @return Method returns true if pi is correct page for given condition
	 */
	public boolean condition(PageInfo pi);
}
