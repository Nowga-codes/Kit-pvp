package nowga.plugin.kitpvp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import nowga.plugin.kitpvp.cadastro.Login;
import nowga.plugin.kitpvp.cadastro.TrocarSenha;
import nowga.plugin.kitpvp.chat.Chat;
import nowga.plugin.kitpvp.comandos.Admin;
import nowga.plugin.kitpvp.comandos.ClearChat;
import nowga.plugin.kitpvp.comandos.Fly;
import nowga.plugin.kitpvp.comandos.Formularios;
import nowga.plugin.kitpvp.comandos.Ping;
import nowga.plugin.kitpvp.comandos.Rank;
import nowga.plugin.kitpvp.comandos.Report;
import nowga.plugin.kitpvp.comandos.Score;
import nowga.plugin.kitpvp.comandos.Spawn;
import nowga.plugin.kitpvp.comandos.Speed;
import nowga.plugin.kitpvp.comandos.youtuber;
import nowga.plugin.kitpvp.combate.Combate;
import nowga.plugin.kitpvp.conexao.Connect;
import nowga.plugin.kitpvp.eventos.AntiForceOP;
import nowga.plugin.kitpvp.eventos.AntiJoinBot;
import nowga.plugin.kitpvp.eventos.Build;
import nowga.plugin.kitpvp.eventos.CancelDROP;
import nowga.plugin.kitpvp.eventos.Dano;
import nowga.plugin.kitpvp.eventos.Motd;
import nowga.plugin.kitpvp.eventos.PvpProtection;
import nowga.plugin.kitpvp.eventos.Sopa;
import nowga.plugin.kitpvp.feast.FeastCommands;
import nowga.plugin.kitpvp.inventarios.ClicarHotBar;
import nowga.plugin.kitpvp.inventarios.invFormularios;
import nowga.plugin.kitpvp.inventarios.invYT;
import nowga.plugin.kitpvp.killdeathsxp.KillsDeathsXP;
import nowga.plugin.kitpvp.kits.Anchor;
import nowga.plugin.kitpvp.kits.FisherMan;
import nowga.plugin.kitpvp.kits.Grappler;
import nowga.plugin.kitpvp.kits.Kangaroo;
import nowga.plugin.kitpvp.kits.Poseidon;
import nowga.plugin.kitpvp.kits.SelecionarKit;
import nowga.plugin.kitpvp.kits.Stomper;
import nowga.plugin.kitpvp.kits.Switcher;
import nowga.plugin.kitpvp.kits.Thor;
import nowga.plugin.kitpvp.kits.Urgal;
import nowga.plugin.kitpvp.kits.Viper;
import nowga.plugin.kitpvp.loja.ComprarKit;
import nowga.plugin.kitpvp.placas.Recraft;
import nowga.plugin.kitpvp.placas.SopaPlaca;
import nowga.plugin.kitpvp.punir.Ban;
import nowga.plugin.kitpvp.punir.BanIP;
import nowga.plugin.kitpvp.punir.EventPunir;
import nowga.plugin.kitpvp.punir.GetIP;
import nowga.plugin.kitpvp.punir.Mute;
import nowga.plugin.kitpvp.punir.UnMute;
import nowga.plugin.kitpvp.punir.Unban;
import nowga.plugin.kitpvp.punir.UnbanIP;
import nowga.plugin.kitpvp.scoreTab.PlacarScore;
import nowga.plugin.kitpvp.tag.TagCommand;
import nowga.plugin.kitpvp.vips.VIPSET;
import nowga.plugin.kitpvp.warps.CreateWarp;
import nowga.plugin.kitpvp.warps.JoinWarp;
import nowga.plugin.kitpvp.warps.Warp1V1;

public class Main extends JavaPlugin implements Listener {

	public static Main plugin;
	public static String ServerName= "§6§lTHUNDER§f§lMC";
	
	public void onEnable() {
		plugin= this;
	
	Connect.open();
	
	registerCommands();		
	registerEvents();

	Manager.anuncios();	
	PlacarScore.timeScore();
	
		}
		
	public void onDisable() {

		
	for(Player all: Bukkit.getOnlinePlayers()) {
			all.kickPlayer(ServerName+" §e§lSERVIDOR REINICIANDO ...");
			
			
		}
		
			}
	public void onReload() {
		

	}

