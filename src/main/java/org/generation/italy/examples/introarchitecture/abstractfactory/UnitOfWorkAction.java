package org.generation.italy.examples.introarchitecture.abstractfactory;

import org.generation.italy.examples.jdbc.DataException;

@FunctionalInterface
public interface UnitOfWorkAction<T> {
    T execute() throws DataException;
}
