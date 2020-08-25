package by.balashevich.shapeappweb.service;

public interface ShapeService<T> {
    double calculateArea(T shape);

    double calculatePerimeter(T shape);
}