	public void registerCommands() {
		getCommand("build").setExecutor(new nowga.plugin.kitpvp.comandos.Build());
		getCommand("tag").setExecutor(new TagCommand());
		getCommand("tags").setExecutor(new TagCommand());
		getCommand("register").setExecutor(new Login());
		getCommand("login").setExecutor(new Login());
		getCommand("trocarsenha").setExecutor(new TrocarSenha());
		
		getCommand("warp").setExecutor(new CreateWarp());
		getCommand("setwarp").setExecutor(new CreateWarp());
		getCommand("warps").setExecutor(new CreateWarp());
		getCommand("delwarp").setExecutor(new CreateWarp());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("speed").setExecutor(new Speed());
		getCommand("report").setExecutor(new Report());
		
		getCommand("ban").setExecutor(new Ban());
		getCommand("banip").setExecutor(new BanIP());
		getCommand("mute").setExecutor(new Mute());
		getCommand("ip").setExecutor(new GetIP());
		
		getCommand("unban").setExecutor(new Unban());
		getCommand("unbanip").setExecutor(new UnbanIP());
		getCommand("unmute").setExecutor(new UnMute());
		
		getCommand("vipset").setExecutor(new VIPSET());
		getCommand("setfeast").setExecutor(new FeastCommands());
		getCommand("admin").setExecutor(new Admin());
		getCommand("fly").setExecutor(new Fly());
		getCommand("youtuber").setExecutor(new youtuber());
		getCommand("yt").setExecutor(new youtuber());
		getCommand("score").setExecutor(new Score());
		
		getCommand("ranks").setExecutor(new Rank());
		getCommand("setrank").setExecutor(new Rank());
		getCommand("aplicar").setExecutor(new Formularios());
		getCommand("cc").setExecutor(new ClearChat());
		getCommand("ping").setExecutor(new Ping());
	}
public void registerEvents() {
	Bukkit.getPluginManager().registerEvents(new Motd(), plugin);
	Bukkit.getPluginManager().registerEvents(new Geral(), plugin);
	Bukkit.getPluginManager().registerEvents(new SelecionarKit(), plugin);
	Bukkit.getPluginManager().registerEvents(new ClicarHotBar(), plugin);
	Bukkit.getPluginManager().registerEvents(new KillsDeathsXP(), plugin);
	Bukkit.getPluginManager().registerEvents(new Build(), plugin);
	Bukkit.getPluginManager().registerEvents(new Combate(), plugin);
	Bukkit.getPluginManager().registerEvents(new Sopa(), plugin);
	Bukkit.getPluginManager().registerEvents(new Chat(), plugin);
	Bukkit.getPluginManager().registerEvents(new JoinWarp(), plugin);
	
	
	//KITS
	Bukkit.getPluginManager().registerEvents(new Kangaroo(), plugin);
	Bukkit.getPluginManager().registerEvents(new Viper(), plugin);
	Bukkit.getPluginManager().registerEvents(new Thor(), plugin);
	Bukkit.getPluginManager().registerEvents(new Stomper(), plugin);
	Bukkit.getPluginManager().registerEvents(new FisherMan(), plugin);
	Bukkit.getPluginManager().registerEvents(new Poseidon(), plugin);
	Bukkit.getPluginManager().registerEvents(new Anchor(), plugin);
	Bukkit.getPluginManager().registerEvents(new Switcher(), plugin);
	Bukkit.getPluginManager().registerEvents(new Urgal(), plugin);
	Bukkit.getPluginManager().registerEvents(new Grappler(), plugin);
	
	
	Bukkit.getPluginManager().registerEvents(new Warp1V1(), plugin);
	Bukkit.getPluginManager().registerEvents(new EventPunir(), plugin);
	Bukkit.getPluginManager().registerEvents(new AntiForceOP(), plugin);
	Bukkit.getPluginManager().registerEvents(new AntiJoinBot(), plugin);
	Bukkit.getPluginManager().registerEvents(new nowga.plugin.kitpvp.eventos.Admin(), plugin);
	Bukkit.getPluginManager().registerEvents(new Dano(), plugin);
	Bukkit.getPluginManager().registerEvents(new CancelDROP(), plugin);
	Bukkit.getPluginManager().registerEvents(new PvpProtection(), plugin);
	
	Bukkit.getPluginManager().registerEvents(new ComprarKit(), plugin);
	Bukkit.getPluginManager().registerEvents(new Recraft(), plugin);
	Bukkit.getPluginManager().registerEvents(new SopaPlaca(), plugin);
	Bukkit.getPluginManager().registerEvents(new invFormularios(), plugin);
	Bukkit.getPluginManager().registerEvents(new invYT(), plugin);
	}

}
