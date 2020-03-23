package nowga.plugin.kitpvp.rank;

import java.util.HashMap;

import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.conexao.MetodosMySql;

public class RankAPI extends Ranks{

	public static HashMap<Player, String> rank= new HashMap<Player, String>();
	
	public static void setRank(Player player, String Rank) {
		
		rank.remove(player);
		rank.put(player, Rank);                                   
	
	}
	
	public static void setRankDeath(Player player) {
		
		int xp = MetodosMySql.getStatus(player, "xp");
		
		if(xp >= 0 && xp <100) {
			setRank(player, Ranks.UNRANKED);
		}
		if(xp >=100 && xp< 250) {
			setRank(player, Ranks.COBRE);
		}
		if(xp >=250 && xp< 500) {
			setRank(player, Ranks.BRONZE);
		}
		if(xp >=500 && xp< 750) {
			setRank(player, Ranks.FERRO);
		}
		if(xp >=750 && xp< 1000) {
			setRank(player, Ranks.PRATA);
		}
		if(xp >=1000 && xp< 1250) {
			setRank(player, Ranks.OURO);
		}
		if(xp >=1250 && xp< 1500) {
			setRank(player, Ranks.PLATINA);
		}
		if(xp >=1500 && xp< 2000) {
			setRank(player, Ranks.DIAMANTE);
		}
		if(xp >=2000 && xp< 2500) {
			setRank(player, Ranks.RUBI);
		}
		if(xp >=2500 && xp< 5000) {
			setRank(player, Ranks.THUNDERMC);
		}
	}

	public static boolean containsRank(Player player, String Rank) {
		
		if(rank.get(player) == Rank) {
			return true;
		}else {
			return false;
		}
		
	}
	public static String chatRank(Player player) {
		
		if (containsRank(player, Ranks.UNRANKED)) {
			return Ranks.UNRANKED;
		}
		return rank.get(player);
	}
	public static String getRank(Player player) {
		return rank.get(player);
	}
}
