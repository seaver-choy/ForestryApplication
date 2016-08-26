/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Seaver
 */
public class LandTile 
{
	public static int NORTH = 1;
	public static int SOUTH = 0;
	
    private boolean taken;
    private ForestElement currForestElement;
    private int xPos, yPos;
    
    public LandTile(int xPos, int yPos)
    {
    	currForestElement = null;
    	taken = false;
    	this.xPos = xPos;
    	this.yPos = yPos;
    }

	public boolean isTaken() {
		return taken;
	}

	public ForestElement getCurrForestElement() {
		return currForestElement;
	}
	
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setCurrForestElement(ForestElement currForestElement) 
	{
		this.currForestElement = currForestElement;
		this.taken = true;
	}
    
    
    
}
