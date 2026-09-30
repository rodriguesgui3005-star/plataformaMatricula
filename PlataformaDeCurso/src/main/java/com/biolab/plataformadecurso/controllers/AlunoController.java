package com.biolab.plataformadecurso.controllers;

import com.biolab.plataformadecurso.DTOs.AlunoDTO;
import com.biolab.plataformadecurso.entities.Aluno;
import com.biolab.plataformadecurso.repositories.AlunoRepository;
import com.biolab.plataformadecurso.repositories.CursoRepository;
import com.biolab.plataformadecurso.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    public final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<?> CadastrarAluno(@RequestBody AlunoDTO alunodto) {
        return ResponseEntity.ok(alunoService.CadastrarAluno(alunodto));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> mostrarAlunos () {
        return ResponseEntity.ok(alunoService.mostrarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> mostrarAluno (@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.buscarAlunoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.excluirAluno(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        return ResponseEntity.ok(alunoService.editarAluno(id, alunoDTO));
    }
}
