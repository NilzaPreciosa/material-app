/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.model.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nilza.graca
 */
@Entity
@Table(name = "armazem_item")
@XmlRootElement
/*
@NamedQueries({
    @NamedQuery(name = "ArmazemItem.findAll", query = "SELECT a FROM ArmazemItem a")
    , @NamedQuery(name = "ArmazemItem.findById", query = "SELECT a FROM ArmazemItem a WHERE a.id = :id")
    , @NamedQuery(name = "ArmazemItem.findByCodigo", query = "SELECT a FROM ArmazemItem a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "ArmazemItem.findByDataEntrada", query = "SELECT a FROM ArmazemItem a WHERE a.dataEntrada = :dataEntrada")
    , @NamedQuery(name = "ArmazemItem.findByDataLeilao", query = "SELECT a FROM ArmazemItem a WHERE a.dataLeilao = :dataLeilao")
    , @NamedQuery(name = "ArmazemItem.findByStatus", query = "SELECT a FROM ArmazemItem a WHERE a.status = :status")})
*/
public class ArmazemItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "dataEntrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrada;
    @Basic(optional = true)
    @Column(name = "dataLeilao", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLeilao;
    @Column(name = "status")
    private String status;
    
    @JoinColumn(name = "material_id", referencedColumnName = "id")  
    @OneToOne(targetEntity = Material.class)
    private Material materialId;

    public ArmazemItem() {
    }

    public ArmazemItem(Integer id) {
        this.id = id;
    }
    
    public ArmazemItem(Integer id, Date dataEntrada) {
        this.id = id;
        this.dataEntrada = dataEntrada;
    }
    
    public ArmazemItem(Integer id, Date dataEntrada, Date dataLeilao) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataLeilao = dataLeilao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataLeilao() {
        return dataLeilao;
    }

    public void setDataLeilao(Date dataLeilao) {
        this.dataLeilao = dataLeilao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Material getMaterial() {
        return materialId;
    }

    public void setMaterial(Material materialId) {
        this.materialId = materialId;
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
        if (!(object instanceof ArmazemItem)) {
            return false;
        }
        ArmazemItem other = (ArmazemItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mz.nilzaproject.cedsif.model.db.ArmazemItem[ id=" + id + " ]";
    }
    
}
