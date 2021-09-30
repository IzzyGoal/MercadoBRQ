package com.mercadobrq.www.MercadoBRQ.dataprovider.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Builder
@Table(name ="tab_categoria")
public class CategoriaEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

}

