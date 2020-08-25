package by.balashevich.shapeappweb.repository;

import by.balashevich.shapeappweb.entity.Quadrangle;

import java.util.function.Predicate;

public interface Specification extends Predicate<Quadrangle> {
}
