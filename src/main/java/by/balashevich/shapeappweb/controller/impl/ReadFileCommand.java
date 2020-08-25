package by.balashevich.shapeappweb.controller.impl;

import by.balashevich.shapeappweb.controller.ActionCommand;
import by.balashevich.shapeappweb.creator.impl.QuadrangleCreator;
import by.balashevich.shapeappweb.entity.Quadrangle;
import by.balashevich.shapeappweb.exception.ShapeProjectException;
import by.balashevich.shapeappweb.parser.EntityParser;
import by.balashevich.shapeappweb.reader.ShapeDataReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class ReadFileCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShapeDataReader shapeDataReader = new ShapeDataReader();
        EntityParser entityParser = new EntityParser();
        QuadrangleCreator quadrangleCreator = new QuadrangleCreator();

        String uploadFilesDirectory = request.getServletContext().getInitParameter("upload.location");
        String fileName = request.getParameter("reading_file");
        String filePath = uploadFilesDirectory + fileName;

        try {
            List<String> shapeDataList = shapeDataReader.readFileData(filePath);
            List<List<Double>> shapeValuesList = entityParser.parseQuadrangles(shapeDataList);
            List<Quadrangle> quadrangleList = quadrangleCreator.createShapes(shapeValuesList);
            request.setAttribute("quadrangleList", quadrangleList);
            request.getRequestDispatcher("/jsp/shapes.jsp").forward(request, response);
        } catch (ShapeProjectException e) {
            logger.log(Level.ERROR, "error while reading data", e);
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
    }
}
