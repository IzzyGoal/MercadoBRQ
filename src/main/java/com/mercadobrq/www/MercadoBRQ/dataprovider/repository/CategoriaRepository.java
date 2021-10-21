package com.mercadobrq.www.MercadoBRQ.dataprovider.repository;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface resposavel por intermediar o acesso e alteração de dados da entidade no banco de dados da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Long> {

    CategoriaEntity findByNome(String nome);
}
