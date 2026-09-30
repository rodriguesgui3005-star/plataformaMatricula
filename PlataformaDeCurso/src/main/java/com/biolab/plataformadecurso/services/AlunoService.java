package com.biolab.plataformadecurso.services;

import com.biolab.plataformadecurso.DTOs.AlunoDTO;
import com.biolab.plataformadecurso.DTOs.CursoDTO;
import com.biolab.plataformadecurso.entities.Aluno;
import com.biolab.plataformadecurso.entities.Curso;
import com.biolab.plataformadecurso.repositories.AlunoRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public String CadastrarAluno(AlunoDTO alunodto) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunodto.getNome());
        aluno.setEmail(alunodto.getEmail());
        alunoRepository.save(aluno);
        return "Aluno Cadastrado com sucesso!";
    }

    public List<AlunoDTO> mostrarAlunos (){
        return alunoRepository.findAll().stream()
                .map(produto -> new AlunoDTO(produto.getId(),produto.getNome(), produto.getEmail()
                ))
                .toList();
    }

    public AlunoDTO buscarAlunoPorId(long id){
        Aluno aluno = alunoRepository.findById(id).get();
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setEmail(aluno.getEmail());
        for (Curso curso : aluno.getCursos()) {
            CursoDTO cursoDTO = new CursoDTO(curso);
            alunoDTO.getCursos().add(cursoDTO);
        }
        return alunoDTO;
    }

    public String editarAluno(long idAluno, AlunoDTO alunoDTO){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        alunoRepository.save(aluno);
        return "Aluno editado com sucesso!";
    }

    public String excluirAluno(long idAluno){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();
        alunoRepository.delete(aluno);
        return "Aluno excluido com sucesso!";
    }
}
