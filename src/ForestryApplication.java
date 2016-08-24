import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Model.ForestElement;
import Model.LandTile;
import Model.Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Seaver
 */
public class ForestryApplication 
{
	private int LENGTH = 50;
    private int WIDTH = 50;
    
    private LandTile[][] landTiles = new LandTile[LENGTH][WIDTH];
    private ArrayList<ForestElement> elements = new ArrayList<ForestElement>();
    
    public void fillupPlot()
    {
    	for(int i = 0; i < LENGTH; i++)
    	{
    		for(int j = 0; j < WIDTH; i++)
    		{
    			pairUpLandTile(i,j);
    		}
    	}
    }
    
    public void pairUpLandTile(int posX, int posY)
    {
    	if(landTiles[posX][posY].isTaken())
    		return;
    	else
    	{
    		//pair them up
    		if(posY >= 25)
    		{
    			//chose a tree that has a lower score (suited to be in the south)
    			
    		}
    		else
    		{
    			//choose a tree that has a higher score (suited to be in the north)
    			
    		}
    	}
    }
    
    public void addElement(String type, String i1, String i2, String i3)
    {
    	boolean shadeTolerant = false;
    	if(i3.equals("ShadeTolerant"))
    	{
    		shadeTolerant = true;
    	}
    	if(type.equals("Tree"))
    	{
    		ForestElement element = new Tree(i1, i2, shadeTolerant);
        	elements.add(element);
    	}
    		
    }
    
    public void execute()
    {
    	Scanner sc = new Scanner(System.in);
    	String input;
    	String[] inputs;
    	while(sc.hasNextLine())
    	{
    		input = sc.nextLine();
    		inputs = input.split(",");
    		addElement(inputs[0], inputs[1], inputs[2], inputs[3]);
    	}
    	
    	//sort the trees in the list
    	Collections.sort(elements, new ElementComparator());
    	
    	fillupPlot();
    }
    
    public class ElementComparator implements Comparator<ForestElement> {
	    @Override
	    public int compare(ForestElement a, ForestElement b) {
	    	if(a.getElementScore() < b.getElementScore())
	    	{
	    		return -1;
	    	}
	    	else if(a.getElementScore() > b.getElementScore())
	    	{
	    		return 1;
	    	}
	    	else
	    	{
	    		return 0;
	    	}
	    }
	}
    
    public static void main(String[] args) 
    {
    	new ForestryApplication().execute();
    }
    
}
