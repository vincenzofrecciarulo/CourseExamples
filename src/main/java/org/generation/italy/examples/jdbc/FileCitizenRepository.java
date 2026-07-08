package org.generation.italy.examples.jdbc;



import org.generation.italy.examples.model.tropico.Citizen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// questa è l'implementazione di citizen repository che mantiene i dati su un file in formato CSV (Comma-Separated-Values)

// csv -> tabella -> header(id, firstName..) - dati

public class FileCitizenRepository implements CitizenRepository{
    private FileReader source;
    private FileWriter destination;
    private Path path;

    public FileCitizenRepository(Path path) throws DataException {
        this.path =path;
        try {
            this.source = new FileReader(path.toFile());
            this.destination = new FileWriter(path.toFile());
        }catch (IOException e){
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public List<Citizen> findAll() throws DataException {
        List<Citizen> citizens = new ArrayList<>();
         try(BufferedReader br = new BufferedReader(source)){
             br.readLine();
             String line = null;
             while((line = br.readLine()) != null){
                 String[] values = line.split(",");
                 int id = Integer.parseInt(values[0]);
                 String firstName = values[1];
                 String lastName = values[2];
                 char gender = values[3].charAt(0);
                 int age = Integer.parseInt(values[4]);
                 String level = values[5];
                 Citizen citizen = new Citizen(id,firstName,lastName,gender,age,level);
                 citizens.add(citizen);
             }

         } catch(IOException e){
             throw new DataException(e.getMessage(),e);
         }
         return citizens;
    }

    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        List<Citizen> citizens = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(source)){
            br.readLine();
            String line = null;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                char gender = values[3].charAt(0);
                int age = Integer.parseInt(values[4]);
                String level = values[5];
                if( gender == sex && level.equals(educationLevel)){
                    Citizen citizen = new Citizen(id,firstName,lastName,gender,age,level);
                    citizens.add(citizen);
                }

            }
            return citizens;

        } catch (IOException e){
            throw new DataException(e.getMessage(),e);
        }

    }

    @Override
    public Citizen findById(int citizenId) throws DataException {
        return null;
    }

    public List<Citizen> findBySexAndEducationLevel2 (char sex, String educationLevel) throws DataException { //stesso metodo di prima ma con lambda e stream, il risultato è lo stesso.
        List<Citizen> citizens = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(source)){
            Stream<String> ss = br.lines();
            return ss.skip(1)
                     .map(s -> s.split(","))
                     .filter(as -> as[3].charAt(0) == sex && as[5].equals(educationLevel))
                     .map( as -> new Citizen(Integer.parseInt(as[0]), as[1], as[2], as[3].charAt(0),
                                    Integer.parseInt(as[4]), as[5])).toList();

        } catch (IOException e){
            throw new DataException(e.getMessage(),e);
        }

    }

    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {

        List<Citizen> citizens = findAll();

        // qui scorro tutta la lista dei cittadini, uno per uno, usando l’indice i
        // cioè è il for classico
        // potevamo anche usare un for each: for(Citizen citizen:citizens)
        for (int i = 0; i < citizens.size(); i++) {

            // ora prendo il cittadino nella posizione i (in particolare prendo il suo id)
            // e confronto il suo id con quello del cittadino nuovo che sta in input
            // cioè in sostanza sto cercando il citizen giusto da aggiornare?
            if (citizens.get(i).getId() == citizen.getId()) {

                // ora sostituiamo nella lista
                // quindi il ora alla posizione i, metti il nuovo
                // vado a impostare che sia proprio quello
                citizens.set(i, citizen);

                // ora cancello e riscrivo il CSV da zero
                // riscriamo da zero solo quella riga o proprio tutto il file?
                // FileWriter → apre il file in scrittura (e lo svuota)
                // BufferedWriter → scrive il file in modo efficiente
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("citizens.csv"))) {

                    // scriviamo la prima riga del CSV
                    // riscriviamo l'header
                    bw.write("id,firstName,lastName,sex,educationLevel");
                    bw.newLine(); // per andare a capo

                    // per ogni cittadino nella lista, riscrivilo nel file
                    for (Citizen c : citizens) {

                        bw.write(
                                c.getId() + "," +
                                        c.getFirstName() + "," +
                                        c.getLastName() + "," +
                                        c.getGender() + "," +
                                        c.getEducationLevel()
                        );

                        bw.newLine(); // qui andiamo a capo per scrivere il prossimo cittadino
                    }

                } catch (IOException e) {
                    throw new DataException(e.getMessage(), e);
                }

                return true;
            }
        }

        return false;
    }


    public boolean updateCitizen2(Citizen citizen) throws DataException {
        List<Citizen> citizens = findAll();
        Optional<Citizen> oc = citizens.stream()
                                       .filter(c->c.getId() == citizen.getId())
                                       .findFirst();

        if(oc.isEmpty()){
            return false;
        }
        Citizen toUpdate = oc.get(); //tiro fuori il cittadino con quell'id e quindi che devo updatare
        toUpdate.merge(citizen);
        try {
            saveAll(citizens);
            return true;
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }

    }

    private void saveAll(List<Citizen> citizens) throws IOException {
        List <String> sc = citizens.stream().map(this::toCsvString).toList();
        Files.write(path,sc);

    }




    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        return false;
    }

    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        return null;
    }

    public String toCsvString (Citizen c){
        String riga = String.format("%d,%s,%s,%s,%d,%f,%s"
                , c.getId(),
                c.getFirstName(),
                c.getLastName(),
                c.getGender(),
                c.getAge(),
                c.getSalary(),
                c.getEducationLevel());
                return riga;

    }


}
