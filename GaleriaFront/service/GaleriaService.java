package br.edu.ifba.tarefa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;
import br.edu.ifba.gincana.model.GaleriaModel;

import br.ifba.gincana.model.GaleriaModel;
import reactor.core.publisher.Mono;


@Service
public class GaleriaService {
	@Autowired
	private WebClient webClient;
	
	public GaleriaModel getGaleria(Integer id) {
		
		Mono<GaleriaModel> galeriaModel = this.webClient
											.method(HttpMethod.GET)
											.uri("galeria/{id}", id)
											.retrieve()
											.bodyToMono(GaleriaModel.class);
		
		GaleriaModel tm = galeriaModel.block();
		return tm;
	}
	
	public List<GaleriaModel> getGalerias() {
		
		Mono<GaleriaModel[]> galeriaModel = this.webClient
											.method(HttpMethod.GET)
											.uri("galeria/listall")
											.retrieve()
											.bodyToMono(GaleriaModel[].class);
		
		List<GaleriaModel> list = new ArrayList<GaleriaModel>();
		GaleriaModel[] tm = galeriaModel.block();
		for (GaleriaModel galeriaModel2 : tm) {
			list.add(galeriaModel2);
		}
		
		return list;
	}
	
	public Boolean deleteGaleria(Integer id) {
		Mono<Boolean> galeriaDel = this.webClient
											.method(HttpMethod.DELETE)
											.uri("galeria/{id}", id)
											.retrieve()
											.bodyToMono(Boolean.class);
		
		
		Boolean result = galeriaDel.block();
		return result;
	}
	
	public Boolean insert(GaleriaModel galeriaModel) {
		Mono<Boolean> galeria = this.webClient
									.method(HttpMethod.POST)
									.uri("galeria/")
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(galeriaModel), GaleriaModel.class)
									.retrieve()
									.bodyToMono(Boolean.class);
		Boolean result = galeria.block();
		return result;
	}
	
	public GaleriaModel update(GaleriaModel galeriaModel) {
		System.out.println("update: " + galeriaModel);
		Mono<GaleriaModel> galeria = this.webClient
									.method(HttpMethod.PUT)
									.uri("galeria/{id}", galeriaModel.getId())
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.body(Mono.just(galeriaModel), GaleriaModel.class)
									.retrieve()
									.bodyToMono(GaleriaModel.class);
		GaleriaModel result = galeria.block();
		return result;
	}
	
	
	
}
