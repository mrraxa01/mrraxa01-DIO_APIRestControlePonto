package com.dio.live.controller;

import com.dio.live.Service.JornadaService;
import com.dio.live.model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho) ;
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();

    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho>  getJornadaByID(@PathVariable("idJornada") long idJornada) throws Exception {
        return  ResponseEntity.ok(jornadaService.getJornadaTrabalhoById(idJornada).orElseThrow(() -> new NoSuchElementException("NOT FOUND!!!")));

    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }
    @DeleteMapping("/{idJornada}")
    public void deleteByID(@PathVariable("idJornada") Long idJornada){
        try{
            jornadaService.deleteJornada(idJornada);
        }catch(Exception e){
            System.out.println(e.getMessage());

        }

    }



}
