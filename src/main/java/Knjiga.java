import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Knjiga")
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KnjigaID")
    private Integer id;

    @Column(name = "Naziv")
    private String Naziv;

    @ManyToMany
    @JoinTable(
            name = "Knjiga_Izdavac",
            joinColumns = @JoinColumn(name = "KnjigaID"),
            inverseJoinColumns = @JoinColumn(name = "IzdavacID")
    )
    private Set<Izdavaci> izdavaci =  new HashSet<Izdavaci>();

    public Knjiga() {
    }

    public Knjiga(String naziv, Set<Izdavaci> izdavaci) {
        Naziv = naziv;
        this.izdavaci = izdavaci;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public Set<Izdavaci> getIzdavaci() {
        return izdavaci;
    }

    public void setIzdavaci(Set<Izdavaci> izdavaci) {
        this.izdavaci = izdavaci;
    }
}
