
/**
 * Write a description of class Cupcake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cupcake
{
    // instance variables - replace the example below with your own
    private Cake cakeType; //enum of caketype
    private Frosting frostingType; // enum
    private boolean hasSprinkles;
    
    public static final String CUPCAKE_ICON = "🧁";





	public Cupcake(Cake cakeType, Frosting frostingType, boolean hasSprinkles) {
		this.cakeType = cakeType;
		this.frostingType = frostingType;
		this.hasSprinkles = hasSprinkles;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cakeType == null) ? 0 : cakeType.hashCode());
		result = prime * result + ((frostingType == null) ? 0 : frostingType.hashCode());
		result = prime * result + (hasSprinkles ? 1231 : 1237);
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupcake other = (Cupcake) obj;
		if (cakeType != other.cakeType)
			return false;
		if (frostingType != other.frostingType)
			return false;
		if (hasSprinkles != other.hasSprinkles)
			return false;
		return true;
	}




	/**
	 * @return the cakeType
	 */
	public Cake getCakeType() {
		return cakeType;
	}




	/**
	 * @param cakeType the cakeType to set
	 */
	public void setCakeType(Cake cakeType) {
		this.cakeType = cakeType;
	}




	/**
	 * @return the frostingType
	 */
	public Frosting getFrostingType() {
		return frostingType;
	}




	/**
	 * @param frostingType the frostingType to set
	 */
	public void setFrostingType(Frosting frostingType) {
		this.frostingType = frostingType;
	}




	/**
	 * @return the hasSprinkles
	 */
	public boolean isHasSprinkles() {
		return hasSprinkles;
	}




	/**
	 * @param hasSprinkles the hasSprinkles to set
	 */
	public void setHasSprinkles(boolean hasSprinkles) {
		this.hasSprinkles = hasSprinkles;
	}




	public String toString(){
     String s =  cakeType + " cupcake " + "with " + frostingType + " frosting";
     if(hasSprinkles){
         s += " and sprinkles";
        }
         return s;
    }
}
