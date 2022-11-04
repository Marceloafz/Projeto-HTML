package br.edu.ifba.back.gincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "Galeria")

public class GaleriaModel<GincanaModal> {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column (name = "idGaleria")
	private long idGaleria;  
	
	@Column (name = "nomeGaleria", nullable = false, unique = true)
	private  String nomeGaleria;
	
	@Column (name = "descricaoGaleria", nullable = false)
	private  String descricaoGaleria;

	@ManyToOne
	@JoinColumn(nullable = false)
	private GincanaModal gincana;
	
	
	public long getIdCriterio() {
		return idGaleria;
	}

	public void setIdCriterio(long idCriterio) {
		this.idGaleria = idCriterio;
	}

	public String getNomeCriterio() {
		return nomeGaleria;
	}

	public void setNomeCriterio(String nomeGaleria) {
		this.nomeGaleria = nomeGaleria;
	}

	public String getPontuacaoCriterio() {
		return descricaoGaleria;
	}

	public void setPontuacaoCriterio(String descricaoGaleria) {
		this.descricaoGaleria = descricaoGaleria;
	}

	public GincanaModal getProva() {
		return gincana;
	}

	public void setImagem(GincanaModal gincana) {
		this.gincana = gincana;
	}

	public GaleriaModel(long idGaleria, String nomeGaleria, String descricaoGaleria, GincanaModal gincana) {
		super();
		this.idGaleria = idGaleria;
		this.nomeGaleria = nomeGaleria;
		this.descricaoGaleria = descricaoGaleria;
		this.gincana = gincana;
	}

	public GaleriaModel() {
		super();
	}

	@Override
	public String toString() {
		return "GaleriaModel [idGaleria=" + idGaleria + ", nomeGaleria=" + nomeGaleria + ", descricaoGaleria="
				+ descricaoGaleria + "]";
	}
	

	
}