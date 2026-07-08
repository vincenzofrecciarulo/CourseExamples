package org.generation.italy.examples.introarchitecture.doityourself;

import org.generation.italy.examples.jdbc.DataException;

public interface UnitOfWork {
    <T> T execute(UnitOfWorkAction<T> action) throws DataException;
    <T> T executeInTransaction(UnitOfWorkAction<T> action) throws DataException;
}
