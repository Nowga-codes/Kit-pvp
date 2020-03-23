package nowga.plugin.kitpvp.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Permissions;

public class Speed implements CommandExecutor{
	
	public static String prefix= "§e§lSPEED: ";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
        if(cmd.getName().equalsIgnoreCase("speed")) {
	  Player p= (Player)sender;
	  
	  if(p.hasPermission(Permissions.SPEED)) {
		  
		  if(args.length!= 1) {
			  p.sendMessage(prefix+"§cUse: /speed <velocidade>");
			  return true;
		  }
		 String velocidade= String.valueOf(args[0]);
		  
		  if(p.isFlying()) {
			  p.setFlySpeed(Float.valueOf(0+"."+velocidade));
			  p.sendMessage(prefix+"§7Sua velocidade voando foi alterada para §e" +velocidade+".");
		  }else {
			  p.setWalkSpeed(Float.valueOf(0+"."+velocidade));
			  p.sendMessage(prefix+"§7Sua velocidade andando foi alterada para §e" +velocidade+".");
		  }
	  }else {
		  p.sendMessage(Permissions.nopermission);
	  }
  }
		return false;
	}

}
