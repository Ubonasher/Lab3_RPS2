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
@Table(name = "doljnost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doljnost.findAll", query = "SELECT d FROM Doljnost d")
    , @NamedQuery(name = "Doljnost.findById", query = "SELECT d FROM Doljnost d WHERE d.id = :id")
    , @NamedQuery(name = "Doljnost.findByNazvanieDoljnosti", query = "SELECT d FROM Doljnost d WHERE d.nazvanieDoljnosti = :nazvanieDoljnosti")
    , @NamedQuery(name = "Doljnost.findByZarplata", query = "SELECT d FROM Doljnost d WHERE d.zarplata = :zarplata")})
public class Doljnost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nazvanie_doljnosti")
    private String nazvanieDoljnosti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zarplata")
    private int zarplata;
    @OneToMany(mappedBy = "doljnost")
    private Collection<Medrabotnik> medrabotnikCollection;

    public Doljnost() {
    }

    public Doljnost(Integer id) {
        this.id = id;
    }

    public Doljnost(Integer id, String nazvanieDoljnosti, int zarplata) {
        this.id = id;
        this.nazvanieDoljnosti = nazvanieDoljnosti;
        this.zarplata = zarplata;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazvanieDoljnosti() {
        return nazvanieDoljnosti;
    }

    public void setNazvanieDoljnosti(String nazvanieDoljnosti) {
        this.nazvanieDoljnosti = nazvanieDoljnosti;
    }

    public int getZarplata() {
        return zarplata;
    }

    public void setZarplata(int zarplata) {
        this.zarplata = zarplata;
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
        if (!(object instanceof Doljnost)) {
            return false;
        }
        Doljnost other = (Doljnost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Doljnost[ id=" + id + " ]";
    }
    
}
