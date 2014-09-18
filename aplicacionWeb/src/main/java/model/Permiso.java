package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permisos database table.
 * 
 */
@Entity
@Table(name="permisos")
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permiso")
	private String idPermiso;

	@Column(name="descripcion_permiso")
	private String descripcionPermiso;

	//bi-directional many-to-many association to Formulario
	@ManyToMany(mappedBy="permisos")
	private List<Formulario> formularios;

	//bi-directional many-to-one association to Perfile
	@OneToMany(mappedBy="permiso")
	private List<Perfile> perfiles;

	public Permiso() {
	}

	public String getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(String idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getDescripcionPermiso() {
		return this.descripcionPermiso;
	}

	public void setDescripcionPermiso(String descripcionPermiso) {
		this.descripcionPermiso = descripcionPermiso;
	}

	public List<Formulario> getFormularios() {
		return this.formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}

	public List<Perfile> getPerfiles() {
		return this.perfiles;
	}

	public void setPerfiles(List<Perfile> perfiles) {
		this.perfiles = perfiles;
	}

	public Perfile addPerfile(Perfile perfile) {
		getPerfiles().add(perfile);
		perfile.setPermiso(this);

		return perfile;
	}

	public Perfile removePerfile(Perfile perfile) {
		getPerfiles().remove(perfile);
		perfile.setPermiso(null);

		return perfile;
	}

}