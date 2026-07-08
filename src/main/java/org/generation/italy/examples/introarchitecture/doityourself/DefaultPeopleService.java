package org.generation.italy.examples.introarchitecture.doityourself;

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
    // così facendo il servizio non sa con quale implementazione stia lavorando

    // "inversione delle dipendenze", questa app sta facendo due cose Injection e inversion
    // il pattern "inversione delle dipendenze" è l'ultimo dei pattern solid-->
    // soluzione: sostituire eventuali dipendenze con una dipendenza doppia a una interfaccia intermedia
    // interfaccia: vuol dire che sta in mezzo a due strati
    // la classe superiore non deve istanziare direttamente la sua dipendenza, quindi soluzione: iniettare dipendenza
    // un altro trucco: i factory pattern come per jdbc
    // vedremo poi che spring sa fare:
    // - constructor injection;
    // - setter injection (un metodo setter passa la dipendenza).
    // - iniettare sul campo/field (field injection)
    //
    // Inversione del controllo ("IoC") del servizio rispetto al repository
    // prima quindi il controllo lo aveva il servizio e poi l'ha preso spring

    @Override
    public List<Citizen> getAllPeople() throws DataException {
        return unitOfWork.execute(() -> peopleRepository.findAll()); // "Command" pattern (da studiare come esercizio)
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
