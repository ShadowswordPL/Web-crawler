package pl.edu.mimuw.crawler.aj334557;

public class AlwaysTrueCondition implements Condition {

	/**
	 * 
	 * @return This method always return true
	 */
	
	@Override
	public boolean condition(PageInfo pi) {
		return true;
	}

}
