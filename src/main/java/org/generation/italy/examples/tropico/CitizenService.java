package org.generation.italy.examples.tropico;

import org.generation.italy.examples.jdbc.DataException;
import org.generation.italy.examples.jdbc.JDBCCitizenRepository;
import org.generation.italy.examples.model.Citizen;

import java.util.List;
import java.util.Optional;

public class CitizenService {

     JDBCCitizenRepository repo;
     Citizen c;

    public CitizenService(JDBCCitizenRepository repo, Citizen c) {
        this.repo = repo;
        this.c = c;
    }

    public void seeAll() throws DataException {
        List<Citizen> all = repo.findAll();
        if(all.isEmpty()){
            System.out.println("Non ci sono cittadini");
            return;
        }
        all.forEach(System.out::println);
    }

    public void seeCitizenBySexAndEducation(char sex,String EducationLevel) throws DataException {
        List<Citizen> filtered = repo.findBySexAndEducationLevel(sex,EducationLevel);
        if(filtered.isEmpty()){
            System.out.println("Non ci sono cittadini");
            return;
        }
        filtered.forEach(System.out::println);
    }

    public void addCitizen(Citizen c) throws DataException,CitizenAlreadyExists {
        if(repo.findById(c.getId()).isPresent()){
            throw new CitizenAlreadyExists("Il cittaino con Id"+c.getId()+"già esiste");
        }
        repo.createCitizen(c);
    }

    public void deleteCitizenById(int id) throws DataException, CitizenNotFound {
        boolean deleted = repo.deleteCitizen(id);
        if(!deleted){
            throw new CitizenNotFound("Cittadino a "+id+"non trovato");
        }
    }

    public void changeHappinessLevel(int id,int happinessTotal) throws DataException, CitizenNotFound {
      Optional<Citizen> c = repo.findById(id);
      if(c.isPresent()){
        Citizen updated =  c.get();
         updated.setHappinessTotal(happinessTotal);
         repo.updateCitizen(updated);
      }else{
          throw new CitizenNotFound("Cittadino a "+id+"non trovato");
      }


    }

}
