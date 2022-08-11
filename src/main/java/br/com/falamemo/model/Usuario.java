package br.com.falamemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 255)
	private String nome;

	@NotBlank
	@Size(min = 3, max = 255)
	@Email
	private String usuario;

	@NotBlank
	@Size(min = 3, max = 255)
	private String senha;

	@NotBlank
	@Size(min = 3, max = 255)
	private String foto;

	@NotBlank
	@Size(min = 3, max = 255)
	private String genero;

	@NotBlank
	@Size(min = 3, max = 255)
	private String orientacao;

	@AssertTrue
	private Boolean pcd;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}

	public Boolean getPcd() {
		return pcd;
	}

	public void setPcd(Boolean pcd) {
		this.pcd = pcd;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}
