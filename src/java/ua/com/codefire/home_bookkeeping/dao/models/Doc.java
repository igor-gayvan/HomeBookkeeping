/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.home_bookkeeping.dao.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Igor Gayvan
 */
@Entity
@Table(name = "doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doc.findAll", query = "SELECT d FROM Doc d ORDER BY d.dateRec DESC"),
    @NamedQuery(name = "Doc.findByDocId", query = "SELECT d FROM Doc d WHERE d.docId = :docId"),
    @NamedQuery(name = "Doc.findByDocAmount", query = "SELECT d FROM Doc d WHERE d.docAmount = :docAmount ORDER BY d.dateRec DESC"),
    @NamedQuery(name = "Doc.findByDocDate", query = "SELECT d FROM Doc d WHERE d.docDate = :docDate ORDER BY d.dateRec DESC"),
    @NamedQuery(name = "Doc.findByDocNote", query = "SELECT d FROM Doc d WHERE d.docNote LIKE :docNote ORDER BY d.dateRec DESC"),
    @NamedQuery(name = "Doc.findByIsIncome", query = "SELECT d FROM Doc d WHERE d.isIncome = :isIncome ORDER BY d.dateRec DESC")})
public class Doc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doc_id")
    private Integer docId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "doc_amount")
    private BigDecimal docAmount;
    @Basic(optional = false)
    @Column(name = "doc_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docDate;
    @Column(name = "doc_note")
    private String docNote;
    @Basic(optional = false)
    @Column(name = "is_income")
    private boolean isIncome;
    @Column(name = "date_rec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRec;

    public Doc() {
    }

    public Doc(BigDecimal docAmount, Date docDate, String docNote, boolean isIncome) {
        this.docAmount = docAmount;
        this.docDate = docDate;
        this.docNote = docNote;
        this.isIncome = isIncome;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public BigDecimal getDocAmount() {
        return docAmount;
    }

    public void setDocAmount(BigDecimal docAmount) {
        this.docAmount = docAmount;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocNote() {
        return docNote;
    }

    public void setDocNote(String docNote) {
        this.docNote = docNote;
    }

    public boolean getIsIncome() {
        return isIncome;
    }

    public void setIsIncome(boolean isIncome) {
        this.isIncome = isIncome;
    }

    public Date getDateRec() {
        return dateRec;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.docId);
        hash = 89 * hash + Objects.hashCode(this.docAmount);
        hash = 89 * hash + Objects.hashCode(this.docDate);
        hash = 89 * hash + Objects.hashCode(this.docNote);
        hash = 89 * hash + (this.isIncome ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doc other = (Doc) obj;
        if (this.isIncome != other.isIncome) {
            return false;
        }
        if (!Objects.equals(this.docNote, other.docNote)) {
            return false;
        }
        if (!Objects.equals(this.docId, other.docId)) {
            return false;
        }
        if (!Objects.equals(this.docAmount, other.docAmount)) {
            return false;
        }
        if (!Objects.equals(this.docDate, other.docDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Doc{" + "docId=" + docId + ", docAmount=" + docAmount + ", docDate=" + docDate + ", docNote=" + docNote + ", isIncome=" + isIncome + ", dateRec=" + dateRec + '}';
    }

}
