package by.balashevich.shapeappweb.repository.impl;

import by.balashevich.shapeappweb.entity.Quadrangle;
import by.balashevich.shapeappweb.repository.Specification;

public class QuadrangleIdSpecification implements Specification {
    private long quadrangleId;

    public QuadrangleIdSpecification (long quadrangleId){
        this.quadrangleId = quadrangleId;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        return quadrangleId == quadrangle.getId();
    }
}
