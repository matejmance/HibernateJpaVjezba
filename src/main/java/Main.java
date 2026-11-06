import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("algebraPU")){
            System.out.println("Hibernate uspjesno pokrenut!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
