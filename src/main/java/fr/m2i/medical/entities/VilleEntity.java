package fr.m2i.medical.entities;

import javax.persistence.*;

@Entity
@Table(name = "ville", schema = "medical", catalog = "")
public class VilleEntity {
    private int id;
    private String nom;
    private int codePostal;
    private String pays;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 200)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "code_postal", nullable = false)
    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    @Basic
    @Column(name = "pays", nullable = false, length = 50)
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "VilleEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", codePostal=" + codePostal +
                ", pays='" + pays + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VilleEntity that = (VilleEntity) o;

        if (id != that.id) return false;
        if (codePostal != that.codePostal) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (pays != null ? !pays.equals(that.pays) : that.pays != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + codePostal;
        result = 31 * result + (pays != null ? pays.hashCode() : 0);
        return result;
    }

}
