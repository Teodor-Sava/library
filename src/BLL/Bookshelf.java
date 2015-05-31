/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Live
 */
@Entity
@Table(name = "bookshelf", catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookshelf.findAll", query = "SELECT b FROM Bookshelf b"),
    @NamedQuery(name = "Bookshelf.findById", query = "SELECT b FROM Bookshelf b WHERE b.id = :id"),
    @NamedQuery(name = "Bookshelf.findByTotalCopies", query = "SELECT b FROM Bookshelf b WHERE b.totalCopies = :totalCopies"),
    @NamedQuery(name = "Bookshelf.findByAvailableCopies", query = "SELECT b FROM Bookshelf b WHERE b.availableCopies = :availableCopies")})
public class Bookshelf implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "totalCopies")
    private int totalCopies;
    @Basic(optional = false)
    @Column(name = "availableCopies")
    private int availableCopies;
    @JoinColumn(name = "shelfId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shelf shelfId;
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")
    @ManyToOne(optional = false)
    private Book isbn;

    public Bookshelf() {
    }

    public Bookshelf(Integer id) {
        this.id = id;
    }

    public Bookshelf(Integer id, int totalCopies, int availableCopies) {
        this.id = id;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        int oldTotalCopies = this.totalCopies;
        this.totalCopies = totalCopies;
        changeSupport.firePropertyChange("totalCopies", oldTotalCopies, totalCopies);
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        int oldAvailableCopies = this.availableCopies;
        this.availableCopies = availableCopies;
        changeSupport.firePropertyChange("availableCopies", oldAvailableCopies, availableCopies);
    }

    public Shelf getShelfId() {
        return shelfId;
    }

    public void setShelfId(Shelf shelfId) {
        Shelf oldShelfId = this.shelfId;
        this.shelfId = shelfId;
        changeSupport.firePropertyChange("shelfId", oldShelfId, shelfId);
    }

    public Book getIsbn() {
        return isbn;
    }

    public void setIsbn(Book isbn) {
        Book oldIsbn = this.isbn;
        this.isbn = isbn;
        changeSupport.firePropertyChange("isbn", oldIsbn, isbn);
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
        if (!(object instanceof Bookshelf)) {
            return false;
        }
        Bookshelf other = (Bookshelf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Bookshelf[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
