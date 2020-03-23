package nowga.plugin.kitpvp.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

import nowga.plugin.kitpvp.scoreTab.PlacarScore;

public class Score implements CommandExecutor{

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
           if(!(sender instanceof Player))return true;
           if(cmd.getName().equalsIgnoreCase("score")) {
        	   Player p= (Player)sender;
        	   
        	   if(PlacarScore.score.contains(p)) {
        		   p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).unregister();
        		   PlacarScore.score.remove(p);
        		   p.sendMessage("§cScore desativada!");
        	   }else {
        		   PlacarScore.build(p);
        		   p.sendMessage("§aScore ativada!");
        	   }
        	   
           }
		return false;
	}
	
}
