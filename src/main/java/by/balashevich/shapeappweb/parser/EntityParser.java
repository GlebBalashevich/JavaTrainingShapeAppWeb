package by.balashevich.shapeappweb.parser;

import by.balashevich.shapeappweb.exception.ShapeProjectException;
import by.balashevich.shapeappweb.validator.PointValidator;
import by.balashevich.shapeappweb.validator.QuadrangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EntityParser {
    private static final String POINTS_DELIMITER = ";";
    private static final String COORDINATES_DELIMITER = "\\s";
    private static Logger logger = LogManager.getLogger();

    public List<List<Double>> parseQuadrangles(List<String> quadranglesData) {
        List<List<Double>> quadranglesCoordinatesList = new ArrayList<>();

        for (String quadrangleDataElement : quadranglesData) {
            try {
                quadranglesCoordinatesList.add(parseQuadrangle(quadrangleDataElement));
            } catch (ShapeProjectException e) {
                logger.log(Level.ERROR, "Error while parsing quadrangles data", e);
            }

        }

        return quadranglesCoordinatesList;
    }

    public List<Double> parseQuadrangle(String quadrangleData) throws ShapeProjectException {
        QuadrangleValidator validator = new QuadrangleValidator();
        List<Double> quadrangleCoordinates = new ArrayList<>();

        if (validator.isQuadrangleDataCorrect(quadrangleData)) {
            String[] pointsData = quadrangleData.split(POINTS_DELIMITER);
            for (String pointDataElement : pointsData) {
                quadrangleCoordinates.addAll(parsePoint(pointDataElement));
            }
        } else {
            throw new ShapeProjectException("Error while parsing quadrangle data");
        }

        return quadrangleCoordinates;
    }

    public List<Double> parsePoint(String pointData) throws ShapeProjectException {
        PointValidator validator = new PointValidator();
        List<Double> pointCoordinates = new ArrayList<>();

        if (validator.isPointDataCorrect(pointData)) {
            String[] coordinatesData = pointData.trim().split(COORDINATES_DELIMITER);
            pointCoordinates.add(Double.parseDouble(coordinatesData[0].trim()));
            pointCoordinates.add(Double.parseDouble(coordinatesData[1].trim()));
        } else {
            throw new ShapeProjectException("Error while parsing point data");
        }

        return pointCoordinates;
    }
}
