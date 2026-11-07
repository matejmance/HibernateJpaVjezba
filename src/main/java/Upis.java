import jakarta.persistence.*;

@Entity
@Table(name = "Upis")
public class Upis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UpisID")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "ProgramObrazovanjaID")
    private ProgramObrazovanja programObrazovanja;

    @ManyToOne
    @JoinColumn(name = "PolaznikID")
    private Polaznik polaznik;

    public Upis() {
    }

    public Upis(ProgramObrazovanja programObrazovanja, Polaznik polaznik) {
        this.programObrazovanja = programObrazovanja;
        this.polaznik = polaznik;
    }

    public ProgramObrazovanja getProgramObrazovanja() {
        return programObrazovanja;
    }

    public void setProgramObrazovanja(ProgramObrazovanja programObrazovanja) {
        this.programObrazovanja = programObrazovanja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
