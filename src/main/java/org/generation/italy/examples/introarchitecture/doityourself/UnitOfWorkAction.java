package org.generation.italy.examples.introarchitecture.doityourself;

import org.generation.italy.examples.jdbc.DataException;

@FunctionalInterface
public interface UnitOfWorkAction<T> {
    T execute() throws DataException;
}
