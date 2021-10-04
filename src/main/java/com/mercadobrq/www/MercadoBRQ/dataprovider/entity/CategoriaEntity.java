package com.mercadobrq.www.MercadoBRQ.dataprovider.entity;

import lombok.*;
import javax.persistence.*;

/**
 * Classe responsavel por mapear as entidades do objeto categoria.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name ="tab_categoria")
public class CategoriaEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;


}

