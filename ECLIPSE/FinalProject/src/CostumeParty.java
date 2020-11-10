/**
	ITP 265 COFFEE FINAL PROJECT
	ECOGLITO@USC.EDU
	Enzo Coglitore, Coffee
	This Class Does: Makes the CostumeParty Class
 * 
 */


public class CostumeParty extends Party {
	private String costume;
	private Theme theme;
	public CostumeParty(String name, String location, String time, int people, String costume, Theme theme) {
		super(name, location, time, people);
		this.costume = costume;
		this.theme = theme;
	}
	/**
	 * @return the costume
	 */
	public String getCostume() {
		return costume;
	}
	/**
	 * @param costume the costume to set
	 */
	public void setCostume(String costume) {
		this.costume = costume;
	}
	/**
	 * @return the theme
	 */
	public Theme getTheme() {
		return theme;
	}
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	} 
	
	public String toString() {
		return "Costume Party: Name: " + getName() + " Location: " + getLocation() + " Time: " + getTime() + " People: " + getPeople() + "Theme: " + theme + " Costume: " + costume;
	}
	
	
	
}
