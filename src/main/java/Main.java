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

                Knjiga knjiga = new Knjiga("Knjiga1",izdavac1);
                em.persist(knjiga);

                Izdavaci izdavac1 = new Izdavaci("Izdavac1");
                Izdavaci izdavac2 = new Izdavaci("Izdavac2");





            } catch (Exception e) {
                if(transaction.isActive()) transaction.rollback();
                e.printStackTrace();
            }






        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
