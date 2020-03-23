package nowga.plugin.kitpvp.rank;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class RankEvent {

	public void onJoinRank(PlayerJoinEvent e) {
		
		Player p= e.getPlayer();
		RankAPI.setRankDeath(p);
	}
	
	public void deathRank(PlayerDeathEvent e) {
		Player p= e.getEntity();
		
		
		
		RankAPI.setRankDeath(p);
	}
	
}
