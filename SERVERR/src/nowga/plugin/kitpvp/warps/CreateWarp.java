package nowga.plugin.kitpvp.warps;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MetodosWarps;

public class CreateWarp implements CommandExecutor{

	public static String prefix= "§5§lWARP: ";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("setwarp")) {
			
			Player p= (Player)sender;
			if(args.length !=1) {
			  	p.sendMessage(prefix+"§cUse /setwarp <warp>.");
				return true;
			}
			if(args.length == 1) {
				String warpName= args[0];
				
				
				if(p.hasPermission(Permissions.WARP)) {
		        Location loc = p.getLocation();
		    	p.sendMessage(prefix+"§7Warp §5"+ warpName+ " §7foi setada com sucesso!");
		        
		        double x = loc.getX();
		        double y = loc.getY();
		        double z = loc.getZ();
		        float yaw = loc.getYaw();
		        float pitch = loc.getPitch();
				
		        if(MetodosWarps.containsWarp(warpName)) {
                  MetodosWarps.deleteWarp(warpName);
                  MetodosWarps.setWarp(warpName, x, y, z, yaw, pitch);
		        return true;
		        }
				MetodosWarps.setWarp(warpName, x, y, z, yaw, pitch);
			}else {
				p.sendMessage(Permissions.nopermission);
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("warp")) {
			
			
			Player p= (Player)sender;
			if(args.length !=1) {
			  	p.sendMessage(prefix+"§cUse /warp <warp>.");
				return true;
			}
			if(args.length == 1) {
				String warpName= args[0];
				
				if(p.hasPermission(Permissions.WARPTELEPORT)) {
					if(MetodosWarps.containsWarp(warpName)) {
				MetodosWarps.teleportWarpName(p, warpName);
				p.sendMessage(prefix+"§7Você foi teleportado para warp §5"+warpName);
					}else {
						p.sendMessage(prefix+"§cEssa warp não existe!");
					}
				}else {
					p.sendMessage(Permissions.nopermission);
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("warps")) {
			
			Player p= (Player)sender;
			if(p.hasPermission(Permissions.WARPTELEPORT)) {
			p.sendMessage(" \n      §5§lWARPS: \n ");
			MetodosWarps.getWarps(p);
			}else {
				p.sendMessage(Permissions.nopermission);
			
			}
		}
       if(cmd.getName().equalsIgnoreCase("delwarp")) {
			
			Player p= (Player)sender;
			if(p.hasPermission(Permissions.WARP)) {
		
               if(args.length!= 1) {
					p.sendMessage(prefix+"§cUse /delwarp <warp>");
            	   return true;
				}
				
				if(args.length== 1) {
					String warpName= args[0];
					if(MetodosWarps.containsWarp(warpName)) {
					 p.sendMessage(CreateWarp.prefix+"§7Warp §5"+warpName+" §7foi deletada com sucesso.");
					 MetodosWarps.deleteWarp(warpName);
					}else {
						 p.sendMessage(CreateWarp.prefix+"§cEssa warp não existe.");
					}
					}
				
			}else {
				p.sendMessage(Permissions.nopermission);
			
			}
		}
		return false;
	}
	
}
