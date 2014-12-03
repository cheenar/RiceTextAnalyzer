package com.cheenar.rice;

import java.util.ArrayList;

public abstract class Module 
{

	private String name;
	private Configuration configuration;
	
	public Module(Configuration c, String name)
	{
		this.configuration = c;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Configuration getConfig()
	{
		return this.configuration;
	}
	
	public abstract Object[] analyze(String poemName, ArrayList<ArrayList<String>> array);
	
}
