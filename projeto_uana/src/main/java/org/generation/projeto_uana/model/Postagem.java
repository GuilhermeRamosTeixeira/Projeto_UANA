package org.generation.projeto_uana.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/***
 * 
 * @author Grupo_6
 * Responsabilidade da model gravar nome do usuario
 *
 */
@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@URL
	@Size(max = 700, message = "O atributo IMGURL permite no máximo 255 caracteres")  //Perguntar sobre o tamanho da imagem
	private String imgUrl;
	
	@NotBlank(message = "O atributo Texto é obrigatório e não aceita espaço vazio")
	@Size(max = 3000, message = "O atributo Texto permite no máximo 3000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private Date dataPublic = new java.sql.Date(System.currentTimeMillis());
	
	@Size(max = 80, message = "O atributo Contato permite no máximo 80 caracteres")
	private String contato;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	// Getters e Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataPublic() {
		return dataPublic;
	}

	public void setDataPublic(Date dataPublic) {
		this.dataPublic = dataPublic;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
