package com.gmail.mcmogaming.FileExplorerPlugin;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class FileExplorer extends JavaPlugin{

	static FileExplorer instance;
	
	public File f;
	
	@Override
	public void onEnable() {
		instance = this;
		
		f = new File(this.getDataFolder(), "file.txt");
		
		if(this.getDataFolder().exists()) {
			
		}else {
		this.getDataFolder().mkdirs();
		}
		
		
		this.getCommand("file").setExecutor(new FileExplorerCommand());
	}
	
	@Override
	public void onDisable() {

		
		
	}
	
	public static FileExplorer getInstance() {
		return instance;
	}
	
	
}
