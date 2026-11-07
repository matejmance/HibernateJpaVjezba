import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Izdavaci")
public class Izdavaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IzvdavacID")
    private Integer id;

    @Column(name = "Naziv")
    private String Naziv;

    @ManyToMany(mappedBy = "izdavaci")
    private Set<Knjiga> knjige =  new HashSet<Knjiga>();

    public Izdavaci() {
    }

    public Izdavaci(String naziv, Set<Knjiga> knjige) {
        Naziv = naziv;
        this.knjige = knjige;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(Set<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }
}
