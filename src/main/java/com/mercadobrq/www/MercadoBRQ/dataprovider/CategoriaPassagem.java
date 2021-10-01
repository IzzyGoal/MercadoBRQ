package com.mercadobrq.www.MercadoBRQ.dataprovider;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.CategoriaMapperRequest;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.CategoriaMapperResponse;
import com.mercadobrq.www.MercadoBRQ.dataprovider.repository.CategoriaRepository;
import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.CategoriaEntryopintMapperResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.CategoriaGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class CategoriaPassagem implements CategoriaGateway {

    private final CategoriaRepository categoriaRepository;

    @Transactional
    @Override
    public CategoriaDomainResponse addCategory(CategoriaDomainRequest categoria) {
        CategoriaEntity newCategory = CategoriaMapperRequest.toEntity(categoria);
        CategoriaEntity categoriaEntity = categoriaRepository.save(newCategory);

        return CategoriaMapperResponse.toDomain(categoriaEntity);
    }

    @Override
    public List<CategoriaDomainResponse> findCategory() {
        List<CategoriaEntity> categorias = categoriaRepository.findAll();

        return CategoriaMapperResponse.toCollecationDomain(categorias);
    }

    @Override
    public CategoriaDomainResponse findCategoryWithId( Long idCategory) {
        Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(idCategory);

        return CategoriaMapperResponse.toDomain(categoriaEntity.get());
    }

    public void deleteCategoryWithId(Long idCategory) {
        categoriaRepository.deleteById(idCategory);
    }

    public CategoriaDomainResponse updateCategory(CategoriaDomainResponse category) {
        CategoriaEntity newCategory = CategoriaMapperRequest.toEntityUpdate(category);
        CategoriaEntity categoria = categoriaRepository.save(newCategory);

        return CategoriaMapperResponse.toDomain(categoria);
    }

}
