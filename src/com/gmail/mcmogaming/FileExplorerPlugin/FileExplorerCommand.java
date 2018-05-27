package com.gmail.mcmogaming.FileExplorerPlugin;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class FileExplorerCommand implements CommandExecutor{
	
	FileExplorer plugin = FileExplorer.getInstance();
	File f = plugin.f;
	
	/*public static void dir(File fn, Player p) {
		File nm = new File(fn.getAbsolutePath() + File.separator + ".." + File.separator);
		p.sendMessage(nm.getAbsolutePath());	
	}
	*/
	
	public static String oneUp(String f) {
		for(int i = f.length(); i >= 1; i--) {
			if(f.substring(i-1, i).equals("/") || f.substring(i-1, i).equals("\\")) {
				f = f.substring(0, i);
				break;
			}
		}
		return f;
	}

	public static String oneDown(String path, String folder) {
		return path.concat(folder);
	}
	
	public static void listfiles(File file, Player p) {
		String[] fileList = file.list();
		
		for(String name:fileList) {
			p.sendMessage(ChatColor.RED + name);
		}
		
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		

		int menu;
		
		if(sender instanceof Player) {
			
			
			
		Player player = (Player)sender;
		player.sendMessage("==================== File Explorer ====================");
			
		if(args[0].equals("") || args[0].equals(null)) {
			player.sendMessage("To use this command /file number || 1:path 2:up 3:down /name 4:List");
		}else {
			menu = Integer.parseInt(args[0]);
			
			switch(menu) {
			case 1:
				player.sendMessage(ChatColor.GREEN + f.getAbsolutePath());
				break;
			case 2:
				f = new File(oneUp(f.getAbsolutePath()));
				break;
			case 3:
				String filename = args[1];
				if(args[1].equals(null) || args[1].equals("")) {
				player.sendMessage("Please enter the file name with \\ or / infront of it.");
				}else {
				f = new File(oneDown(f.getAbsolutePath(),filename));
				player.sendMessage(f.getAbsolutePath());
				}
				break;
			case 4:
				listfiles(f,player);
				break;
			default:
				player.sendMessage("To use this command /file number || 1:path 2:up 3:down /name 4:List");
				break;
			}
	
		}
		
		
			
			
		plugin.f = f;
	}
		return true;
	
	
	}
	
}
