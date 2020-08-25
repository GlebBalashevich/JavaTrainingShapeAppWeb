package by.balashevich.shapeappweb.controller;

public class CommandProvider {
    public ActionCommand defineCommand(String command){
        return CommandType.valueOf(command.toUpperCase()).getCommand();
    }
}
