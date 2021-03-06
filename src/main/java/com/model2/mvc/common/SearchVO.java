package com.model2.mvc.common;


public class SearchVO {
	
	private int page;
	String searchCondition;
	String searchKeyword;
	int pageUnit;
	
	public SearchVO(){
	}
	
	public int getPageUnit() {
		return pageUnit;
	}
	
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}

	public String getSearchCondition() {
		return searchCondition;
	}
	
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	public String toString() {
		
		return  "\n -- SearchVO --"
		+"\n [page] : " + page
		+"\n [searchCondition] : " + searchCondition
		+"\n [searchKeyword] : " + searchKeyword
		+"\n [pageUnit] : " + pageUnit 
		+ "\n ----------------\n";
	}
}