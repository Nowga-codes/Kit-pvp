package nowga.plugin.kitpvp.comandos;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiDivulgacao {

	public static void msg(AsyncPlayerChatEvent e) {
		Player p= e.getPlayer();
	
		if(e.getMessage().contains(".net")||e.getMessage().contains(".com")||e.getMessage().contains(".br")||e.getMessage().contains(".host")
	||e.getMessage().contains("-net")||e.getMessage().contains("-mc")||e.getMessage().contains("-mc")||e.getMessage().contains("mc.")
	||e.getMessage().contains(".tk")||e.getMessage().contains(".it")|| e.getMessage().contains(".ml")||e.getMessage().contains(".ga")
	||e.getMessage().contains(".cf")||e.getMessage().contains(".gq")|| e.getMessage().contains(".biz")|| e.getMessage().contains(".net")
	||e.getMessage().contains("play.")||e.getMessage().contains(".play")||e.getMessage().contains(".pvp")||e.getMessage().contains(".us")
	|| e.getMessage().contains("%")) {
			
			p.sendMessage("§cVocê não pode usar esses caractéres.");
			e.setCancelled(true);
			return;
			
		}
		
	}
	
}
