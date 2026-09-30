package com.biolab.plataformadecurso.services;

import com.biolab.plataformadecurso.entities.Aluno;
import com.biolab.plataformadecurso.entities.Curso;
import com.biolab.plataformadecurso.repositories.AlunoRepository;
import com.biolab.plataformadecurso.repositories.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }


    public String addAlunoCurso(long idAluno, long idCurso){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();
        Curso curso = cursoRepository.findById(idCurso).orElseThrow();
        aluno.getCursos().add(curso);
        alunoRepository.save(aluno);
        return "matricula feita com sucesso";
    }

}
