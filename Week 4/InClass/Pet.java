
/**
 * Pet Class describes attributes that we keep track of for each animal
 * This is based on ITP 115 Python Homework Assignment
 *
 * @author Kendra Walther
 * ITP 265
 * Email: kwalther@usc.edu
 * * In Class Activity, Week 3
 */
public class Pet {

	//Instance variables or attribues
    private int hunger;
    private int happiness;
    private int health;
    private int energy;
    private int age;
    private String name;
    private String species;

    public Pet(String name, String species, int age,
            int hunger, int happiness, int health, int energy) {
        this.hunger = hunger;
        this.happiness = happiness;
        this.health = health;
        this.energy = energy;
        this.age = age;
        this.name = name;
        this.species = species;
    }
    
    public Pet(String name, String species, int age) {
        this(name, species, age, 70, 70, 70, 70);
    }
    
    
    //TODO: make accessor and mutator for the name instance variables
    public String getPetName() {
    	return  this.name ;
    }
    
    public void setPetName(String name) {
    	this.name = name;
    }
    
    public void play() {
        if(this.happiness > 90) {
            this.happiness = 100;
        }
        else {
            this.happiness += 10;
        }
        if(this.hunger > 95) {
            this.hunger = 100;
        }
        else {
            this.hunger += 5;
        }
    }
    public void feed() {
        if(this.hunger < 10) {
            this.hunger= 0;
        }
        else
            this.hunger -= 10;
    }
    
    public void giveMedicine() {
        if(this.happiness < 20) {
            this.happiness = 0;
        }
        else {
            this.happiness -= 20;
        }
        if(this.health > 80) {
            this.health = 100;
        }
        else {
            this.health += 20;
        }
    }
    public void sleep() {
        if(this.energy > 80) {
            this.energy = 100;
        }
        else {
            this.energy += 20;
        }
    }
    
    public String getNameSpecies() {
    	return  name + " the " + species ;
    }
  
    public String toString() {
        return  getNameSpecies()
                + "\n\tHunger=" + hunger 
                + "\n\tHappiness=" + happiness 
                + "\n\tHealth=" + health 
                + "\n\tEnergy=" + energy
                + "\n\tage=" + age 
                + "\n*********************************";
    }
    
  
    /**
     * @return the species
     */
    public String getSpecies() {
        return species;
    }

	public boolean equals(Pet other) {
		return (age == other.age
				&& name.equals(other.name)
				&& species.equals(other.species));
			
	}
}
