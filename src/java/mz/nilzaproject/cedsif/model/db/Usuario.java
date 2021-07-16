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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nilza.graca
 */
@Entity
@Table(name = "usuario")

@XmlRootElement
/*
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
    , @NamedQuery(name = "Usuario.findByNameDescription", query = "SELECT u FROM Usuario u WHERE u.nameDescription = :nameDescription")})
*/
public class Usuario implements Serializable {

    @JoinTable(name = "usuario_material", joinColumns = {
        @JoinColumn(name = "usuario_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "material_id", referencedColumnName = "id")})
    @ManyToMany(cascade=CascadeType.ALL)
    @XmlTransient
    private List<Material> materialList = new ArrayList<>();

    @Basic(optional = false)
    @Id
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "perfil")
    private String perfil;
    private static final long serialVersionUID = 1L;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "nameDescription")
    private String nameDescription;

    public Usuario() {
    }

    public Usuario(String perfil, String username, String password, String nameDescription) {
        this.id = id;
        this.perfil = perfil;
        this.username = username;
        this.password = password;
        this.nameDescription = nameDescription;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameDescription() {
        return nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    @XmlTransient
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    @Override
    public String toString() {
        return "mz.nilzaproject.cedsif.model.db.Usuario[ id=" + id + ", perfil=" + perfil + " ]";
        
    }
}
