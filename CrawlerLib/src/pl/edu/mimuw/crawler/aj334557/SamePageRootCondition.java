package pl.edu.mimuw.crawler.aj334557;

public class SamePageRootCondition implements Condition {

	String root;
	
	/**
	 * 
	 * @param root is adress of root directory
	 */
	public SamePageRootCondition(String root){
		this.root = root;
	}
	
	/**
	 * Method return true if given PageIfo hava same root
	 * directory as this condition
	 */
	@Override
	public boolean condition(PageInfo pi) {
		return root.equals(pi.getRoot());
	}
}
