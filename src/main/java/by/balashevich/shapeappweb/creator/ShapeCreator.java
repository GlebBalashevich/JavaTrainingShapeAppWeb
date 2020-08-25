package by.balashevich.shapeappweb.creator;

import by.balashevich.shapeappweb.entity.Shape;
import by.balashevich.shapeappweb.exception.ShapeProjectException;

import java.util.List;
import java.util.Optional;

public interface ShapeCreator<T extends Shape> {
    List<T> createShapes(List<List<Double>> shapesData) throws ShapeProjectException;

    Optional<T> createShape(List<Double> shapeData);
}
