/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Live
 */
@Entity
@Table(name = "rentqueue", catalog = "library", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rentqueue.findAll", query = "SELECT r FROM Rentqueue r"),
    @NamedQuery(name = "Rentqueue.findById", query = "SELECT r FROM Rentqueue r WHERE r.id = :id"),
    @NamedQuery(name = "Rentqueue.findByQueueNr", query = "SELECT r FROM Rentqueue r WHERE r.queueNr = :queueNr")})
public class Rentqueue implements Serializable {
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

    public Rentqueue() {
    }

    public Rentqueue(Integer id) {
        this.id = id;
    }

    public Rentqueue(Integer id, int queueNr) {
        this.id = id;
        this.queueNr = queueNr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQueueNr() {
        return queueNr;
    }

    public void setQueueNr(int queueNr) {
        this.queueNr = queueNr;
    }

    public Book getIsbn() {
        return isbn;
    }

    public void setIsbn(Book isbn) {
        this.isbn = isbn;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Rentqueue)) {
            return false;
        }
        Rentqueue other = (Rentqueue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Rentqueue[ id=" + id + " ]";
    }
    
}
