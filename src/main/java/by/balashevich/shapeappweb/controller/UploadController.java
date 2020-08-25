package by.balashevich.shapeappweb.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class UploadController extends HttpServlet {
    private static final String CHARACTER_ENCODING = "UTF-8";
    private static Logger logger = LogManager.getLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String applicationFileDirectory = request.getServletContext().getInitParameter("upload.location"); // TODO: 24.08.2020 is it ok to use web.xml
        Path path = Paths.get(applicationFileDirectory);

        if (Files.notExists(path)) {
            Files.createDirectory(path);
        }

        request.setCharacterEncoding(CHARACTER_ENCODING);
        request.getParts().forEach(part -> {
            try {
                part.write(path + File.separator + part.getSubmittedFileName());
                request.setAttribute("message", String.format("File %s loaded successfully", part.getSubmittedFileName()));
            } catch (IOException e) {
                logger.log(Level.ERROR, "Error while loading File", e);
                request.setAttribute("message", "Error while loading File");
            }
        });
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
