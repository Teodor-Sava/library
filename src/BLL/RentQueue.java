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
@Table(name = "rentqueue", catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RentQueue.findAll", query = "SELECT r FROM RentQueue r"),
    @NamedQuery(name = "RentQueue.findById", query = "SELECT r FROM RentQueue r WHERE r.id = :id"),
    @NamedQuery(name = "RentQueue.findByQueueNr", query = "SELECT r FROM RentQueue r WHERE r.queueNr = :queueNr")})
public class RentQueue implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "queueNr")
    private int queueNr;
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")
    @ManyToOne(optional = false)
    private Book isbn;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public RentQueue() {
    }

    public RentQueue(Integer id) {
        this.id = id;
    }

    public RentQueue(Integer id, int queueNr) {
        this.id = id;
        this.queueNr = queueNr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getQueueNr() {
        return queueNr;
    }

    public void setQueueNr(int queueNr) {
        int oldQueueNr = this.queueNr;
        this.queueNr = queueNr;
        changeSupport.firePropertyChange("queueNr", oldQueueNr, queueNr);
    }

    public Book getIsbn() {
        return isbn;
    }

    public void setIsbn(Book isbn) {
        Book oldIsbn = this.isbn;
        this.isbn = isbn;
        changeSupport.firePropertyChange("isbn", oldIsbn, isbn);
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        User oldUserId = this.userId;
        this.userId = userId;
        changeSupport.firePropertyChange("userId", oldUserId, userId);
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
        if (!(object instanceof RentQueue)) {
            return false;
        }
        RentQueue other = (RentQueue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.RentQueue[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
