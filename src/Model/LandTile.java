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
	
    private boolean taken = false;
    private ForestElement currForestElement;
    private Location location;
    private int xPos, yPos;
    
}
