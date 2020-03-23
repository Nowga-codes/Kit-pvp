package nowga.plugin.kitpvp.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.Permissions;

public class Report implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("report")) {
			
			Player p=(Player)sender;
			
			if(args.length <=1) {
				p.sendMessage("§cUse: /report <player> <motivo>");
				return true;
			}
			
			
			String reportado= args[0];
			StringBuilder sb= new StringBuilder();
			
			for(int i= 1; i< args.length; i++) {
				
				sb.append(args[i]);
				sb.append(" ");
				
			}
			
			String motivo = sb.toString();
			
			p.sendMessage(" \n §aJogador foi reportado com sucesso!");
			p.sendMessage("§a§l* §7O uso indevido ou exagerado do /report pode resultar em punição! \n ");
							
			
			for(Player all: Bukkit.getOnlinePlayers()) {
				if(all.hasPermission(Permissions.REPORT)) {
					
					Manager.playSoundXp(all);
					
					all.sendMessage(" \n §a========§e§lREPORT§a========== \n "
							+ " §eReporter: §7"+p.getName()
							+ " \n  §eJogador reportado: §7"+reportado+
							" \n  §eMotivo:§7 "+motivo
							+ " \n §a========§e§lREPORT§a========== \n ");
					all.sendMessage("§a§l* §fPara uso mais eficiente do report não se esqueça de verificar se você esta no modo admin "
							+ "antes de se teleportar ao player em questão =) \n ");
					
				}
			}
			
		}
		return false;
	}
	
}
