package com.mercadobrq.www.MercadoBRQ.dataprovider.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Classe responsavel por conter os dados da Entidade PRODUTO.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "produto")
public class ProdutoEntity {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column
    private Boolean ativo;

    @Column
    private Boolean ofertado;

    @Column
    private Integer porcetagem;

    @ManyToOne(targetEntity = CategoriaEntity.class)
    @JoinColumn(nullable = false)
    private CategoriaEntity categoria;
}
