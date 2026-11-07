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

                Polaznik polaznik = new Polaznik("Matej","Mance");
                em.persist(polaznik);

                ProgramObrazovanja program = new ProgramObrazovanja("Java Backend",20);
                em.persist(program);

                Upis upis = new Upis(program,polaznik);
                em.persist(upis);



                transaction.commit();





            } catch (Exception e) {
                if(transaction.isActive()) transaction.rollback();
                e.printStackTrace();
            }






        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
