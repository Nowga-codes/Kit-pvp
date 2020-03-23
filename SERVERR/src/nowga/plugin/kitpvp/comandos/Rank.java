package nowga.plugin.kitpvp.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.rank.Ranks;

public class Rank extends Ranks implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("ranks")) {
			
			Player p= (Player)sender;
			

			
			p.sendMessage("§e§l       RANKS");
			p.sendMessage(" "+UNRANKED+" §7Unranked §f- §a0  XP");
			p.sendMessage(" "+COBRE+" §9Cobre §f- §a250 XP");
			p.sendMessage(" "+BRONZE+" §2Bronze §f- §a500 XP");
			p.sendMessage(" "+FERRO+" §3Ferro §f- §a750 XP");
			p.sendMessage(" "+PRATA+" §4Prata §f- §a1000 XP");
			p.sendMessage(" "+OURO+" §eOuro §f- §a1250 XP");
			p.sendMessage(" "+PLATINA+" §5Platina §f- §a1500 XP");
			p.sendMessage(" "+DIAMANTE+" §bDiamante §f- §a2000 XP");
			p.sendMessage(" "+RUBI+" §cRubi §f- §a2500 XP");
			p.sendMessage(" "+THUNDERMC+" §6ThunderMC §f- §a5000 XP");
			
		}
if(cmd.getName().equalsIgnoreCase("setrank")) {

			Player p= (Player)sender;
			p.sendMessage("§cComando indisponivel!");
			/*/
			 * 	Sring rank= args[0];
			
			 * if(args[0].equalsIgnoreCase("Cobre")) {RankAPI.setRank(p, Ranks.COBRE);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}
			
			if(args[0].equalsIgnoreCase("Bronze")) {RankAPI.setRank(p, Ranks.BRONZE);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}
			
			if(args[0].equalsIgnoreCase("Ferro")) {RankAPI.setRank(p, Ranks.FERRO);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}
			
			if(args[0].equalsIgnoreCase("prata")) {RankAPI.setRank(p, Ranks.PRATA);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}
			
			if(args[0].equalsIgnoreCase("ouro")) {RankAPI.setRank(p, Ranks.OURO);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}
			
			if(args[0].equalsIgnoreCase("platina")) {RankAPI.setRank(p, Ranks.PLATINA);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}
			
			if(args[0].equalsIgnoreCase("diamante")) {RankAPI.setRank(p, Ranks.DIAMANTE);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}
			
			if(args[0].equalsIgnoreCase("rubi")) {RankAPI.setRank(p, Ranks.RUBI);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}

			if(args[0].equalsIgnoreCase("thundermc")) {RankAPI.setRank(p, Ranks.THUNDERMC);
			p.sendMessage("§aRank §7§l"+rank.toUpperCase()+" §asetado com sucesso!");}

			

			 */
}
		return false;
	}
	
}
