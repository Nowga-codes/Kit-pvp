package nowga.plugin.kitpvp.punir;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import nowga.plugin.kitpvp.conexao.MotodosPunir;

public class BanEvent extends BanAPI{

	public void onJoin(PlayerJoinEvent e) {
		Player p= e.getPlayer();
		
		if(MotodosPunir.hasBanned(p.getUniqueId().toString())) {
			msgBanned(p);
		}
	}
	
}
