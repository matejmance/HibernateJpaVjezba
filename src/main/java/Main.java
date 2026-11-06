import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("algebraPU");
            EntityManager em = emf.createEntityManager();
            ){
            System.out.println("Hibernate uspjesno pokrenut!");

            EntityTransaction transaction = em.getTransaction();

            try {
                transaction.begin();

                ProgramObrazovanja program1 = new ProgramObrazovanja("Java Backend", 20);

                em.persist(program1);
                transaction.commit();
                int id = program1.getId();
                System.out.println("Generalni ID : " + id);

                em.clear();


                ProgramObrazovanja program2 = em.find(ProgramObrazovanja.class, id);


                System.out.println("Id : " + program2.getId());
                System.out.println("Naziv : " + program2.getNaziv());
                System.out.println(("CSVET :  " + program2.getCsvet()));
                em.clear();

                ProgramObrazovanja program3 = em.find(ProgramObrazovanja.class, 9999);
                if(program3 == null){
                    System.out.println("Entitet ne postoji");
                }

                em.clear();
                transaction.begin();
                ProgramObrazovanja program4 = em.find(ProgramObrazovanja.class, id);
                program4.setNaziv("Napredna Java Backend");
                program4.setCsvet(25);
                transaction.commit();
                em.clear();


                program2 = em.find(ProgramObrazovanja.class, id);


                System.out.println("Id : " + program2.getId());
                System.out.println("Naziv : " + program2.getNaziv());
                System.out.println(("CSVET :  " + program2.getCsvet()));
                em.clear();

                program2 = em.find(ProgramObrazovanja.class, 1);
                em.clear();

                program2.setNaziv("Spring Boot Backend");

                transaction.begin();

                ProgramObrazovanja managed = em.merge(program2);

                transaction.commit();
                em.clear();

                program2 = em.find(ProgramObrazovanja.class, id);


                System.out.println("Id : " + program2.getId());
                System.out.println("Naziv : " + program2.getNaziv());
                System.out.println(("CSVET :  " + program2.getCsvet()));
                em.clear();

                program2 = em.find(ProgramObrazovanja.class, id);
                transaction.begin();
                em.remove(program2);
                transaction.commit();
                em.clear();

                program2 = em.find(ProgramObrazovanja.class, id);


                if(program2 == null){
                    System.out.println("em.find() VRAĆA NULL");
                }




            } catch (Exception e) {
                if(transaction.isActive()) transaction.rollback();
                e.printStackTrace();
            }






        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
