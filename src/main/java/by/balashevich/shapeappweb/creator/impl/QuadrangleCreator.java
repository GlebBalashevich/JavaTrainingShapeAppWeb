package by.balashevich.shapeappweb.creator.impl;

import by.balashevich.shapeappweb.creator.PointCreator;
import by.balashevich.shapeappweb.creator.ShapeCreator;
import by.balashevich.shapeappweb.entity.Point;
import by.balashevich.shapeappweb.entity.Quadrangle;
import by.balashevich.shapeappweb.exception.ShapeProjectException;
import by.balashevich.shapeappweb.validator.QuadrangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuadrangleCreator implements ShapeCreator<Quadrangle> {
    private static final int NUMBER_POINTS = 4;
    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Quadrangle> createShapes(List<List<Double>> shapesData) throws ShapeProjectException {
        List<Quadrangle> quadrangleList = new ArrayList<>();

        if (shapesData != null && !shapesData.isEmpty()) {
            for (List<Double> shapeDataElement : shapesData) {
                Optional<Quadrangle> quadrangle = createShape(shapeDataElement);
                quadrangle.ifPresent(quadrangleList::add);
            }
        } else{
            throw new ShapeProjectException();
        }

        return quadrangleList;
    }

    @Override
    public Optional<Quadrangle> createShape(List<Double> shapeData) {
        QuadrangleValidator validator = new QuadrangleValidator();
        PointCreator creator = new PointCreator();
        Optional<Quadrangle> quadrangle = Optional.empty();

        try {
            List<Point> pointList = creator.createPoints(shapeData);
            if (pointList != null && !pointList.isEmpty() && pointList.size() == NUMBER_POINTS) {
                Point pointA = pointList.get(0);
                Point pointB = pointList.get(1);
                Point pointC = pointList.get(2);
                Point pointD = pointList.get(3);

                if (validator.isQuadrangleExist(pointA, pointB, pointC, pointD)) {
                    quadrangle = Optional.of(new Quadrangle(pointA, pointB, pointC, pointD));
                }
            }
        } catch(ShapeProjectException e){
            logger.log(Level.ERROR, "error while creating quadrangle", e);
        }

        return quadrangle;
    }
}
