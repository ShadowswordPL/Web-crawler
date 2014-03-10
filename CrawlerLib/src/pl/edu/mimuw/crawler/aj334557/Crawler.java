package pl.edu.mimuw.crawler.aj334557;

import java.net.URISyntaxException;
import java.util.Set;
import java.util.HashSet;

import org.jsoup.nodes.Element;

public class Crawler {
	
	private PageInfoQueue[] unvisited;
	private Set<PageInfo> visited;
	private PageInfoQueue toReturn;
	
	/**
	 * 
	 * This constructor is only to make public ones
	 */
	private Crawler(){
		visited = new HashSet<PageInfo>();
		unvisited = new PageInfoQueue[1];
		toReturn = new PageInfoQueue();
	}
	
	/**
	 * 
	 * This constructor make crawler with one page to start crawling
	 * @param p This parametr is PageInfo of page which will be added to crawler
	 */
	public Crawler(PageInfo p){
		this();
		unvisited[0] = new PageInfoQueue();
		unvisited[0].addCorrect(p); 
	}
	
	/**
	 * 
	 * This constructor make crawler with queue of page to start crawling
	 * @param q This parametr is queue of PageInfos which will be added to crawler
	 */
	
	public Crawler(PageInfoQueue q){
		this();
		unvisited[0] = q;
	}
	
	/**
	 * 
	 * This main method of crawler. It takes PageInfos of unvisited pages, takes URLs from
	 * this pages and add it to unvisited pages again!
	 * @param levels Level of depth in page crawling
	 * @param condition Condition fulfilled by pages which will by returned
	 * @return PageQueue of pages which are fulfilling condition
	 */
	public PageInfoQueue Crawl(int levels, Condition condition){
		PageInfoQueue[] unvisitedNew = new PageInfoQueue[levels + 1];
		unvisitedNew[0] = unvisited[0];
		for (int i = 1; i < levels + 1; i++){
			unvisitedNew[i] = new PageInfoQueue();
		}
		
		unvisited = unvisitedNew;
		while(!Done()){
			int currentLevel = 0;
			PageInfo pi = null;
			for(int i = 0; i < unvisited.length; i++){
				if(!unvisited[i].isEmpty()){
					currentLevel = i;
					pi = unvisited[i].poll();
					break;
				}
			}
			
			if(!visited.contains(pi) && (currentLevel != levels)){
				visited.add(pi);
				FullPage fp = pi.makeFullPage();
				if(fp.getAllLinks() != null){
					for (Element link1 : fp.getAllLinks()) {
						PageInfo linkPI = PageInfo.selectPageType(absUrl(link1, pi), pi);
						toReturn.addCorrect(linkPI);					
						if(!isAnywhere(linkPI)){
							if(condition.condition(linkPI)){
								unvisited[currentLevel+1].addCorrect(linkPI);
							}
						}
					}
				}
			}
		}
		return toReturn;
	}
	
	/**
	 * 
	 * It's easy-to-use version of Crawl method (without using conditions)
	 */
	public PageInfoQueue Crawl(int levels) throws URISyntaxException{
		return Crawl(levels, new AlwaysTrueCondition());
	}
	
	/**
	 * 
	 * @return Method return true if there is no unvisited site in unvisited queue
	 */
	
	private boolean Done(){
		boolean b = true;
		for (int i = 0; i < unvisited.length; i++){
			b = b && unvisited[i].isEmpty();
		}
		return b;
	}

	/**
	 *  
	 * @return Method checks if pi is in any unvisited queue
	 */
	private boolean isAnywhere(PageInfo pi){
		if(pi.isCorrect()){
			boolean b = visited.contains(pi);	
			for (int i = 0; i < unvisited.length; i++){
				b = b || unvisited[i].contains(pi);
			}
			return b;
		}
		return false;
	}
	
	/**
	 * 
	 * @param link Is href link found on pi page
	 * @param pi is PageInfo of page where is link
	 * @return full absolut URL adress of link (JSoup's abs:URL do not work with local files...)
	 */
	
	private String absUrl(Element link, PageInfo pi){
		if(link.attr("abs:href").equals("")){
			String links = link.attr("href"); 
			String roots = pi.getRoot() + PageInfo.getFolder(pi.getPath());
			while(links.substring(0, 3).equals("../")){
				links = links.substring(3, links.length());
				roots = PageInfo.getFolder(roots.substring(0, (roots.length()-1)));
			}
			return "file://" + roots + links;
		}
		return link.attr("abs:href");
	}
}
