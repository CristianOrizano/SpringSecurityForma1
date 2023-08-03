package com.examencl2.entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Table(name = "tb_usuario")
@Entity
public class Usuario {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id_usuario;
	    
	    private String username;
	    
	    private String email;
	    
		private String password;
	    @ManyToOne
	    @JoinColumn(name ="id_rol")
	    private Rol rol;
	    
	    
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getId_usuario() {
			return id_usuario;
		}
		public void setId_usuario(int id_usuario) {
			this.id_usuario = id_usuario;
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
		public Rol getRol() {
			return rol;
		}
		public void setRol(Rol rol) {
			this.rol = rol;
		}
	    
	    

}
