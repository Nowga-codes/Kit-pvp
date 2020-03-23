package nowga.plugin.kitpvp.tag;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

import nowga.plugin.kitpvp.Permissions;

public class TagCommand extends Tags implements CommandExecutor{
	public static int i = 0;
	public String prefix= "§3§lTAGS:";
	public static HashMap<String, String> tags= new HashMap<String, String>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("tag")) {
			Player p= (Player) sender;
			
			if(args.length == 0) {
				p.sendMessage(prefix+" §7Use /tag <nome>");
				return true;
			}
			if(args.length == 1) {
				
				if(!(args[0].equalsIgnoreCase("membro")||args[0].equalsIgnoreCase("pro")||args[0].equalsIgnoreCase("yt")||args[0].equalsIgnoreCase("ytplus")
						||args[0].equalsIgnoreCase("beta")||args[0].equalsIgnoreCase("light")||args[0].equalsIgnoreCase("alpha") ||args[0].equalsIgnoreCase("helper")
						||args[0].equalsIgnoreCase("builder")||args[0].equalsIgnoreCase("trial")||args[0].equalsIgnoreCase("mod")||args[0].equalsIgnoreCase("modgc")
						||args[0].equalsIgnoreCase("admin")||args[0].equalsIgnoreCase("dono"))) {
					p.sendMessage(prefix+" §cEssa tag não existe!");		
					return true;
						}
	
				if(args[0].toUpperCase().equals("MEMBRO")) {
					p.sendMessage(prefix+ " §7Tag §7§lMEMBRO §7setada com sucesso!");
					tags.put(p.getName(), "MEMBRO");
					return true;
				}

				
				
				
				if(args[0].equalsIgnoreCase("pro")||args[0].equalsIgnoreCase("yt")||args[0].equalsIgnoreCase("ytplus")
						||args[0].equalsIgnoreCase("beta")||args[0].equalsIgnoreCase("light")||args[0].equalsIgnoreCase("alpha") ||args[0].equalsIgnoreCase("helper")
						||args[0].equalsIgnoreCase("builder")||args[0].equalsIgnoreCase("trial")||args[0].equalsIgnoreCase("mod")||args[0].equalsIgnoreCase("modgc")
						||args[0].equalsIgnoreCase("admin")||args[0].equalsIgnoreCase("dono")) {
					
					Team gettag = p.getScoreboard().getTeam(args[0].toUpperCase());
					
					
					if(!(p.hasPermission("thundermc.tag."+args[0].toLowerCase()))) {
						
						
						
						p.sendMessage(Permissions.nopermission);
						return true;
						
					}else {
						
							p.sendMessage(prefix+ " §7Tag "+gettag.getPrefix()+"§7setada com sucesso!");
							tags.put(p.getName(), args[0].toUpperCase());
						
					}
					
					

				}
			
				
			}
				
			}
		if(cmd.getName().equalsIgnoreCase("tags")) {
			Player p= (Player) sender;
			p.sendMessage(" \n          §3§lSUAS " +prefix );
			if(p.hasPermission(Permissions.ADMIN)) p.sendMessage(Tags.DONO);
			
			if(p.hasPermission(Permissions.ADMIN)) p.sendMessage(Tags.ADMIN);
			if(p.hasPermission(Permissions.MODGC)) p.sendMessage("§2§lMODGC §2");
			if(p.hasPermission(Permissions.MOD)) p.sendMessage(Tags.MOD);			
if(p.hasPermission(Permissions.TRIAL)) p.sendMessage(Tags.TRIAL);
if(p.hasPermission(Permissions.BUILDER)) p.sendMessage(Tags.BUILDER);
if(p.hasPermission(Permissions.HELPER)) p.sendMessage(Tags.HELPER);
if(p.hasPermission(Permissions.ALPHA)) p.sendMessage(Tags.ALPHA);
if(p.hasPermission(Permissions.LIGHT)) p.sendMessage(Tags.LIGHT);
if(p.hasPermission(Permissions.BETA)) p.sendMessage(Tags.BETA);
if(p.hasPermission(Permissions.YTPLUS)) p.sendMessage("§b§lYTPLUS §b");
if(p.hasPermission(Permissions.YT)) p.sendMessage(Tags.YT);
if(p.hasPermission(Permissions.PRO)) p.sendMessage(Tags.PRO);
if(p.hasPermission(Permissions.MEMBRO)) p.sendMessage("§7§lMEMBRO");
		

		}
		return false;
	}
	
}
