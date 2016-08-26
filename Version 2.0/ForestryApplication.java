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
    
    private LandTile[][] landTiles;
    private ArrayList<ForestElement> elements;
    
    public void fillupPlot()
    {
    	for(int i = 0; i < LENGTH; i++)
    	{
    		for(int j = 0; j < WIDTH; j++)
    		{
    			if(landTiles[j][i] == null)
    				landTiles[j][i] = new LandTile(j,i);
    			pairUpLandTile(j,i);
    		}
    		
    		//printing
    		/*System.out.print("Row " + i + ": ");
    		for(int k = 0; k < elements.size(); k++)
        	{
        		System.out.print(elements.get(k).getSpecies() + " " + elements.get(k).getElementScore() + " | ");
        	}
        	System.out.println();
        	System.out.println();*/
        	
    		
    		for(int k = 0; k < elements.size(); k++)
    		{
    			elements.get(k).resetScore();
    		}
    	}
    }
    
    public int pairUpLandTile(int posX, int posY)
    {
    	if(landTiles[posX][posY].isTaken())
    		return 0;
    	else
    	{
    		//pair them up
    		/*if(posX < (LENGTH * 1 / 2))
    		{
    			//chose a tree that has a lower score (suited to be in the south)
    			for(int i = elements.size() - 1; i >= 0; i--)
    			{
    				if(plantElement(elements.get(i), posX, posY))
    				{
    		        	Collections.sort(elements, new ElementComparator());
    					return 0;
    				}
    			}
    		}
    		else
    		{
    			//choose a tree that has a higher score (suited to be in the north)
    			for(int i = 0; i < elements.size(); i++)
    			{
    				if(plantElement(elements.get(i), posX, posY))
    				{
    					elements.get(i).deductScore();
    		        	Collections.sort(elements, new ElementComparator());
    					return 0;
    				}
    			}
    		}*/
    		calculateScores(posX);
    		
    		for(int i = 0; i < elements.size(); i++)
			{
				if(plantElement(elements.get(i), posX, posY))
				{
					elements.get(i).decrementScore();
					return 0;
				}
			}
    		
    		
    	}
    	return 0;
    }
    
    public void calculateScores(int x)
    {
    	if(x < (LENGTH * 1/6))
    	{
    		for(int i = 0; i < elements.size(); i++)
    		{
    			switch(elements.get(i).getHeight())
    			{
    				case 1: elements.get(i).setScore(0);
    						break;
    				case 2: elements.get(i).setScore(30);
    						break;
    				case 3: elements.get(i).setScore(60);
							break;
    			}
    		}

        	Collections.sort(elements, new ElementComparator());
    	}
    	else if(x < (LENGTH * 2/6))
    	{
    		for(int i = 0; i < elements.size(); i++)
    		{
    			switch(elements.get(i).getHeight())
    			{
    				case 1: elements.get(i).setScore(0);
    						break;
    				case 2: elements.get(i).setScore(30);
    						break;
    				case 3: elements.get(i).setScore(32);
							break;
    			}
    		}

        	Collections.sort(elements, new ElementComparator());
    	}
    	else if(x < (LENGTH * 3/6))
    	{
    		for(int i = 0; i < elements.size(); i++)
    		{
    			switch(elements.get(i).getHeight())
    			{
    				case 1: elements.get(i).setScore(0);
    						break;
    				case 2: elements.get(i).setScore(60);
    						break;
    				case 3: elements.get(i).setScore(30);
							break;
    			}
    		}

        	Collections.sort(elements, new ElementComparator());
    	}
    	else if(x < (LENGTH * 4/6))
    	{
    		for(int i = 0; i < elements.size(); i++)
    		{
    			switch(elements.get(i).getHeight())
    			{
    				case 1: elements.get(i).setScore(28);
    						break;
    				case 2: elements.get(i).setScore(30);
    						break;
    				case 3: elements.get(i).setScore(0);
							break;
    			}
    		}

        	Collections.sort(elements, new ElementComparator());
    	}
    	else if(x < (LENGTH * 5/6))
    	{
    		for(int i = 0; i < elements.size(); i++)
    		{
    			switch(elements.get(i).getHeight())
    			{
    				case 1: elements.get(i).setScore(30);
    						break;
    				case 2: elements.get(i).setScore(30);
    						break;
    				case 3: elements.get(i).setScore(0);
							break;
    			}
    		}

        	Collections.sort(elements, new ElementComparator());
    	}
    	else
    	{
    		for(int i = 0; i < elements.size(); i++)
    		{
    			switch(elements.get(i).getHeight())
    			{
    				case 1: elements.get(i).setScore(60);
    						break;
    				case 2: elements.get(i).setScore(30);
    						break;
    				case 3: elements.get(i).setScore(0);
							break;
    			}
    		}

        	Collections.sort(elements, new ElementComparator());
    	}
    }
    
    public boolean plantElement(ForestElement element, int x, int y)
    {
    	for(int i = x + 1; i < x + element.getSpace(); i++)
    	{
    		if(i >= LENGTH || (landTiles[i][y] != null && landTiles[i][y].isTaken()))
    			return false;
    	}
    	
    	for(int j = y + element.getSpace() - 1; j > y; j--)
    	{
    		if(j >= WIDTH)
    		{
    			return false;
    		}
    	}
    	
    	if(y-1 >= 0 && landTiles[x][y-1] != null && landTiles[x][y-1].getCurrForestElement() != null && landTiles[x][y-1].getCurrForestElement().equals(element))
    		return false;
    	if(x-1 >= 0 && landTiles[x-1][y] != null && landTiles[x-1][y].getCurrForestElement() != null && landTiles[x-1][y].getCurrForestElement().equals(element))
    		return false;
    	
    	for(int i = x; i < x + element.getSpace(); i++)
    	{
    		for(int j = y; j < y + element.getSpace(); j++)
    		{
    			landTiles[i][j] = new LandTile(i, j);
    			landTiles[i][j].setCurrForestElement(element);
    		}
    	}
    	
    	return true;
    }
    
    public void addElement(String type, String i1, String i2, String i3, String i4)
    {
    	boolean shadeTolerant = false;
    	if(i4.equals("ShadeTolerant"))
    	{
    		shadeTolerant = true;
    	}
    	if(type.equals("Tree"))
    	{
    		ForestElement element = new Tree(i1, i2, i3, shadeTolerant);
        	elements.add(element);
    	}
    		
    }
    
    public void execute()
    {
    	landTiles = new LandTile[LENGTH][WIDTH];
    	elements = new ArrayList<ForestElement>();
    	
    	Scanner sc = new Scanner(System.in);
    	String input;
    	String[] inputs;
    	while((input = sc.nextLine()).length() > 0)
    	{
    		
    		inputs = input.split(",");
    		System.out.println(inputs.length);
    		addElement(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4]);
    		//sample inputs
    		//Tree,TF1,Tall Tree Sample1,TALL,SunDemanding
    		//Tree,ST1,Short Tree Sample1,SHORT,ShadeTolerant
    		//Tree,TF2,Tall Tree Sample2,TALL,SunDemanding
    		//Tree,ST2,Short Tree Sample2,SHORT,ShadeTolerant
    		  
    	}
    	
    	/*elements.add(new Tree("TF1", "Tall1", "TALL", false));
    	elements.add(new Tree("TF2", "Tall2", "TALL", false));
    	elements.add(new Tree("TF3", "Tall3", "TALL", false));
    	elements.add(new Tree("TF4", "Tall4", "TALL", false));
    	elements.add(new Tree("SF1", "Short1", "SHORT", false));
    	elements.add(new Tree("SF2", "Short2", "SHORT", false));
    	elements.add(new Tree("SF3", "Short3", "SHORT", false));
    	elements.add(new Tree("ST1", "Short4", "SHORT", true));
    	elements.add(new Tree("MF1", "Medium1", "MEDIUM", false));
    	elements.add(new Tree("MF2", "Medium1", "MEDIUM", false));
    	elements.add(new Tree("MF3", "Medium1", "MEDIUM", false));
    	elements.add(new Tree("MT1", "Medium1", "MEDIUM", true));
    	elements.add(new Tree("MT2", "Medium1", "MEDIUM", true));
    	elements.add(new Tree("MT3", "Medium1", "MEDIUM", true));*/
    	
    	
    	/*for(int i = 0; i < elements.size(); i++)
    	{
    		System.out.print(elements.get(i).getSpecies() + " ");
    	}
    	System.out.println();
    	System.out.println();*/
    	
    	fillupPlot();
    	
    	// -- final output -- //
    	String prev = "", print = "";
    	for(int i = 0; i < LENGTH; i++)
    	{
    		for(int j = 0; j < WIDTH; j++)
    		{
    			if(landTiles[i][j].getCurrForestElement() != null)
    				print = landTiles[i][j].getCurrForestElement().getLabel();
    			else
    				print = "###";
    			if(print.equals(prev) || j == 0)
        			{
        				System.out.print(" ");
        			}
        			else
        			{
        				System.out.print("|");
        			}
        			prev = print;
    			System.out.print(print);
    			
    		}
    		prev = "";
    		System.out.println("");
    	}
    	// ------------------ //
    }
    
    public class ElementComparator implements Comparator<ForestElement> {
	    @Override
	    public int compare(ForestElement a, ForestElement b) {
	    	if(a.getElementScore() < b.getElementScore())
	    	{
	    		return 1;
	    	}
	    	else if(a.getElementScore() > b.getElementScore())
	    	{
	    		return -1;
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
