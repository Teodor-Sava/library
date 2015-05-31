/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Live
 */
@Entity
@Table(name = "shelf", catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shelf.findAll", query = "SELECT s FROM Shelf s"),
    @NamedQuery(name = "Shelf.findById", query = "SELECT s FROM Shelf s WHERE s.id = :id"),
    @NamedQuery(name = "Shelf.findByName", query = "SELECT s FROM Shelf s WHERE s.name = :name"),
    @NamedQuery(name = "Shelf.findByDescription", query = "SELECT s FROM Shelf s WHERE s.description = :description")})
public class Shelf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shelfId")
    private List<Bookshelf> bookshelfList;

    public Shelf() {
    }

    public Shelf(Integer id) {
        this.id = id;
    }

    public Shelf(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Bookshelf> getBookshelfList() {
        return bookshelfList;
    }

    public void setBookshelfList(List<Bookshelf> bookshelfList) {
        this.bookshelfList = bookshelfList;
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
        if (!(object instanceof Shelf)) {
            return false;
        }
        Shelf other = (Shelf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Shelf[ id=" + id + " ]";
    }
    
}
