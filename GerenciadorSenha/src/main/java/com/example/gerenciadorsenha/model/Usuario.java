package com.example.gerenciadorsenha.model;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Usuario {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name="senha", nullable = false)
    private String senha;

    @Getter @Setter
    @Column(name="descricao", nullable = false)
    private String descricao;

    @Getter @Setter
    @Column(name="url", nullable = false)
    private String url;
}
