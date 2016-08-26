package Model;

import java.util.Comparator;

public abstract class ForestElement 
{
	public static int TALL = 4;
	public static int MEDIUM = 2;
	public static int SHORT = 1;
	
	protected String species;
    protected int height;
    protected int spaceOccupied;
    protected boolean shadeTolerant;
    
    public ForestElement(String species, String height, boolean shadeTolerant)
    {
    	this.species = species;
    	this.shadeTolerant = shadeTolerant;
    	
    	switch(height)
    	{
    		case "TALL": this.height = ForestElement.TALL;
    					 this.spaceOccupied = 3;
    					 break;
    		case "MEDIUM": this.height = ForestElement.MEDIUM;
						 this.spaceOccupied = 2;
						 break;
    		case "SHORT": this.height = ForestElement.SHORT;
						 this.spaceOccupied = 1;
						 break;
    	}
    	
    }
    
    public String getSpecies() {
		return species;
	}

	public int getHeight() {
		return height;
	}

	public int getSpace() {
		return spaceOccupied;
	}
	
	public int getElementScore()
	{
		if(shadeTolerant)
		{
			return height + 1;
		}
		else
		{
			return height;
		}
	}
}


