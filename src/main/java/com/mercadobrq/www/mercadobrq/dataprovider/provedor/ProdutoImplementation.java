package com.mercadobrq.www.mercadobrq.dataprovider.provedor;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.mercadobrq.dataprovider.mapper.request.ProdutoDataProviderMapperResquest;
import com.mercadobrq.www.mercadobrq.dataprovider.mapper.response.ProdutoDataProviderMapperResponse;
import com.mercadobrq.www.mercadobrq.dataprovider.repository.ProdutoRepository;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.gateway.ProdutoGateway;
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

    /**
     * Metodo responsavel pela logica de se adicionar um produto.
     * @param produtoDomainRequest {@code ProdutoDomainRequest} - entrada de informações do usuario.
     * @return ProdutoDataProviderMapperResponse - Obejto contruido.
     */
    @Transactional
    @Override
    public ProdutoDomainResponse addProduct(ProdutoDomainRequest produtoDomainRequest) {
        ProdutoEntity newProduct = ProdutoDataProviderMapperResquest.toEntity(produtoDomainRequest);
        ProdutoEntity produtoEntity = produtoRepository.save(newProduct);

        return ProdutoDataProviderMapperResponse.toDomain(produtoEntity);
    }

    /**
     * Metodo responsavel pela logica de procurar um produto pelo QueryParam ID
     * @param idProduct {@code Long} -  Queryparam do tipo Long
     * @return ProdutoDataProviderMapperResponse - Objeto Consultado.
     */
    @Override
    public ProdutoDomainResponse findWithID(Long idProduct) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(idProduct);

        return ProdutoDataProviderMapperResponse.toDomain(produtoEntity.get());
    }

    /**
     * Meotdo responsavel pela logica de atualização do Produto.
     * @param product {@code ProdutoDomainResponse} - objeto atual do porduto
     * @return ProdutoDataProviderMapperResponse -  produto atualizado.
     */
    @Transactional
    @Override
    public ProdutoDomainResponse partiallyUpdate(ProdutoDomainResponse product) {
        ProdutoEntity newProduct = ProdutoDataProviderMapperResquest.toEntityUpdate(product);
        ProdutoEntity savedProduct = produtoRepository.save(newProduct);

        return ProdutoDataProviderMapperResponse.toDomain(savedProduct);
    }

    /**
     * Metodo responsavel pela logica de deletar um produto.
     * @param idProduct {@code idProduct} - QueryParam Para delete do tipo Long
     * o retorno é void.
     */
    @Transactional
    @Override
    public void deleteProduct(Long idProduct) {
        produtoRepository.deleteById(idProduct);
        produtoRepository.flush();
    }

    /**
     * Metodo responsavel pela logica de se filtrar o produto pela sua categoria.
     * @param pageable {@code Pageable} - devolve uma pagina com as informações.
     * @param nomeCategoria {@code String} - parametro do tipo String
     * @return ProdutoDataProviderMapperResponse - devolve uma lista de acordo com a categoria.
     */
    @Override
    public Page<ProdutoDomainResponse> searchProductforCategory(Pageable pageable, String nomeCategoria) {
        Page<ProdutoEntity> productsForCategory = produtoRepository.findByCategoriaNome(pageable,nomeCategoria);

        return ProdutoDataProviderMapperResponse.toCollectionDomain(productsForCategory);
    }

    /**
     * Metodo responsavel pela logica de se filtrar o produto pela sua marca.
     * @param pageable {@code Pageable} - devolve uma pagina com as informações.
     * @param marca {@code String} - parametro do tipo String
     * @return ProdutoDataProviderMapperResponse - devovle uma lista de acordo com a marca.
     */
    @Override
    public Page<ProdutoDomainResponse> searchProductforBrand(Pageable pageable, String marca) {
        Page<ProdutoEntity> productForBrand = produtoRepository.findByMarcaContains(pageable,marca);

        return ProdutoDataProviderMapperResponse.toCollectionDomain(productForBrand);
    }

    /**
     * Metodo responsavel pela logica de procurar todos os produtos
     * @param pageable {@code Pageable} - devolve uma pagina com as informações.
     * @return ProdutoDataProviderMapperResponse -  devolve uma lista com todos os produtos.
     */
    @Override
    public Page<ProdutoDomainResponse> searchAllProduct(Pageable pageable) {
        Page<ProdutoEntity> product = produtoRepository.findAll(pageable);

        return ProdutoDataProviderMapperResponse.toCollectionDomain(product);
    }
}
