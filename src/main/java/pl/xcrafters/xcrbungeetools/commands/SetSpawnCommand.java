package pl.xcrafters.xcrbungeetools.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import pl.xcrafters.xcrbungeetools.ToolsPlugin;

public class SetSpawnCommand extends Command{

    ToolsPlugin plugin;
    
    public SetSpawnCommand(ToolsPlugin plugin){
        super("setspawn", "tools.setspawn");
        this.plugin = plugin;
        ProxyServer.getInstance().getPluginManager().registerCommand(plugin, this);
    }
    
    @Override
    public void execute(CommandSender sender, String[] args){
        if(sender.equals(ProxyServer.getInstance().getConsole())){
            sender.sendMessage(plugin.color("&cTa komenda nie moze zostac wywolana z konsoli!"));
            return;
        }
        ProxiedPlayer player = (ProxiedPlayer) sender;
        plugin.setServerSpawn(player);
        player.sendMessage(plugin.color("&9Ustawiono spawn w miejscu, w ktorym stoisz!"));
    }
    
}
