package nowga.plugin.kitpvp.killdeathsxp;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import nowga.plugin.kitpvp.combate.Combate;
import nowga.plugin.kitpvp.conexao.MetodosMySql;

public class KillsDeathsXP implements Listener{
	
	
	public static void aoMorrer(PlayerDeathEvent e) {
		Player vitima= e.getEntity();
		
		
		//se tiver em combate adicionar a kill para o ultimo player q hitou
		Player assasino =  Combate.combate.get(vitima);
		
		e.setDeathMessage(null);
		
		if(!(Combate.combate.containsKey(vitima))) {
			vitima.sendMessage(" §cVocê morreu por causas desconhecidas, seus status não foram alterados!");
			return;
		}
		if(assasino instanceof Player && vitima instanceof Player) {
			
			
		    MetodosMySql.addKills(assasino, 1);
		    MetodosMySql.addDeaths(vitima, 1);
			MetodosMySql.addCoins(assasino, 100);
			MetodosMySql.addXP(assasino, 5);
			assasino.sendMessage("\n§c§lCOINS §7você ganhou 100 coins.");
			assasino.sendMessage("§c§lXP §7você ganhou 5 xp. \n ");
			
			
	if(MetodosMySql.getStatus(vitima, "coins")== 0 || !(MetodosMySql.getStatus(vitima, "coins")>=50)) {
		
				vitima.sendMessage("\n§c§lCOINS §7você perdeu 0 coins.");
				 MetodosMySql.setCoins(vitima, 0);
				}else {
					vitima.sendMessage("\n§c§lCOINS §7você perdeu 50 coins.");
					MetodosMySql.removeCoins(vitima, 50);
				}

	
	if(MetodosMySql.getStatus(vitima, "xp") == 1) {
		vitima.sendMessage("§c§lXP §7você perdeu 1 xp. \n ");
        MetodosMySql.setXP(vitima, 0);
		return;
	}
			if(MetodosMySql.getStatus(vitima, "xp")== 0 || !(MetodosMySql.getStatus(vitima, "xp")>=2)){
				
				vitima.sendMessage("§c§lXP §7você perdeu 0 xp. \n ");
                MetodosMySql.setXP(vitima, 0);
			}else {
				vitima.sendMessage("§c§lXP §7você perdeu 2 xp. \n ");
				MetodosMySql.removeXP(vitima, 2);
				
			}
/*
 *  if(MetodosMySql.getStatus(vitima, "coins")<=50) {

			
				   MetodosMySql.setCoins(vitima, 0);
					vitima.sendMessage("\n§c§lCOINS §7você perdeu 50 coins.");
			        }	

        if(MetodosMySql.getStatus(vitima, "xp")<=2) {
        	MetodosMySql.setXP(vitima, 0);
        	vitima.sendMessage("§c§lXP §7você perdeu 2 xp. \n ");		
        	
        }
 */
		}
		
	}

}
