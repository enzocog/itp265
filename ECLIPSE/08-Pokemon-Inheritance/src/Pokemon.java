import java.util.Arrays;

/**
 * Brief Description Of Code: 
 * @author Enzo Coglitore
 * ITP 265, FALL 2020, Coffee Section
 * Assignment XX, Week ##
 * Email: ecoglito@usc.edu
 */
public class Pokemon extends Being {
	private Type[] types;
	private String[] abilities;
	private String nature;
	private int level;
	/**
	 * @param name
	 * @param healthPoints
	 * @param region
	 */
	public Pokemon(String name, int healthPoints, Region region, String ab1, String ab2, String ab3, String ab4, String nature) {
		super(name, healthPoints, region);
		// TODO Auto-generated constructor stub
		abilities = new String[] {ab1, ab2, ab3, ab4};
		this.nature = nature;
		this.level = 1;
	}
	/**
	 * @return the types
	 */
	public Type[] getTypes() {
		return types;
	}
	/**
	 * @param types the types to set
	 */
	public void setTypes(Type[] types) {
		this.types = types;
	}
	/**
	 * @return the abilities
	 */
	public String[] getAbilities() {
		return abilities;
	}
	/**
	 * @param abilities the abilities to set
	 */
	public void setAbilities(String[] abilities) {
		this.abilities = abilities;
	}
	/**
	 * @return the nature
	 */
	public String getNature() {
		return nature;
	}
	/**
	 * @param nature the nature to set
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Pokemon [types=" + Arrays.toString(types) + ", abilities=" + Arrays.toString(abilities) + ", nature="
				+ nature + ", level=" + level + "]";
	}
	
	

}
