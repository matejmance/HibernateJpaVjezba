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

                transaction.begin();
                ProgramObrazovanja program2 = em.find(ProgramObrazovanja.class, id);
                transaction.commit();

                System.out.println("Id : " + program2.getId());
                System.out.println("Naziv : " + program2.getNaziv());
                System.out.println(("CSVET :  " + program2.getCsvet()));
                em.clear();


            } catch (Exception e) {
                if(transaction.isActive()) transaction.rollback();
                e.printStackTrace();
            }






        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
