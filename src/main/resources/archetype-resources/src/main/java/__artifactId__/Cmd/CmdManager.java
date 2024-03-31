#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.Cmd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;


public class CmdManager implements CommandExecutor, TabCompleter {

    private static HashMap<String, SubCmdBase> subCommands = new HashMap<>();

    public static void registerSubCommand(String name, SubCmdBase subCommand) {
        subCommands.put(name, subCommand);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;
        var p = (Player) sender;
        if (subCommands.containsKey(args[0])) {
            return subCommands.get(args[0]).onSubCommand(p, Arrays.copyOfRange(args, 1, args.length));
        } else {
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return List.copyOf(subCommands.keySet());
        }
        var subCommand = subCommands.get(args[0]);
        if (subCommand != null) {
            return subCommand.onTabComplete((Player) sender, Arrays.copyOfRange(args, 1, args.length));
        } else {
            return null;
        }
    }

}
