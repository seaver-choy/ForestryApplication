package Model;

import java.util.Comparator;

public abstract class ForestElement 
{
	public static int TALL = 3;
	public static int MEDIUM = 2;
	public static int SHORT = 1;
	
	protected String species;
	protected String label;
    protected int height;
    protected int spaceOccupied;
    protected boolean shadeTolerant;
    protected int score;
    protected int decrement;
    
    public ForestElement(String label, String species, String height, boolean shadeTolerant)
    {
    	this.species = species;
    	this.label = label;
    	this.shadeTolerant = shadeTolerant;
    	this.score = 0;
    	this.decrement = 0;
    	
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
    
    public String getLabel()
    {
    	return this.label;
    }
    
    public void resetScore()
    {
    	this.score = 0;
    	this.decrement = 0;
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
			return (decrement + score + 1);
		}
		else
		{
			return (decrement + score);
		}
	}
	
	public void setScore(int newScore)
	{
		this.score = newScore;
	}
	
	public void decrementScore()
	{
		this.decrement--;
	}
	
}


