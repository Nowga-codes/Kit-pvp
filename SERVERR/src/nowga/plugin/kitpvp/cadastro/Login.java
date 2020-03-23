package nowga.plugin.kitpvp.cadastro;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.connorlinfoot.titleapi.TitleAPI;

import nowga.plugin.kitpvp.Main;
import nowga.plugin.kitpvp.Manager;
import nowga.plugin.kitpvp.Permissions;
import nowga.plugin.kitpvp.conexao.MetodosKITS;
import nowga.plugin.kitpvp.conexao.MetodosLogin;
import nowga.plugin.kitpvp.conexao.MetodosMySql;
import nowga.plugin.kitpvp.rank.RankAPI;
import nowga.plugin.kitpvp.scoreTab.PlacarScore;
import nowga.plugin.kitpvp.tag.Tags;

public class Login implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public static void autenticado(Player p) {
		
		//carregar bancos de dados
		MetodosKITS.RegisterKITS(p);
		MetodosMySql.playerJoinEventMySql(p);
	    RankAPI.setRankDeath(p);
		
	while (Eventos.unlogged.contains(p.getName())) {
		Eventos.unlogged.remove(p.getName());
	}	
	
		p.sendMessage(Eventos.prefix+" §7Logado com sucesso!");
	TitleAPI.sendFullTitle(p, 20, 50, 20, Main.ServerName, "§e§lAUTENTICADO! §7");
	Manager.HOTBARLOBBY(p);
    Tags.setTagJoin(p);
    PlacarScore.setScore(p);
    
    if(p.hasPermission(Permissions.MSGJOINSTAFFS)) {
    
    	p.sendMessage(" \n \n §2§lMensagem para staffs: \n "
    			+ "  *§aNão use a mesma senha em outros servidores para evitar que outros players entrem com sua conta, caso haja "
    			+ "irresponsabilidade de algum staff nesse quesito, o mesmo sera retirado do cargo! \n \n ");
    }
	Manager.playSoundXp(p);
    
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("register")) {
			
			Player p = (Player)sender;
			
			//se ja for registrado
			if(Eventos.unlogged.contains(p.getName())) {
			if(MetodosLogin.containsPlayers(p)) {
				p.sendMessage(Eventos.prefix+" §cVocê ja esta registrado, use /login <senha>");
				return true;
			}
			
			
			if(args.length !=2) {
				p.sendMessage(Eventos.prefix + " §cUse /register <senha> <senha>");
			}
			if(args[0].equals(args[1])) {
				String senha = args[0];
				MetodosLogin.playerRegister(p, senha);
				p.sendMessage(Eventos.prefix+" §aRegistrado com sucesso!");
				Eventos.unlogged.remove(p.getName());
				autenticado(p);
			}else {
				p.sendMessage(Eventos.prefix+" §cAs senhas não coincidem!");
			}
			}else {
				p.sendMessage(Eventos.prefix+" §cVocê ja esta autenticado");
			}
		}
        if(cmd.getName().equalsIgnoreCase("login")) {
        	Player p = (Player)sender;
        	
        	if(Eventos.unlogged.contains(p.getName())) {
        	if(!(MetodosLogin.containsPlayers(p))) {
				p.sendMessage(Eventos.prefix+" §cVocê ainda não esta registrado, use /register <senha> <senha>");
				return true;
			}
        	
        	if(args.length !=1) {
				p.sendMessage(Eventos.prefix + " §cUse /register <senha> <senha>");
			}
        	
        	if(args[0].equals(MetodosLogin.getSenha(p))) {
        		autenticado(p);
        	}else {
        		p.sendMessage(Eventos.prefix + " §cSenha incorreta!");
        	}
        	}else {
				p.sendMessage(Eventos.prefix+" §cVocê ja esta autenticado");
			}
		}
    return false;
	}

}
