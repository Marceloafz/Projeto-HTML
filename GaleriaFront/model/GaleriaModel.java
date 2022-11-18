package br.edu.ifba.gincana.model;

import java.sql.Date;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor

public class GaleriaModel {

	private Integer id;
	private String nome_Galeria;
	private String descricao_Gincana;
	
	/*
	@ManyToOnes
	@JoinColumn(name = "id_gincana",  nullable = false)
	private GincanaModel id_gincana;
	*/

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome_Galeria() {
		return nome_Galeria;
	}
	public void setNome_Galeria(String nome_Galeria) {
		this.nome_Galeria = nome_Galeria;
	}
	public String  getDescricao_Gincana() {
		return descricao_Gincana;
	}
	public void setDescriao_Gincana(long descricao_Gincana) {
		this.descricao_Gincana = descricao_Gincana;
	}

	@Override
	public String toString() {
		return "GaleriaModel [id=" + id + ", nome_Galeria=" + nome_Galeria + ", descricao_Gincana="
				+  descricao_Gincana + "]";
	}
	
	
	
	
}
