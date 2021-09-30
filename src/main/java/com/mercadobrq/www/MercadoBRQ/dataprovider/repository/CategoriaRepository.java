package com.mercadobrq.www.MercadoBRQ.dataprovider.repository;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Long> {
}
