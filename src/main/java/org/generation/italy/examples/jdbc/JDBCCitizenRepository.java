package org.generation.italy.examples.jdbc;

// Importiamo tutte le classi del package java.sql che servono per parlare
// con il database: Connection, PreparedStatement, ResultSet, Statement, ecc.
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Questa classe È L'IMPLEMENTAZIONE CONCRETA dell'interfaccia CitizenRepository.
// "implements CitizenRepository" obbliga questa classe a scrivere il CORPO
// di tutti i metodi dichiarati nell'interfaccia (altrimenti non compila).
public class JDBCCitizenRepository implements CitizenRepository {

    // Questa è la connessione al database. È una variabile d'ISTANZA (non
    // static), quindi ogni oggetto JDBCCitizenRepository ha la SUA connessione.
    private Connection con;

    // COSTRUTTORE: quando creiamo un JDBCCitizenRepository, dobbiamo
    // OBBLIGATORIAMENTE passargli una Connection già pronta e aperta.
    // Questo è il pattern "dependency injection": la classe non si crea la
    // connessione da sola, gliela passa qualcun altro (nel nostro caso, il Main).
    public JDBCCitizenRepository(Connection con){
        this.con = con; // salviamo la connessione ricevuta nella variabile della classe
    }

    // ==========================================================
    // QUERY SQL come COSTANTI DI CLASSE (static final)
    // Usiamo le """ (text block, introdotte in Java 15) per scrivere query
    // multi-riga senza dover concatenare stringhe con il +
    // Sono "final" perché non devono più cambiare dopo essere state scritte.
    // ==========================================================

    // Query che prende TUTTI i cittadini, con un LEFT JOIN sulla tabella
    // "faction" per recuperare anche il nome/descrizione della fazione
    // eventualmente supportata (LEFT JOIN = anche se non ha una fazione,
    // il cittadino viene comunque restituito, con i campi faction a NULL)
    private static final String FIND_ALL =
            """
                SELECT c.id as c_id, first_name, last_name, gender, age, education_level,salary, wealth_level,is_rebel, happiness_total, supported_faction_id, f.name, f.description
                FROM citizen as c
                LEFT JOIN faction as f ON c.supported_faction_id = f.id
            """;

    // Query identica alla precedente, ma con un filtro WHERE su due colonne.
    // I "?" sono PLACEHOLDER: verranno sostituiti dopo con i veri valori
    // tramite PreparedStatement (per sicurezza, evita SQL injection).
    private static final String FIND_BY_SEX_AND_EDUCATION =
            """
                SELECT c.id AS c_id, first_name, last_name, gender, age, education_level, salary, wealth_level, is_rebel, 
                       happiness_total, supported_faction_id, f.name, f.description
                FROM citizen AS c
                LEFT JOIN faction AS f ON c.supported_faction_id = f.id
                WHERE gender = ? AND education_level = ?
            """;

    // NUOVA QUERY per findById: stessa struttura di FIND_ALL, ma filtriamo
    // per un id specifico. Restituirà sempre 0 o 1 riga (l'id è la chiave
    // primaria, quindi è unico).
    private static final String FIND_BY_ID =
            """
                SELECT c.id as c_id, first_name, last_name, gender, age, education_level, salary, wealth_level,
                       is_rebel, happiness_total, supported_faction_id, f.name, f.description
                FROM citizen as c
                LEFT JOIN faction as f ON c.supported_faction_id = f.id
                WHERE c.id = ?
            """;

    // Query per eliminare un cittadino dato il suo id.
    private static final String DELETE_CITIZEN =
            """
                 DELETE FROM citizen
                 WHERE id = ?
            """;

    // Query per aggiornare TUTTI i campi di un cittadino esistente.
    // Nota: aggiorna la riga intera, quindi se vuoi cambiare un solo campo
    // (es. la felicità) devi comunque passare l'oggetto Citizen completo,
    // altrimenti rischi di sovrascrivere gli altri campi con valori vuoti.
    private static final String UPDATE_CITIZEN =
            """
                UPDATE citizen
                SET first_name = ?,
                    last_name = ?,
                    gender = ?,
                    age = ?,
                    education_level = ?,
                    salary = ?,
                    wealth_level = ?,
                    is_rebel = ?,
                    happiness_total = ?
                WHERE id = ?
            """;

