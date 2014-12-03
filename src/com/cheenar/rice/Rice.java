package com.cheenar.rice;

import java.util.Scanner;

public class Rice 
{

	private Configuration configuration;
	private Parser parser;
	private ModuleManager manager;
	
	public Rice()
	{
		this.configuration = new Configuration();
		this.manager = new ModuleManager();
		this.parser = new Parser(configuration, "configuration.chnr");
	}
	
	public static void main(String[] args)
	{
		System.out.println("Rice Text Analyzer");
		Rice rice = new Rice();
		rice.manager.addModule(new ModuleAverageWordLength(rice.configuration));
		rice.manager.addModule(new ModuleAverageLineLength(rice.configuration));
		rice.parser.parse();
		rice.parser.read();
		
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			String input = scanner.nextLine();
			
			if(input.equals("exit"))
			{
				break;
			}
			if(input.startsWith("analyze"))
			{
				String arg[] = input.split(" ");
				String poemName = arg[1];
				for(String key : rice.configuration.getPoems().keySet())
				{
					rice.manager.runModules(poemName, rice.configuration.getPoems().get(key));
				}
				/**System.out.println("Was It Right? ");
				String answer = scanner.nextLine();
				if(answer.equals("Y"))
				{
					//Nothing Happens
					//Computer Doesn't Care
					//Computer No Emotion if Right
				}
				else
				{
					//MACHINE LEARNING
					System.out.println("Enter Author Name: ");
					answer = scanner.nextLine();
					ArrayList<ArrayList<String>> poems = rice.configuration.getPoems().get("Author:" + answer);
					poems.add(rice.parser.readPoem(poemName));
					rice.configuration.getPoems().replace("Author:" + answer, poems);
				}**/ //REMOVED TO PREVENT MACHINE LEARNING
			}
		}
		scanner.close();
		System.exit(0);
	}
	
}
