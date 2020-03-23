package nowga.plugin.kitpvp.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.conexao.MetodosWarps;
import nowga.plugin.kitpvp.kits.KITAPI;
import nowga.plugin.kitpvp.warps.WarpAPI;

public class Spawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			
			Player p= (Player)sender;
			
			if(MetodosWarps.containsWarp("spawn")){
				MetodosWarps.teleportWarpName(p, "spawn");
				
				if(p.hasPotionEffect(PotionEffectType.JUMP)) {
				p.removePotionEffect(PotionEffectType.JUMP);
				}
				Manager.HOTBARLOBBY(p);
				WarpAPI.removeWarps(p);
				KITAPI.removeArena(p);
				KITAPI.removeKit(p);
			}else {
				p.sendMessage("§cO spawn não foi setado!");
			}
			
		}
		return false;
	}
	
}