    // Query per creare un nuovo cittadino. Nota che inseriamo solo 4 campi
    // (first_name, last_name, gender, age): gli altri campi (salary,
    // wealth_level, ecc.) prenderanno i valori di default definiti nel
    // database (o resteranno NULL/0/false).
    private static final String CREATE_CITIZEN =
            """
               INSERT INTO citizen(first_name,last_name,gender,age)
               VALUES (?,?,?,?)
            """;

    // ==========================================================
    // METODI - ognuno con "@Override" perché sta implementando un metodo
    // già dichiarato nell'interfaccia CitizenRepository
    // ==========================================================

    // Recupera TUTTI i cittadini con le loro fazioni (caricamento EAGER:
    // carichiamo subito anche i dati collegati, invece di aspettare che
    // servano davvero come farebbe il caricamento LAZY)
    @Override
    public List<Citizen> findAll() throws DataException {
        // try-with-resources: apre Statement e ResultSet, e li chiude
        // AUTOMATICAMENTE alla fine del blocco try, anche se c'è un errore.
        // Questo evita di dover scrivere finally { st.close(); rs.close(); }
        try(Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(FIND_ALL)){

            // Lista che conterrà tutti i cittadini trovati
            var citizens = new ArrayList<Citizen>();

            // rs.next() sposta il "cursore" alla riga successiva del
            // risultato e restituisce true se esiste una riga, false se
            // siamo arrivati alla fine. Il while quindi scorre riga per riga.
            while(rs.next()){
                // Per ogni riga, leggiamo il valore di ogni colonna
                // specificando il NOME della colonna (più leggibile e
                // sicuro rispetto a usare l'indice numerico)
                int id = rs.getInt("c_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                // gender è salvato come stringa nel DB, ma nella classe
                // Citizen è un char: prendiamo il primo carattere della stringa
                char gender = rs.getString("gender").charAt(0);
                int age = rs.getInt("age");
                String educationLevel = rs.getString("education_level");
                double salary = rs.getDouble("salary");
                String wealthLevel = rs.getString("wealth_level");
                boolean isRebel = rs.getBoolean("is_rebel");
                int happinessTotal = rs.getInt("happiness_total");

                // supported_faction_id può essere NULL nel database (se il
                // cittadino non supporta nessuna fazione). Usiamo getObject
                // con Integer.class invece di getInt perché getInt
                // restituirebbe 0 anche in caso di NULL, e non potremmo
                // distinguere "fazione con id 0" da "nessuna fazione"
                Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
                String name = rs.getString("name");               // nome della fazione (dal JOIN)
                String description = rs.getString("description"); // descrizione della fazione (dal JOIN)

                // Creiamo l'oggetto Citizen con i dati letti finora
                Citizen c = new Citizen(id, firstName, lastName, gender, age, educationLevel, salary, wealthLevel, isRebel,happinessTotal);

                // Solo SE il cittadino ha una fazione (supportedFactionId non
                // è null), creiamo l'oggetto Faction e lo colleghiamo al
                // cittadino
                if(supportedFactionId != null){
                    Faction f = new Faction(supportedFactionId, name, description);
                    c.setFaction(f);
                }

                // Aggiungiamo il cittadino appena creato alla lista dei risultati
                citizens.add(c);
            }
            // Restituiamo la lista completa di tutti i cittadini trovati
            return citizens;

        }catch (SQLException e){
            // Se qualcosa va storto a livello SQL (connessione persa, query
            // scritta male, ecc.), "traduciamo" l'errore tecnico in una
            // nostra eccezione più generica (DataException), che nasconde
            // i dettagli implementativi di JDBC al resto dell'applicazione
            throw new DataException(e.getMessage(), e);
        }
    }

    // Recupera i cittadini filtrati per sesso e livello di educazione
    @Override
    public List<Citizen> findBySexAndEducationLevel(char sex, String educationLevel) throws DataException {
        // PreparedStatement invece di Statement perché la nostra query ha
        // dei "?" da riempire con valori variabili (parametri del metodo)
        try (PreparedStatement ps = con.prepareStatement(FIND_BY_SEX_AND_EDUCATION)) {

            // Impostiamo i valori dei "?" nella query, in ordine di
            // posizione (1 = primo ?, 2 = secondo ?)
            ps.setString(1, String.valueOf(sex));  // convertiamo il char in String
            ps.setString(2, educationLevel);

            // Eseguiamo la query e otteniamo il risultato
            try (ResultSet rs = ps.executeQuery()) {

                List<Citizen> citizens = new ArrayList<>();

                // Stesso ciclo di lettura riga-per-riga visto in findAll()
                while (rs.next()) {
                    int id = rs.getInt("c_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    char gender = rs.getString("gender").charAt(0);
                    int age = rs.getInt("age");
                    String education = rs.getString("education_level");
                    double salary = rs.getDouble("salary");
                    String wealthLevel = rs.getString("wealth_level");
                    boolean isRebel = rs.getBoolean("is_rebel");
                    int happinessTotal = rs.getInt("happiness_total");

                    Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
                    String name = rs.getString("name");
                    String description = rs.getString("description");

                    Citizen c = new Citizen(
                            id,
                            firstName,
                            lastName,
                            gender,
                            age,
                            education,
                            salary,
                            wealthLevel,
                            isRebel,
                            happinessTotal
                    );

                    if (supportedFactionId != null) {
                        Faction f = new Faction(supportedFactionId, name, description);
                        c.setFaction(f);
                    }

                    citizens.add(c);
                }

                return citizens;
            }

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    // ==========================================================
    // NUOVO METODO: findById
    // Recupera UN SOLO cittadino dato il suo id, oppure null se non esiste
    // ==========================================================
    @Override
    public Citizen findById(int citizenId) throws DataException {
        try (PreparedStatement ps = con.prepareStatement(FIND_BY_ID)) {

            // Sostituiamo il "?" della query con l'id passato come parametro
            ps.setInt(1, citizenId);

            try (ResultSet rs = ps.executeQuery()) {

                // rs.next() qui viene chiamato UNA SOLA VOLTA (non in un
                // while) perché ci aspettiamo AL MASSIMO una riga di
                // risultato (l'id è la chiave primaria, quindi unico).
                // Se rs.next() restituisce false, significa che non esiste
                // nessun cittadino con quell'id.
                if (!rs.next()) {
                    return null; // nessun cittadino trovato: restituiamo null
                }

                // Se siamo qui, rs.next() ha restituito true: leggiamo i
                // dati della riga trovata, esattamente come negli altri metodi
                int id = rs.getInt("c_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                char gender = rs.getString("gender").charAt(0);
                int age = rs.getInt("age");
                String educationLevel = rs.getString("education_level");
                double salary = rs.getDouble("salary");
                String wealthLevel = rs.getString("wealth_level");
                boolean isRebel = rs.getBoolean("is_rebel");
                int happinessTotal = rs.getInt("happiness_total");
                Integer supportedFactionId = rs.getObject("supported_faction_id", Integer.class);
                String name = rs.getString("name");
                String description = rs.getString("description");

                // Costruiamo l'oggetto Citizen con i dati letti
                Citizen c = new Citizen(id, firstName, lastName, gender, age, educationLevel,
                        salary, wealthLevel, isRebel, happinessTotal);

                // Se il cittadino ha una fazione, la aggiungiamo all'oggetto
                if (supportedFactionId != null) {
                    c.setFaction(new Faction(supportedFactionId, name, description));
                }

                // Restituiamo il cittadino trovato (con o senza fazione)
                return c;
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    // Aggiorna TUTTI i campi di un cittadino già esistente, identificato dal
    // suo id (citizen.getId())
    @Override
    public boolean updateCitizen(Citizen citizen) throws DataException {
        try(PreparedStatement ps = con.prepareStatement(UPDATE_CITIZEN)){
            // Impostiamo, uno per uno, i valori dei "?" della query UPDATE,
            // leggendoli dall'oggetto Citizen passato come parametro.
            // L'ORDINE deve corrispondere ESATTAMENTE all'ordine dei "?"
            // nella stringa UPDATE_CITIZEN definita più sopra.
            ps.setString(1, citizen.getFirstName());
            ps.setString(2, citizen.getLastName());
            ps.setString(3, String.valueOf(citizen.getGender()));
            ps.setInt(4, citizen.getAge());
            ps.setString(5, citizen.getEducationLevel());
            ps.setDouble(6,citizen.getSalary());
            ps.setString(7,citizen.getWealthLevel());
            ps.setBoolean(8, citizen.isRebel());
            ps.setInt(9,citizen.getHappinessTotal());
            ps.setInt(10,citizen.getId());  // questo è il valore usato nella clausola WHERE id = ?

            // executeUpdate() esegue l'INSERT/UPDATE/DELETE e restituisce
            // il NUMERO DI RIGHE modificate. Se è esattamente 1, significa
            // che l'update è andato a buon fine su una sola riga (quella
            // con l'id giusto). Il confronto "== 1" produce direttamente
            // un boolean, che è il valore di ritorno richiesto dal metodo.
            return ps.executeUpdate() == 1;

        }catch(SQLException e){
            throw new DataException(e.getMessage(),e);
        }

    }

    // Elimina il cittadino con l'id passato come parametro
    @Override
    public boolean deleteCitizen(int citizenId) throws DataException {
        try(PreparedStatement ps = con.prepareStatement(DELETE_CITIZEN)){
            ps.setInt(1,citizenId); // sostituiamo il "?" con l'id da eliminare

            // Come sopra: se è stata eliminata esattamente 1 riga, restituiamo true
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }

    }

    // Crea un nuovo cittadino nel database e restituisce l'oggetto con l'id
    // generato automaticamente dal database (auto-increment)
    @Override
    public Citizen createCitizen(Citizen newCitizen) throws DataException {
        // Statement.RETURN_GENERATED_KEYS dice al driver JDBC: "dopo aver
        // eseguito l'INSERT, tienimi pronta anche la chiave (id) che il
        // database ha generato automaticamente, così posso recuperarla"
        try (PreparedStatement ps = con.prepareStatement(CREATE_CITIZEN , Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, newCitizen.getFirstName());
            ps.setString(2, newCitizen.getLastName());
            ps.setString(3, String.valueOf(newCitizen.getGender()));
            ps.setInt(4, newCitizen.getAge());

            // Eseguiamo l'INSERT. A differenza di executeQuery (per SELECT),
            // qui usiamo executeUpdate perché stiamo modificando dati, non leggendoli
            ps.executeUpdate();

            // Recuperiamo la chiave generata automaticamente dal database
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    // getInt(1) legge la prima (e unica) colonna del
                    // risultato, che contiene l'id appena generato
                    int generatedId = rs.getInt(1);
                    // Impostiamo l'id generato sull'oggetto che avevamo
                    // ricevuto come parametro, così anche chi ha chiamato
                    // questo metodo saprà qual è l'id del nuovo cittadino
                    newCitizen.setId(generatedId);

                }
                // Restituiamo l'oggetto newCitizen, ora completo anche di id
                return newCitizen;
            }

        } catch (SQLException e){
            throw new DataException(e.getMessage(),e);
        }

    }

    // Metodo di test/debug: apre una NUOVA connessione (diversa da "con")
    // solo per verificare che la configurazione di ConnectionFactory sia
    // corretta. Nota il try-with-resources: la connessione di test viene
    // chiusa subito dopo l'apertura, dato che non viene usata per fare nulla.
    @Override
    public void test() throws DataException {
        try(Connection con = ConnectionFactory.getConnection()){
            // corpo vuoto: l'obiettivo è solo verificare che getConnection()
            // non lanci eccezioni, cioè che i parametri di connessione siano giusti
        }catch (SQLException e){
            throw new DataException(e.getMessage(), e);
        }
    }
}