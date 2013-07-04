package com.justinmaslin.SendCoords;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SendMain extends JavaPlugin
{

	public void onEnable()
	{
		getLogger().info("[SendCoords] Plugin Enabled!");
		getLogger().info("Created for Merecraft! (www.merecraft.com)");
	}

	public void onDisable()
	{
		getLogger().info("[SendCoords] Plugin Disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player target = (Bukkit.getServer().getPlayer(args[0]));

		Location pos = ((Player) sender).getLocation();

		int xPos = pos.getBlockX();
		int yPos = pos.getBlockY();
		int zPos = pos.getBlockZ();

		if (cmd.getName().equalsIgnoreCase("sendcoords") && sender.hasPermission("sendcoords.use"))
		{
			if (!(sender instanceof Player))
				sender.sendMessage("You must run this command in-game!");

			//if (args.length != 2)
			//	sender.sendMessage("§b[SendCoords] §eThe correct syntax is: §c/sendcoords <name>");
			
			//else
			{
				sender.sendMessage("§b[SendCoords] §eCoordinates sent to "+target.getName()+".");
				target.sendMessage("§b[SendCoords] §e"+sender.getName()+" is at: "+xPos+", "+yPos+", "+zPos+".");
			}

			return true;
		}

		return false;
	}


}