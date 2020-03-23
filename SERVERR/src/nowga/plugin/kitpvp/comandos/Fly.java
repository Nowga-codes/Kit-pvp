package nowga.plugin.kitpvp.comandos;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MetodosWarps;

public class Fly implements CommandExecutor{

	public static ArrayList<Player> flyMode= new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("fly")) {
			Player p= (Player) sender;
			
			if(p.hasPermission(Permissions.FLY)) {
				
				Location spawn= new Location(p.getWorld(), MetodosWarps.getWarpXYZ("Spawn", "x"), MetodosWarps.getWarpXYZ("Spawn", "y"), MetodosWarps.getWarpXYZ("Spawn", "z"));

				if(p.getLocation().distance(spawn) >= 100){
					
					p.sendMessage("§cO fly não pode ser ativado nessa area!");
					return true;
				}
				
				if(flyMode.contains(p)) {
					p.sendMessage("§cFly desativado!");
					flyMode.remove(p);
					p.setAllowFlight(false);
				}else {
					p.sendMessage("§aFly ativado!");
					flyMode.add(p);
					p.setAllowFlight(true);
				
				}
				
				
			}else {
				p.sendMessage(Permissions.nopermission);
			}
			
		}
			
		return false;
	}
	
}
