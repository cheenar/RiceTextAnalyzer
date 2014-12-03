package com.cheenar.rice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ModuleAverageLineLength extends Module
{

	public ModuleAverageLineLength(Configuration c) 
	{
		super(c, "Average Line Length");
	}

	@Override
	public Object[] analyze(String poemName, ArrayList<ArrayList<String>> array)
	{
		System.out.println();
		System.out.println("Attempting Analysis With: " + getName());
		System.out.println("Currently Analyzing: " + getConfig().getAuthorFromPoems(array));
		int averageLineLength = 0;
		for(ArrayList<String> poem : array)
		{
			int average = 0;
			for(String s : poem)
			{
				average += s.split(" ").length;
			}
			average = average / poem.size();
			averageLineLength += average;
		}
		averageLineLength = averageLineLength / array.size();
		System.out.println("Overall Average Line Length: " + averageLineLength);
		try
		{
			int aver = 0;
			int cont = 0;
			BufferedReader br = new BufferedReader(new FileReader(new File(poemName)));
			String ln = "";
			while((ln = br.readLine()) != null)
			{
				cont++;
				aver += ln.split(" ").length;
			}
			aver = aver / cont;
			if(aver == averageLineLength || aver-1 == averageLineLength)
			{
				System.out.println("Match Found, " + getConfig().getAuthorFromPoems(array) + " Wrote: " + poemName);
			}
			br.close();
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

}
