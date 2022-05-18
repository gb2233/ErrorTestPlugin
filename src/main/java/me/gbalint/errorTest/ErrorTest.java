package me.gbalint.errorTest;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ErrorTest extends JavaPlugin implements CommandExecutor {
    @Override
    public void onEnable() {
        this.getCommand("errortest").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§aErrorTest ver" + this.getDescription().getVersion());
            sender.sendMessage("");
            sender.sendMessage("§a/errortest §7- §bto show this help menu");
            sender.sendMessage("§a/errortest success §7- §bsuccessful command execution");
            sender.sendMessage("§a/errortest fail §7- §bunsuccessful command execution");
            sender.sendMessage("§a/errortest ex §7- §bcommand execution throws exception");
            sender.sendMessage("");
            return true;
        }else if (args[0].equalsIgnoreCase("success") ) {
            Bukkit.broadcastMessage("[ErrorTest] success");
            return true;
        }else if (args[0].equalsIgnoreCase("fail") ) {
            Bukkit.broadcastMessage("[ErrorTest] fail");
            return false;
        }else if (args[0].equalsIgnoreCase("ex") ) {
            throw new CommandException("CustomCommandException");
        }
        return false;
    }
}
