package com.mercadobrq.www.MercadoBRQ.dataprovider.repository;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface resposavel por intermediar o acesso e alteração de dados da entidade no banco de dados da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
@Repository
public interface ProdutoRepository  extends JpaRepository<ProdutoEntity, Long> {
    Page<ProdutoEntity> findByCategoria(Pageable pageable, String category);

    Page<ProdutoEntity> findByMarca(Pageable pageable, String brand);
}