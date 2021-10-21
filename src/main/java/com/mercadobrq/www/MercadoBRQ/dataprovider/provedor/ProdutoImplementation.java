package com.mercadobrq.www.MercadoBRQ.dataprovider.provedor;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.request.ProdutoDataProviderMapperResquest;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.response.ProdutoDataProviderMapperResponse;
import com.mercadobrq.www.MercadoBRQ.dataprovider.repository.ProdutoRepository;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.ProdutoGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.Optional;

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
    public ProdutoDomainResponse findWithID(Long idProduct) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(idProduct);

        return ProdutoDataProviderMapperResponse.toDomain(produtoEntity.get());
    }

    @Transactional
    @Override
    public ProdutoDomainResponse updateProduct(ProdutoDomainResponse newProduct) {
        ProdutoEntity product = ProdutoDataProviderMapperResquest.toEntityUpdate(newProduct);
        ProdutoEntity savedProduct = produtoRepository.save(product);

        return ProdutoDataProviderMapperResponse.toDomain(savedProduct);
    }

    @Transactional
    @Override
    public ProdutoDomainResponse partiallyUpdate(ProdutoDomainResponse productChanged) {
        ProdutoEntity newProduct = ProdutoDataProviderMapperResquest.toEntityUpdate(productChanged);
        ProdutoEntity savedProduct = produtoRepository.save(newProduct);

        return ProdutoDataProviderMapperResponse.toDomain(savedProduct);
    }

    @Transactional
    @Override
    public void deleteProduct(Long idProduct) {
        produtoRepository.deleteById(idProduct);
    }

    @Override
    public Page<ProdutoDomainResponse> searchProductforCategory(Pageable pageable, String category) {
        Page<ProdutoEntity> productForCategory = produtoRepository.findByCategoria(pageable,category);

        return ProdutoDataProviderMapperResponse.toCollectionDomain(productForCategory);
    }

    @Override
    public Page<ProdutoDomainResponse> searchProductforBrand(Pageable pageable, String brand) {
        Page<ProdutoEntity> productForBrand = produtoRepository.findByMarca(pageable,brand);

        return ProdutoDataProviderMapperResponse.toCollectionDomain(productForBrand);
    }

    @Override
    public Page<ProdutoDomainResponse> searchAllProduct(Pageable pageable) {
        Page<ProdutoEntity> produtos = produtoRepository.findAll(pageable);

        return ProdutoDataProviderMapperResponse.toCollectionDomain(produtos);
    }
}
