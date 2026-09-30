package com.biolab.plataformadecurso.services;



import com.biolab.plataformadecurso.DTOs.CursoDTO;
import com.biolab.plataformadecurso.entities.Curso;
import com.biolab.plataformadecurso.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService{

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    public String CadastrarCurso(CursoDTO cursodto) {
        Curso curso = new Curso();
        curso.setNome(cursodto.getNome());
        curso.setCargaHoraria(cursodto.getCargaHoraria());
        cursoRepository.save(curso);
        return "Curso Cadastrado com sucesso!";
    }

    public List<CursoDTO> mostrarCurso(){
        return cursoRepository.findAll().stream()
                .map(curso -> new CursoDTO(curso.getId(), curso.getNome(), curso.getCargaHoraria()
                ))
                .toList();
    }

    public CursoDTO mostrarCursoId(long id){
        Curso curso = cursoRepository.findById(id).orElseThrow();
        return new CursoDTO(curso.getId(), curso.getNome(), curso.getCargaHoraria());
    }

    public String RemoverCurso(long id){
        Curso curso = cursoRepository.findById(id).orElseThrow();
        cursoRepository.delete(curso);
        return "Curso removido com sucesso!";
    }

    public String AlterarCurso(long id, CursoDTO cursodto) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        curso.setNome(cursodto.getNome());
        curso.setCargaHoraria(cursodto.getCargaHoraria());
        cursoRepository.save(curso);
        return "Aluno Alterado com sucesso!";
    }
}
