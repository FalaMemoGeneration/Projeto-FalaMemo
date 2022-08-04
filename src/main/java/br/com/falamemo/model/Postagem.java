package br.com.falamemo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo título é obrigatório!")
	@Size(min = 5, max = 255, message = "O atributo título deve conter no mínimo de 05 e no máximo 255 caracteres")
	private String titulo;

	@NotBlank(message = "O atributo texto é obrigatório!")
	@Size(min = 5, max = 1000, message = "O atributo texto deve conter no mínimo de 05 e no máximo 1000 caracteres")
	private String texto;

	@UpdateTimestamp
	private LocalDateTime data;

	@NotNull(message = "O atributo avaliação é obrigatório!")
	@Min(value = 1)
	@Max(value = 5)
	private Double avaliacao;

	@AssertTrue
	private Boolean reacao;

	@Size(min = 5, max = 1000, message = "O atributo texto deve conter no mínimo de 05 e no máximo 1000 caracteres")
	private String comentario;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Boolean getReacao() {
		return reacao;
	}

	public void setReacao(Boolean reacao) {
		this.reacao = reacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
