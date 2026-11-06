

@Entity
@Table(name = "ProgramObrazovanja")
public class ProgramObrazovanja {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @column(name = "Naziv")
    private String naziv;

    @column(name = "CSVET")
    private int csvet;

    public ProgramObrazovanja() {
    }

    public ProgramObrazovanja(int csvet, String naziv) {
        this.csvet = csvet;
        this.naziv = naziv;
    }

    public int getProgramObrazovanjaID() {
        return ProgramObrazovanjaID;
    }

    public void setProgramObrazovanjaID(int programObrazovanjaID) {
        ProgramObrazovanjaID = programObrazovanjaID;
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
