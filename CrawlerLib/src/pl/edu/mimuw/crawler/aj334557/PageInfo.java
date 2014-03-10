package pl.edu.mimuw.crawler.aj334557;


public abstract class PageInfo {

	protected String domain; /** Name of domain */
	protected String path; /** Page path from page root directory */	
	protected String root; /** Location of page root directory, 
	  					  *	 important if it isn't domain */
	
	/** Standard geter of domain argument */
	public String getDomain(){
		return domain;
	}
	
	/** Standard geter of path argument */
	public String getPath(){
		return path;
	}
	
	/** Standard geter of domain argument */
	public String getRoot(){
		return root;
	}
	
	static public PageInfo selectPageType(String s, PageInfo father){
		if (s.substring(0, 4).equals("file")){
			s = s.substring(7, s.length());
			String sRoot = "";
			if(father.getRoot().length() < s.length()){
				sRoot = s.substring(0, father.getRoot().length());
			}
			String sDomain = father.getDomain();
			
			if(!sRoot.equals(father.getRoot())){
				if(sRoot.length() > 0){
					sRoot = getFolder(sRoot).substring(0, (getFolder(sRoot).length()-1));
				}	
				sDomain = "unknow";
			}
			
			String sPath = s.substring(sRoot.length(), s.length());
			return new HDDPageInfo(sDomain, sRoot, sPath);
		}
		else{
			return new InternetPageInfo(s);
		}
		
	}
	
	static public String getFolder(String s){
		while((s.length() > 0) && (s.charAt(s.length()-1) != '/')){
			s = s.substring(0, (s.length()-1));
		}
		return s;
	}
	
	/**
	 * 
	 * @return FullPage contructed from held informations
	 */
	public abstract FullPage makeFullPage();
	
	/**
	 * 
	 * @return url adress of page
	 */
	@Override
	public abstract String toString();
	
	/**
	 * 
	 * @return correct hashCode
	 */
	@Override
	public abstract int hashCode();
	
	/**
	 * 
	 * @return correct equals result
	 */
	@Override
	public abstract boolean equals(Object o);
	
	/**
	 * 
	 * @return true if PageInfo contains correct data
	 */
	public boolean isCorrect(){
		String s = getDomain() + getPath() + getRoot();
		if(!s.contains("#") && !s.contains("@") && !s.contains("(")){
			return (getDomain() != null) && (getPath() != null) && (getRoot() != null);
		}
		return false;
	}
	
}
