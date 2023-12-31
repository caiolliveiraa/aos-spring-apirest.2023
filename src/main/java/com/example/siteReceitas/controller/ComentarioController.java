package com.example.siteReceitas.controller;



import com.example.siteReceitas.models.Comentario;

import com.example.siteReceitas.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Comentario> createComentario(@RequestBody Comentario comentario){
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.createComentario(comentario));
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Comentario>> readComentarios(){
        return ResponseEntity.status(HttpStatus.OK).body(
                comentarioService.getAllComentarios()
        );
    }

    @RequestMapping(value = "/{comentario_id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Comentario>> readComentario(@PathVariable(value = "comentario_id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(
                comentarioService.getComentarioById(id)
        );
    }

    @RequestMapping(value = "/update/{comentario_id}", method = RequestMethod.PUT)
    public ResponseEntity<Comentario> updateComentario(@PathVariable(value = "comentario_id") long id,
                                                       @RequestBody Comentario comentario) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.updateComentario(id, comentario));
    }

    @RequestMapping(value = "/delete/{comentario_id}")
    public ResponseEntity<Comentario> deleteComentario(@PathVariable(value = "comentario_id") long id){
        comentarioService.deleteComentario(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }




}