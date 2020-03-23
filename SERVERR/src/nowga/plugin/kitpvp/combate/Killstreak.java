package nowga.plugin.kitpvp.combate;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Killstreak {

	public static String prefix= "§6§lKillStreak: ";
	public static HashMap<Player, Integer> killstreak= new HashMap<Player, Integer>();
	
	public static void deathKillStreak(PlayerDeathEvent e) {
          
          if(!(e.getEntity()instanceof Player))return;
          if(!(e.getEntity().getKiller() instanceof Player))return;
          
          Player vitima= e.getEntity();
          Player assasino= e.getEntity().getKiller();
          
          if(killstreak.containsKey(vitima)) {
        	  
        	  if(killstreak.get(vitima)>=5) {
Bukkit.broadcastMessage(prefix+"§6"+assasino.getName()+" §7acabou com o KillStreak de §6"+killstreak.get(vitima)+" §7de §6"+vitima.getName()+".");
        	  }
        	  vitima.remove();
          }
          
          if(!(killstreak.containsKey(assasino))){
        	  killstreak.put(assasino, 1);
          }else {
        	  
        	  int valorAntes= killstreak.get(assasino);
        	  killstreak.put(assasino, valorAntes+1);
        	  
        	  if(killstreak.get(assasino)==5){
        		  
Bukkit.broadcastMessage(prefix+"§7jogador §6"+assasino.getName()+" §7esta com um KillStreak de §6"+killstreak.get(assasino)+".");
        		  
        	  }
        	  if(killstreak.get(assasino)==10){
        		  
        		  Bukkit.broadcastMessage(prefix+"§7jogador §6"+assasino.getName()+" §7esta com um KillStreak de §6"+killstreak.get(assasino)+".");
        		          		  
        		          	  }
        	  if(killstreak.get(assasino)==15){
        		  
        		  Bukkit.broadcastMessage(prefix+"§7jogador §6"+assasino.getName()+" §7esta com um KillStreak de §6"+killstreak.get(assasino)+".");
        		          		  
        		          	  }
        	  if(killstreak.get(assasino)==20){
        		  
        		  Bukkit.broadcastMessage(prefix+"§7jogador §6"+assasino.getName()+" §7esta com um KillStreak de §6"+killstreak.get(assasino)+".");
        		          		  
        		          	  }
        	  if(killstreak.get(assasino)==30){
        		  
        		  Bukkit.broadcastMessage(prefix+"§7jogador §6"+assasino.getName()+" §7esta com um KillStreak de §6"+killstreak.get(assasino)+".");
        		          		  
        		          	  }
        	  if(killstreak.get(assasino)==40){
        		  
        		  Bukkit.broadcastMessage(prefix+"§7jogador §6"+assasino.getName()+" §7esta com um KillStreak de §6"+killstreak.get(assasino)+".");
        		          		  
        		          	  }
        	  if(killstreak.get(assasino)==50){
        		  
        		  Bukkit.broadcastMessage(prefix+"§7jogador §6"+assasino.getName()+" §7esta com um KillStreak de §6"+killstreak.get(assasino)+".");
        		          		  
        		          	  }
        	  
          }
		
		
	}

	
}
