package com.biolab.plataformadecurso.DTOs;

import com.biolab.plataformadecurso.entities.Curso;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    private int id;
    @Email
    private String nome;
    @NotBlank
    @Email
    private String email;
    private Set<CursoDTO> cursos = new HashSet<>();

    public AlunoDTO(String nome, String email,  Set<CursoDTO> cursos) {
        this.nome = nome;
        this.email = email;
        this.cursos = cursos;
    }
    public AlunoDTO(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;

    }


}
