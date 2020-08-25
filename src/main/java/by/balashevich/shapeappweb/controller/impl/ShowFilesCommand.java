package by.balashevich.shapeappweb.controller.impl;

import by.balashevich.shapeappweb.controller.ActionCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ShowFilesCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Path path = Paths.get(request.getServletContext().getInitParameter("upload.location"));
        List<Path> files = Files.list(path).collect(Collectors.toList());
        request.setAttribute("list", files);
        request.getRequestDispatcher("/jsp/filelist.jsp").forward(request, response);
    }
}
