package com.blog.alura.demo.controller;

import com.blog.alura.demo.domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosTopicoPublico> registrarTopico(@RequestBody @Valid DatosTopico datosTopico,
                                                              UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosTopico));
        DatosTopicoPublico datosTopicoPublico = new DatosTopicoPublico(topico);
        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topico.getIdTopico()).toUri();
        return ResponseEntity.created(url).body(datosTopicoPublico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopicoPublico>> listarDatosTopico(@PageableDefault(size = 4) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosTopicoPublico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosTopicoPublico> actualizarTopico(@RequestBody @Valid DatosActualizaTopico datosActualizaTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizaTopico.id());
        topico.actualizarDatos(datosActualizaTopico);
        return ResponseEntity.ok(new DatosTopicoPublico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosTopicoPublico> eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosTopicoPublico> retornaDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosTopicoPublico(topico));
    }
}
