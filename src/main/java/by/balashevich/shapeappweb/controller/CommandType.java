package by.balashevich.shapeappweb.controller;

import by.balashevich.shapeappweb.controller.impl.ReadFileCommand;
import by.balashevich.shapeappweb.controller.impl.ShowFilesCommand;

public enum CommandType {
    SHOW_FILES(new ShowFilesCommand()),
    READ_FILE(new ReadFileCommand());

    private ActionCommand command;

    CommandType(ActionCommand command){
        this.command = command;
    }

    public ActionCommand getCommand(){
        return command;
    }
}
