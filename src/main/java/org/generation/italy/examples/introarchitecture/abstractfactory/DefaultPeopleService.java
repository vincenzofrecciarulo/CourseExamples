package org.generation.italy.examples.introarchitecture.abstractfactory;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.model.tropico.Citizen;

import java.util.List;

public class DefaultPeopleService implements PeopleService {

    private final PeopleRepository peopleRepository;
    private final UnitOfWork unitOfWork;

    public DefaultPeopleService(PeopleRepository peopleRepository,
                                UnitOfWork unitOfWork) {
        this.peopleRepository = peopleRepository;
        this.unitOfWork = unitOfWork;
    }

    @Override
    public List<Citizen> getAllPeople() throws DataException {
        return unitOfWork.execute(() -> peopleRepository.findAll());
    }

    @Override
    public Citizen getPersonById(Integer id) throws DataException {
        return unitOfWork.execute(() -> peopleRepository.findById(id));
    }

    @Override
    public List<Citizen> findPeopleBySexAndEducationLevel(
            char sex, String educationLevel) throws DataException {
        return unitOfWork.execute(() ->
                peopleRepository.findBySexAndEducationLevel(sex, educationLevel));
    }

    @Override
    public Citizen createPerson(Citizen citizen) throws DataException {
        return unitOfWork.executeInTransaction(() -> peopleRepository.create(citizen));
    }

    @Override
    public boolean updatePerson(Citizen citizen) throws DataException {
        return unitOfWork.executeInTransaction(() -> peopleRepository.update(citizen));
    }

    @Override
    public boolean deletePerson(Integer id) throws DataException {
        return unitOfWork.executeInTransaction(() -> peopleRepository.delete(id));
    }
}
