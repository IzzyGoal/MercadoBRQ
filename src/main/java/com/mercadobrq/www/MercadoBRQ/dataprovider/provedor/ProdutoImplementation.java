package com.mercadobrq.www.MercadoBRQ.dataprovider.provedor;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.request.ProdutoDataProviderMapperResquest;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.response.ProdutoDataProviderMapperResponse;
import com.mercadobrq.www.MercadoBRQ.dataprovider.repository.CategoriaRepository;
import com.mercadobrq.www.MercadoBRQ.dataprovider.repository.ProdutoRepository;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.ProdutoGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Classe responsavel por porver os dados da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@AllArgsConstructor
@Component
public class ProdutoImplementation implements ProdutoGateway {

    private final ProdutoRepository produtoRepository;


    @Transactional
    @Override
    public ProdutoDomainResponse addProduct(ProdutoDomainRequest produtoDomainRequest) {
        ProdutoEntity newProduct = ProdutoDataProviderMapperResquest.toEntity(produtoDomainRequest);
        ProdutoEntity produtoEntity = produtoRepository.save(newProduct);

        return ProdutoDataProviderMapperResponse.toDomain(produtoEntity);
    }

    @Override
    public List<ProdutoDomainResponse> searchAll() {
        return null;
    }

    @Override
    public ProdutoDomainResponse findWithID(Long idProduct) {
        return null;
    }

    @Override
    public ProdutoDomainResponse updateProduct(ProdutoDomainResponse newProduct) {
        return null;
    }

    @Override
    public ProdutoDomainResponse partiallyUpdate(ProdutoDomainResponse productChanged) {
        return null;
    }

    @Override
    public void deleteProduct(Long idProduct) {

    }
}
