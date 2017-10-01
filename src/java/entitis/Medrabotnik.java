/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Григорий
 */
@Entity
@Table(name = "medrabotnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medrabotnik.findAll", query = "SELECT m FROM Medrabotnik m")
    , @NamedQuery(name = "Medrabotnik.findById", query = "SELECT m FROM Medrabotnik m WHERE m.id = :id")
    , @NamedQuery(name = "Medrabotnik.findByNadbavkaKZarplate", query = "SELECT m FROM Medrabotnik m WHERE m.nadbavkaKZarplate = :nadbavkaKZarplate")
    , @NamedQuery(name = "Medrabotnik.findByDatarojdenia", query = "SELECT m FROM Medrabotnik m WHERE m.datarojdenia = :datarojdenia")
    , @NamedQuery(name = "Medrabotnik.findByFio", query = "SELECT m FROM Medrabotnik m WHERE m.fio = :fio")})
public class Medrabotnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nadbavka_k_zarplate")
    private int nadbavkaKZarplate;
    @Column(name = "Data_rojdenia")
    @Temporal(TemporalType.DATE)
    private Date datarojdenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FIO")
    private String fio;
    @JoinColumn(name = "otdelenie", referencedColumnName = "Id")
    @ManyToOne
    private Otdelenie otdelenie;
    @JoinColumn(name = "doljnost", referencedColumnName = "Id")
    @ManyToOne
    private Doljnost doljnost;

    public Medrabotnik() {
    }

    public Medrabotnik(Integer id) {
        this.id = id;
    }

    public Medrabotnik(String name) {
        this.id = null;
        this.fio = name;
    }

    public Medrabotnik(Integer id, int nadbavkaKZarplate, String fio) {
        this.id = id;
        this.nadbavkaKZarplate = nadbavkaKZarplate;
        this.fio = fio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNadbavkaKZarplate() {
        return nadbavkaKZarplate;
    }

    public void setNadbavkaKZarplate(int nadbavkaKZarplate) {
        this.nadbavkaKZarplate = nadbavkaKZarplate;
    }

    public Date getDatarojdenia() {
        return datarojdenia;
    }

    public void setDatarojdenia(Date datarojdenia) {
        this.datarojdenia = datarojdenia;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Otdelenie getOtdelenie() {
        return otdelenie;
    }

    public void setOtdelenie(Otdelenie otdelenie) {
        this.otdelenie = otdelenie;
    }

    public Doljnost getDoljnost() {
        return doljnost;
    }

    public void setDoljnost(Doljnost doljnost) {
        this.doljnost = doljnost;
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
        if (!(object instanceof Medrabotnik)) {
            return false;
        }
        Medrabotnik other = (Medrabotnik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Medrabotnik[ id=" + id + " ]";
    }

}
