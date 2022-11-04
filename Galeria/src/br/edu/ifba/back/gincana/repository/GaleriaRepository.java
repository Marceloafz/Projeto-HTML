package br.edu.ifba.back.gincana.repository;

import org.springframework.stereotype.Repository;

import br.edu.ifba.back.gincana.model.GaleriaModel;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GaleriaRepository extends JpaRepository<GaleriaModel, Long>{
	
}
