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
public class ShadeTolerantCrops implements ForestElement
{
	private String species;
    private int height;
    private int space;
    
    public ShadeTolerantCrops(String species, int height)
    {
    	this.species = species;
    	this.height = height;
    	this.space = height;
    	
    }

	public String getSpecies() {
		return species;
	}

	public int getHeight() {
		return height;
	}

	public int getSpace() {
		return space;
	}

}
