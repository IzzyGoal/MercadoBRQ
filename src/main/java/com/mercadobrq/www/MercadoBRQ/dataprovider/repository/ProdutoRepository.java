package com.mercadobrq.www.MercadoBRQ.dataprovider.repository;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Interface resposavel por intermediar o acesso e alteração de dados da entidade no banco de dados da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
public interface ProdutoRepository  extends JpaRepository<ProdutoEntity, Long> {
}
