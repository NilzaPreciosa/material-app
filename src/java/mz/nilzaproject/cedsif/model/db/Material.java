/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.model.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nilza.graca
 */
@Entity
@Table(name = "material")
@XmlRootElement
/*
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findById", query = "SELECT m FROM Material m WHERE m.id = :id")
    , @NamedQuery(name = "Material.findByTipo", query = "SELECT m FROM Material m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Material.findByMarca", query = "SELECT m FROM Material m WHERE m.marca = :marca")
    , @NamedQuery(name = "Material.findByReferencia", query = "SELECT m FROM Material m WHERE m.referencia = :referencia")
    , @NamedQuery(name = "Material.findByProcessador", query = "SELECT m FROM Material m WHERE m.processador = :processador")
    , @NamedQuery(name = "Material.findBySerialNumber", query = "SELECT m FROM Material m WHERE m.serialNumber = :serialNumber")
    , @NamedQuery(name = "Material.findByAnoFabrico", query = "SELECT m FROM Material m WHERE m.anoFabrico = :anoFabrico")
    , @NamedQuery(name = "Material.findByIdade", query = "SELECT m FROM Material m WHERE m.idade = :idade")})
*/
public class Material implements Serializable {

    /*
    @ManyToMany(mappedBy = "materialList",targetEntity = Usuario.class)
    private List<Usuario> usuarioList;
    */
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "processador")
    private String processador;
    @Column(name = "serialNumber")
    private String serialNumber;
    @Column(name = "anoFabrico")
    private Integer anoFabrico;
    @Column(name = "idade")
    private Integer idade;
    
    /*
    @OneToMany(mappedBy = "materialId")
    private List<ArmazemItem> armazemItemList = new ArrayList<>();
    */

    public Material(Integer id) {
        this.id = id;
    }

    
    public Material(Integer id,String tipo, String marca, String referencia, String processador, String serialNumber, Integer anoFabrico, Integer idade) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.referencia = referencia;
        this.processador = processador;
        this.serialNumber = serialNumber;
        this.anoFabrico = anoFabrico;
        this.idade = idade;
    }

    public Material() {
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getAnoFabrico() {
        return anoFabrico;
    }

    public void setAnoFabrico(Integer anoFabrico) {
        this.anoFabrico = anoFabrico;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /*
    @XmlTransient
    public List<ArmazemItem> getArmazemItemList() {
        return armazemItemList;
    }

    public void setArmazemItemList(List<ArmazemItem> armazemItemList) {
        this.armazemItemList = armazemItemList;
    }
    */
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mz.nilzaproject.cedsif.model.db.Material[ id=" + id + " ]";
    }

    /*
    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    */
    
}
