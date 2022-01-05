package controller;

public class SearchController {

	private static SearchController instance = null;

	public static SearchController getInstance() {
		if (instance == null) {
			instance = new SearchController();
		}
		return instance;
	}
	
	private SearchController() {
		
	}
	
	public void searchStudent() {
		
	}
	
	public void searchProfessor() {
		
	}
	public void searchSubject() {
	
	}
}
