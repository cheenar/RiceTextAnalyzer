package com.cheenar.rice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ModuleAverageWordLength extends Module
{

	public ModuleAverageWordLength(Configuration c)
	{
		super(c, "Average Word Length");
	}

	@Override
	public Object[] analyze(String poemName, ArrayList<ArrayList<String>> array)
	{
		System.out.println();
		System.out.println("Attempting Analysis With: " + getName());
		System.out.println("Currently Analyzing: " + getConfig().getAuthorFromPoems(array));
		int averageWordLength = 0;
		int overAllPoem = 0;
		int overAllTexts = 0;
		for(ArrayList<String> poem : array)
		{
			overAllPoem = 0;
			for(String line : poem)
			{
				averageWordLength = 0;
				String words[] = line.split(" ");
				for(int i = 0; i < words.length; i++)
				{
					averageWordLength = averageWordLength + words[i].length();
				}
				averageWordLength = averageWordLength / words.length;
				overAllPoem += averageWordLength;
			}
			overAllPoem = overAllPoem / poem.size();
			overAllTexts+= overAllPoem;
		}
		overAllTexts = overAllTexts / array.size();
		System.out.println("Overall Average Word Length: " + overAllTexts);
		try
		{
			int aver = 0;
			int cont = 0;
			BufferedReader br = new BufferedReader(new FileReader(new File(poemName)));
			String ln = "";
			while((ln = br.readLine()) != null)
			{
				String words[] = ln.split(" ");
				int avg = 0;
				for(int i = 0; i < words.length; i++)
				{
					avg += words[i].length();
				}
				avg = avg/words.length;
				cont++;
				aver = avg + aver;
			}
			aver = aver / cont;
			if(aver == overAllTexts)
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
