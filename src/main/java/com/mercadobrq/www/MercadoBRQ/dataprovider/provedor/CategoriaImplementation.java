package com.mercadobrq.www.MercadoBRQ.dataprovider.provedor;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.request.CategoriaMapperRequest;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.response.CategoriaMapperResponse;
import com.mercadobrq.www.MercadoBRQ.dataprovider.repository.CategoriaRepository;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.CategoriaGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsavel por porver os dados da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@AllArgsConstructor
@Component
public class CategoriaImplementation implements CategoriaGateway {

    private final CategoriaRepository categoriaRepository;

    /**
     * Metodo responsavel por compor a parte logica da operação de adicionar uma categoria utilizando
     * o repositorio da aplicação.
     * @param categoria {@code CategoriaDomainRequest} -
     * @return CategoriaMapperResponse
     */
    @Transactional
    @Override
    public CategoriaDomainResponse addCategory(CategoriaDomainRequest categoria) {
        CategoriaEntity newCategory = CategoriaMapperRequest.toEntity(categoria);
        CategoriaEntity categoriaEntity = categoriaRepository.save(newCategory);

        return CategoriaMapperResponse.toDomain(categoriaEntity);
    }

    /**
     * Metodo responsavel por compor a parte logica da operação de procurar uma lista de categorias utilizando
     * o repositoria da aplicação.
     * @return CategoriaDomainRequest
     */
    @Override
    public List<CategoriaDomainResponse> findCategory() {
        List<CategoriaEntity> categorias = categoriaRepository.findAll();

        return CategoriaMapperResponse.toCollectionDomain(categorias);
    }

    /**
     * Metodo responsavel por compor a parte logica da operação de procurar uma categoria por ID utilizando
     * o repositorio da aplicação
     * @param idCategory {@code Long}
     * @return CategoriaMapperResponse
     */
    @Override
    public CategoriaDomainResponse findCategoryWithId( Long idCategory) {
        Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(idCategory);

        return CategoriaMapperResponse.toDomain(categoriaEntity.get());
    }

    /**
     * Metodo responsavel por compor a parte logica de deletar uma categoria pelo seu ID utilizando o
     * repositorio da aplicação.
     * @param idCategory {@code Long} -
     */
    @Override
    public void deleteCategoryWithId(Long idCategory) {
        categoriaRepository.deleteById(idCategory);
    }

    /**
     * Metodo responsavel por compor a parte logica de atualizar uma categoria utilizando do
     * repositorio da aplicação.
     * @param category {@code CategoriaDomainResponse } -
     * @return CategoriaMapperResponse
     */
    @Transactional
    @Override
    public CategoriaDomainResponse updateCategory(CategoriaDomainResponse category) {
        CategoriaEntity newCategory = CategoriaMapperRequest.toEntityUpdate(category);
        CategoriaEntity categoria = categoriaRepository.save(newCategory);

        return CategoriaMapperResponse.toDomain(categoria);
    }

}
