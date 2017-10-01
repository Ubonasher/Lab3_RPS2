/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitis;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Григорий
 */
@Entity
@Table(name = "otdelenie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otdelenie.findAll", query = "SELECT o FROM Otdelenie o")
    , @NamedQuery(name = "Otdelenie.findById", query = "SELECT o FROM Otdelenie o WHERE o.id = :id")
    , @NamedQuery(name = "Otdelenie.findByKolichstvoMest", query = "SELECT o FROM Otdelenie o WHERE o.kolichstvoMest = :kolichstvoMest")
    , @NamedQuery(name = "Otdelenie.findByNazvanieOtdelenia", query = "SELECT o FROM Otdelenie o WHERE o.nazvanieOtdelenia = :nazvanieOtdelenia")})
public class Otdelenie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolichstvo_mest")
    private int kolichstvoMest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nazvanie_otdelenia")
    private String nazvanieOtdelenia;
    @OneToMany(mappedBy = "otdelenie")
    private Collection<Medrabotnik> medrabotnikCollection;

    public Otdelenie() {
    }

    public Otdelenie(Integer id) {
        this.id = id;
    }

    public Otdelenie(Integer id, int kolichstvoMest, String nazvanieOtdelenia) {
        this.id = id;
        this.kolichstvoMest = kolichstvoMest;
        this.nazvanieOtdelenia = nazvanieOtdelenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKolichstvoMest() {
        return kolichstvoMest;
    }

    public void setKolichstvoMest(int kolichstvoMest) {
        this.kolichstvoMest = kolichstvoMest;
    }

    public String getNazvanieOtdelenia() {
        return nazvanieOtdelenia;
    }

    public void setNazvanieOtdelenia(String nazvanieOtdelenia) {
        this.nazvanieOtdelenia = nazvanieOtdelenia;
    }

    @XmlTransient
    public Collection<Medrabotnik> getMedrabotnikCollection() {
        return medrabotnikCollection;
    }

    public void setMedrabotnikCollection(Collection<Medrabotnik> medrabotnikCollection) {
        this.medrabotnikCollection = medrabotnikCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otdelenie)) {
            return false;
        }
        Otdelenie other = (Otdelenie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Otdelenie[ id=" + id + " ]";
    }
    
}
