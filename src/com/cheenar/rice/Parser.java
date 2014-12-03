package com.cheenar.rice;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 * @author Administrator
 * @description Parses Cheenar Script
 * @version 1.0
 *
 */

public class Parser 
{
	
	private String fileName;
	private Configuration configuration;
	private File file;
	
	public Parser(Configuration configuration, String fileName)
	{
		this.fileName = fileName;
		this.configuration = configuration;
		try
		{
			file = new File(fileName);
			if(!file.exists())
			{
				file.createNewFile();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Parser(Configuration configuration, File file)
	{
		this.fileName = file.getName();
		this.configuration = configuration;
		try
		{
			if(!file.exists())
			{
				file.createNewFile();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @name FactoryNames
	 * @description Will return a new parser from the input
	 */
	
	public Parser getParser(Configuration configuration, String fileName)
	{
		return new Parser(configuration, fileName);
	}
	
	public Parser getParser(Configuration configuration, File fileName)
	{
		return new Parser(configuration, fileName);
	}
	
	public void parse()
	{
		System.out.println("File Parsed: " + fileName);
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = "";
			while((currentLine = reader.readLine()) != null)
			{
				lines.add(currentLine);
			}
			reader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int i = 0; i < lines.size(); i++)
		{
			String s = lines.get(i);
			if(s.startsWith("Author:"))
			{
				ints.add(i);
			}
			if(s.startsWith("ANALYSIS_END"))
			{
				ints.add(i);
			}
		}
		int currentBlock = 0;
		for(int a = 0; a < ints.size() / 2; a++)
		{
			int nextBlock = currentBlock + 1;
			int line1 = ints.get(currentBlock);
			int line2 = ints.get(nextBlock);
			int lineNumber = line1 + 1;
			String authorName = lines.get(line1);
			ArrayList<String> books = new ArrayList<String>();
			for(int i = lineNumber+1; i < line2; i++)
			{
				books.add(lines.get(i));
			}
			String[] texts = new String[books.size()];
			for(int i = 0; i < books.size(); i++)
			{
				texts[i] = books.get(i).replace("\t", "");
			}
			configuration.loadAuthor(authorName, texts);
			currentBlock += 2;
		}
	}
	
	public void read()
	{
		for(String author : configuration.getAuthors().keySet())
		{
			String[] authorPoems = configuration.getAuthors().get(author);
			ArrayList<ArrayList<String>> poems = new ArrayList<ArrayList<String>>();
			for(String poemName : authorPoems)
			{
				ArrayList<String> lines = new ArrayList<String>();
				try
				{
					BufferedReader reader = new BufferedReader(new FileReader(new File(poemName)));
					String currentLine = "";
					while((currentLine = reader.readLine()) != null)
					{
						lines.add(currentLine);
					}
					reader.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				poems.add(lines);
			}
			configuration.getPoems().put(author, poems);
		}
	}
	
	public ArrayList<String> readPoem(String poemName)
	{
		ArrayList<String> lines = new ArrayList<String>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(new File(poemName)));
			String currentLine = "";
			while((currentLine = reader.readLine()) != null)
			{
				lines.add(currentLine);
			}
			reader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lines;
	}

}
