package com.biolab.plataformadecurso.DTOs;

import com.biolab.plataformadecurso.entities.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoDTO {
    private long id;
    private String nome;
    private int cargaHoraria;

    public CursoDTO(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public CursoDTO(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.cargaHoraria = curso.getCargaHoraria();
    }
}
