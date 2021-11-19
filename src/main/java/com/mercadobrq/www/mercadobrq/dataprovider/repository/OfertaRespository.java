package com.mercadobrq.www.mercadobrq.dataprovider.repository;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRespository extends JpaRepository<ProdutoEntity , Long> {

    @Query("select produto from ProdutoEntity  produto where produto.ofertado = 1")
    Page<ProdutoEntity> buscarProdutoEmOferta(Pageable pageable);
}
