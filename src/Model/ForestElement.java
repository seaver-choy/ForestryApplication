package Model;

import java.util.Comparator;

public abstract class ForestElement 
{
	public static int TALL = 90;
	public static int MEDIUM = 60;
	public static int SHORT = 30;
	
	protected String species;
    protected int height;
    protected int spaceOccupied;
    protected boolean shadeTolerant;
    protected int score;
    
    public ForestElement(String species, String height, boolean shadeTolerant)
    {
    	this.species = species;
    	this.shadeTolerant = shadeTolerant;
    	this.score = 0;
    	
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
    
    public void resetScore()
    {
    	this.score = 0;
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
			return (score + height + 28);
		}
		else
		{
			return (score + height);
		}
	}

	public void deductScore() {
		this.score--;
		
	}
}


