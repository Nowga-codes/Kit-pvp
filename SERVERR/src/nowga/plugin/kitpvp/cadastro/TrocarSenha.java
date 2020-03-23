package nowga.plugin.kitpvp.cadastro;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nowga.plugin.kitpvp.conexao.MetodosLogin;

public class TrocarSenha implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player))return true;
		if(cmd.getName().equalsIgnoreCase("trocarsenha")) {
			
			Player p= (Player)sender;
			if(!(Eventos.unlogged.contains(p.getName()))) {
			if(args.length!= 2) {
			p.sendMessage("§cUse: /trocarsenha <senha antiga> <nova senha>.");	

				return true;
			}
			String senhaAntiga= MetodosLogin.getSenha(p);
			String novaSenha= args[1];
			
			if(args[0].equals(senhaAntiga)) {
				
				MetodosLogin.trocarSenha(p, novaSenha);
				p.sendMessage("§aSua senha foi alterada com sucesso!");
				
			}else {
				p.sendMessage("§ca senha inserida esta incorreta!");
			}
			
			
			}
		}
		return false;
	}
	
}
