package br.com.luciano.helpdesk.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.luciano.helpdesk.config.service.TecnicoService;
import br.com.luciano.helpdesk.dto.TecnicoDto;
import br.com.luciano.helpdesk.entity.Tecnico;

@RestController
@RequestMapping(value="/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<TecnicoDto> findById(@PathVariable Integer id){
		Tecnico tecnico = service.findById(id);
		TecnicoDto tecnicoDto = new TecnicoDto(tecnico);
		return ResponseEntity.ok().body(tecnicoDto);
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDto>> findAll(){
		List<Tecnico> tecnicos = service.findAll();
		
		List<TecnicoDto> tecnicosDtos = tecnicos.stream()
				.map(t -> new TecnicoDto(t))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(tecnicosDtos);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDto> create(@RequestBody TecnicoDto tecnicoDto){
		
		Tecnico tecnico = new Tecnico(tecnicoDto);
		tecnico = service.create(tecnico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(tecnico.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	

}
