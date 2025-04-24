package command;

public class Help extends Command {
    @Override
    public String execute() {
        return "add all commands";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
