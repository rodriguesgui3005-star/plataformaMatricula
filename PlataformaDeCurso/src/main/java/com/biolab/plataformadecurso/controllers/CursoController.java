package com.biolab.plataformadecurso.controllers;

import com.biolab.plataformadecurso.DTOs.AlunoDTO;
import com.biolab.plataformadecurso.DTOs.CursoDTO;
import com.biolab.plataformadecurso.repositories.CursoRepository;
import com.biolab.plataformadecurso.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("curso")
public class CursoController {

    private final CursoService  cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<String> CadastrarCurso(@RequestBody CursoDTO cursodto) {
        return ResponseEntity.ok(cursoService.CadastrarCurso(cursodto));
    }

    @GetMapping
    public ResponseEntity<?> mostrarCurso() {
        return ResponseEntity.ok(cursoService.mostrarCurso());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> mostrarCursoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.mostrarCursoId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> RemoverCurso(@PathVariable Long id) {
        return  ResponseEntity.ok(cursoService.RemoverCurso(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>AlterarCurso(@PathVariable Long id, @RequestBody CursoDTO cursodto) {
        return ResponseEntity.ok(cursoService.AlterarCurso(id, cursodto));
    }
}
