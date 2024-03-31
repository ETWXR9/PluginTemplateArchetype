#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.Cmd;

import java.util.List;

import org.bukkit.entity.Player;

public class CmdSample implements SubCmdBase {

    @Override
    public boolean onSubCommand(Player p, String[] args) {
        // check arguments
        if (args.length == 0) {
            p.sendMessage("Sample!");
            return true;
        }
        if (args.length == 1) {
            p.sendMessage("Sample: " + args[0]);
            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(Player p, String[] args) {
        if (args.length == 1) {
            return List.of("arg1", "arg2");
        }
        return null;
    }

}
