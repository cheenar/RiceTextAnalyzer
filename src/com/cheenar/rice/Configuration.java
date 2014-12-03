package com.cheenar.rice;

import java.util.ArrayList;
import java.util.HashMap;

public class Configuration 
{

	private HashMap<String, String[]> authors; //AuthorName:ListOfTheirPoems
	private HashMap<String, ArrayList<ArrayList<String>>> authorsPoems; //AuthorName:PoemsTextInLines
	
	public Configuration()
	{
		this.authors = new HashMap<String, String[]>();
		this.authorsPoems = new HashMap<String, ArrayList<ArrayList<String>>>();
	}

	public HashMap<String, String[]> getAuthors()
	{
		return authors;
	}
	
	public HashMap<String, ArrayList<ArrayList<String>>> getPoems()
	{
		return authorsPoems;
	}
	
	public void loadAuthor(String author, String[] texts)
	{
		getAuthors().put(author,  texts);
	}
	
	public String getAuthorFromPoems(ArrayList<ArrayList<String>> array)
	{
		for(String key : authorsPoems.keySet())
		{
			if(authorsPoems.get(key).equals(array))
			{
				return key;
			}
		}
		return "N/A";
	}
	
}
