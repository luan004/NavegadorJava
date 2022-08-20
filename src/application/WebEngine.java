package application;

import javafx.scene.web.WebView;

public class WebEngine {
	
	private WebView browser = new WebView();
	
	public void createNewTab() {
    	browser.getEngine().load(this.getClass().getResource("/resources/novaguia.html").toString());
	}

	public WebView getBrowser() {
		return browser;
	}

	public void setBrowser(WebView browser) {
		this.browser = browser;
	}
}
