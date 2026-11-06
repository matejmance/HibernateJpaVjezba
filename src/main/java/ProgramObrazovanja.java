

@Entity
@Table(name = "ProgramObrazovanja")
public class ProgramObrazovanja {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProgramObrazovanjaID")
    private int id;


    @Column(name = "Naziv")
    private String naziv;

    @Column(name = "CSVET")
    private int csvet;

    public ProgramObrazovanja() {
    }

    public ProgramObrazovanja(int csvet, String naziv) {
        this.csvet = csvet;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCsvet() {
        return csvet;
    }

    public void setCsvet(int csvet) {
        this.csvet = csvet;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
