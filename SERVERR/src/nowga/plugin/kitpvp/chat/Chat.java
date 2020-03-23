package nowga.plugin.kitpvp.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Team;

import nowga.plugin.kitpvp.cadastro.Eventos;
import nowga.plugin.kitpvp.conexao.MotodosPunir;
import nowga.plugin.kitpvp.rank.RankAPI;
import nowga.plugin.kitpvp.tag.TagCommand;

public class Chat implements Listener{

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		Player p= e.getPlayer();
		
		//ANTI DIVULGAÇÕES
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
		
		if(Eventos.unlogged.contains(p.getName())) {
		Eventos.chatUnlogged(e);
		return;
		}
		
		if(MotodosPunir.hasBanned(p.getUniqueId().toString()) || MotodosPunir.hasBannedIP(p.getAddress().getHostString())) {
			e.setCancelled(true);
			return;
		}
	
	
		  if(!(TagCommand.tags.containsKey(p.getName()))) {
			  String tag = "§7";
				e.setFormat(RankAPI.getRank(p)+" "+tag+p.getName()+"§7: "+ e.getMessage());
				TagCommand.tags.put(p.getName(), "MEMBRO");
				return;
		  }
		  String tagSave = TagCommand.tags.get(p.getName());
		  Team teamPlayer= p.getScoreboard().getTeam(tagSave);
		e.setFormat(RankAPI.getRank(p)+" "+ teamPlayer.getPrefix()+p.getName()+"§7: "+ e.getMessage());
		 
		
	}
	
}
