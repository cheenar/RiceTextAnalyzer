package com.cheenar.rice;

import java.util.ArrayList;

public class ModuleManager 
{

	private ArrayList<Module> modules;
	
	public ModuleManager()
	{
		this.modules = new ArrayList<Module>();
	}
	
	public void addModule(Module m)
	{
		modules.add(m);
	}
	
	public void removeModule(Module m)
	{
		modules.remove(m);
	}
	
	public Module getModule(int index)
	{
		return modules.get(index);
	}
	
	public void runModules(String poemName, ArrayList<ArrayList<String>> array)
	{
		for(Module m : modules)
		{
			m.analyze(poemName, array);
		}
	}
	
}
