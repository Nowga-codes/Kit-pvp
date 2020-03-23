package nowga.plugin.kitpvp.scoreTab;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.cadastro.Eventos;
import nowga.plugin.kitpvp.conexao.MetodosMySql;
import nowga.plugin.kitpvp.eventos.AntiJoinBot;
import nowga.plugin.kitpvp.eventos.AntiRelog;
import nowga.plugin.kitpvp.rank.RankAPI;
import nowga.plugin.kitpvp.tag.TagCommand;
import nowga.plugin.kitpvp.tag.Tags;

public class PlacarScore {

	  public static ArrayList<Player> score= new ArrayList<Player>();
		
	    public static void sendPacketHeadFooter() {
	    	
	    	
	    	PacketPlayOutPlayerListHeaderFooter packet= new PacketPlayOutPlayerListHeaderFooter();
			Object footer= new ChatComponentText(" \n §eDiscord:§f https://discord.gg/jJTH2cP"+ 
	    	                                                     " \n §eLoja§f: http://bit.ly/thundermc"
	    	                                          +" \n §ethundermc.virtus.host");
			
		
					 Object headder= new ChatComponentText(Main.ServerName+" \n "
					                                           +" \n §e§lKIT PVP \n "
			                                          +"\n      §fJogadores neste servidor: §a"+Bukkit.getOnlinePlayers().size()+ " \n ");
					 try {
							Field a = packet.getClass().getDeclaredField("a");
							a.setAccessible(true);
							Field b = packet.getClass().getDeclaredField("b");
							b.setAccessible(true);
					
							
							a.set(packet, headder);
							b.set(packet, footer);
							
							for(Player pls: Bukkit.getOnlinePlayers()) {
								if(Eventos.unlogged.contains(pls.getName()))return;
								((CraftPlayer)pls).getHandle().playerConnection.sendPacket(packet);
							}
							
							
						} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
	    }

	    
		public static void build(Player p) {
			
			if(Eventos.unlogged.contains(p.getName())|| AntiJoinBot.unverified.contains(p)|| AntiRelog.relog.contains(p.getName()))return;
			
			  score.add(p);
			
			Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
			Objective obj = sb.registerNewObjective("score", "dummy");
			
			
			obj.setDisplayName("§6§lTHUNDER§f§lMC");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			
			LineAdder line = new LineAdder(sb, obj);
			
			line.addLine("§0", "§7", "§9", 12);
			line.addLine("  ", "§fGrupo: ", "§7Carregando...", 11);
			line.addLine("§1", "", "", 10);
			line.addLine("  ", "§fKills:§c ", "§7Carregando...", 9);
			line.addLine("  ", "§fDeaths:§c ", "§7Carregando...", 8);
			line.addLine("", "§2", "", 7);
			line.addLine("  ", "§fCoins:§6 ", "§7Carregando...", 6);
			line.addLine("  ", "§fXp:§6 ", "§7Carregando...", 5);
			line.addLine("  ", "§fRank:§6 ", "§7Carregando...", 4);
			line.addLine("", "§4 ", "", 1);
			line.addLine("", "  §c/score     ", "", 0);
			
			Team DONO = sb.registerNewTeam("DONO");
			Team ADMIN = sb.registerNewTeam("ADMIN");
			Team  MOD = sb.registerNewTeam("MOD");
			Team  MODGC = sb.registerNewTeam("MODGC");
			Team TRIAL = sb.registerNewTeam("TRIAL");
			Team BUILDER = sb.registerNewTeam("BUILDER");
			Team HELPER = sb.registerNewTeam("HELPER");
			Team ALPHA = sb.registerNewTeam("ALPHA");
			Team LIGHT = sb.registerNewTeam("LIGHT");
			Team BETA = sb.registerNewTeam("BETA");
			Team YTPLUS = sb.registerNewTeam("YTPLUS");
			Team YT = sb.registerNewTeam("YT");
			Team PRO = sb.registerNewTeam("PRO");
			Team MEMBRO = sb.registerNewTeam("MEMBRO");
			
			DONO.setPrefix("§6§lDONO §6");
			ADMIN.setPrefix("§c§lADMIN §c");
			MODGC.setPrefix("§2§lMOD-GC §2");
			MOD.setPrefix("§a§lMOD §a");
			TRIAL.setPrefix("§9§lTRIAL §9");
			BUILDER.setPrefix("§f§lBUILDER §f");
			HELPER.setPrefix("§e§lHELPER §e");
			ALPHA.setPrefix("§d§lALPHA §d");
			LIGHT.setPrefix("§5§lLIGHT §5");
			BETA.setPrefix("§4§lBETA §4");
			YTPLUS.setPrefix("§b§lYT+ §b");
			YT.setPrefix("§3§lYT §3");
			PRO.setPrefix("§f§lPRO §f");
			MEMBRO.setPrefix("§7");
		
			p.setScoreboard(sb);

			
				
			
		}
		
		public static void update(Player p) {

			
			Scoreboard sb = p.getScoreboard();
		
				
			
			if (sb.getObjective("score") != null) {
				Team grupo = sb.getTeam("line11");
				grupo.setSuffix(Tags.getTagScore(p));
				
				int getkills = MetodosMySql.getStatus(p, "kills");
				Team kills = sb.getTeam("line9");
				kills.setSuffix( getkills+ "");
				
				int getdeaths = MetodosMySql.getStatus(p, "deaths");
				Team mortes = sb.getTeam("line8");
				mortes.setSuffix(getdeaths+"");
				
				int getcoins = MetodosMySql.getStatus(p, "coins");
				Team coins = sb.getTeam("line6");
				coins.setSuffix(getcoins+"");
				
				int getxp = MetodosMySql.getStatus(p, "xp");
				Team xp = sb.getTeam("line5");
				xp.setSuffix(getxp+"");

				Team rank= sb.getTeam("line4");
				rank.setSuffix("§7Unranked");
			}
				
			
				for(Player pls: Bukkit.getOnlinePlayers()) {
				
					if(Eventos.unlogged.contains(p.getName())|| AntiJoinBot.unverified.contains(p) || AntiRelog.relog.contains(p.getName()))return;
					
					if(Eventos.unlogged.contains(pls.getName())) {
					      Team MEMBRO= sb.getTeam("MEMBRO");
							MEMBRO.addEntry(pls.getName());
						return;
					}
	            if(!(TagCommand.tags.containsKey(pls.getName()))){
	                Team MEMBRO= sb.getTeam("MEMBRO");
					MEMBRO.addEntry(pls.getName());
					
	            }else {
	            	
				String getTag=TagCommand.tags.get(pls.getName());
				Team t= sb.getTeam(getTag);
				t.setSuffix(" "+RankAPI.getRank(pls));
				t.addEntry(pls.getName());
				 
	            }
				
				}
				/*/
				 * 	sb.getTeams().stream().filter(t -> t.getName().equals("Dono")).findFirst().get();
				 */
				}
		
		

		
		public static void timeScore() {
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
                         Manager.diaEterno();
                         sendPacketHeadFooter();
					for(Player p: Bukkit.getOnlinePlayers()) {
					
						if(Bukkit.getOnlinePlayers().size()==0) return;
						
						
					
						if(Eventos.unlogged.contains(p.getName())|| AntiJoinBot.list.contains(p))return;
						if(p.getScoreboard()== null) {
							build(p);
						}else {
							update(p);
						}
					}
				}
			}.runTaskTimerAsynchronously(Main.plugin, 0, 20*5);
			
		}
		
		
		public static void setScore(Player p) {

			build(p);
		}
	
}
