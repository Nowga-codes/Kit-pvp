package nowga.plugin.kitpvp.punir;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.conexao.MotodosPunir;

public class EventPunir extends BanAPI implements Listener{

	//ANTIFORCE-OP
	
	@EventHandler
	public void joinBanned(PlayerJoinEvent e) {
		Player p= e.getPlayer();
	
	if(MotodosPunir.hasBanned(p.getUniqueId().toString())|| MotodosPunir.hasBannedIP(p.getAddress().getHostString())) {
			if(MotodosPunir.hasBanned(p.getUniqueId().toString())) {
				e.setJoinMessage(null);
				 new BukkitRunnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							msgBanned(p);
							
							p.setPlayerListName(null);
						}
					}.runTaskLater(Main.plugin, 20);	
					
			}else if(MotodosPunir.hasBannedIP(p.getAddress().getHostString())){
				e.setJoinMessage(null);
				 new BukkitRunnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							msgBannedIp(p);
							e.setJoinMessage(null);
					
						}
					}.runTaskLater(Main.plugin, 20);	
			}
		
		}
		
		
	}

}
