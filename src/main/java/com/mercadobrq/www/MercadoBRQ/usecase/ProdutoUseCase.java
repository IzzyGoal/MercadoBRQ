package com.mercadobrq.www.MercadoBRQ.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.request.ProdutoParameterModelResquest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.ProdutoGateway;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Map;

import static com.mercadobrq.www.MercadoBRQ.usecase.utils.ProdutoUseCaseUtils.CheckIfProductExist;

/**
 * Classe responsavel por intermediar a operação logica da aplicação e a comunicação com o banco de dados
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 *
 */
@AllArgsConstructor
@Service
public class ProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ProdutoDomainResponse addProduct(ProdutoDomainRequest product) {
        return produtoGateway.addProduct(product);
    }

    public ProdutoDomainResponse findProductWithId(Long idProduct) {

        ProdutoDomainResponse product = produtoGateway.findWithID(idProduct);
        CheckIfProductExist(product, idProduct);

        return product;
    }

    public void deleteProduct( Long idProduct){
        produtoGateway.deleteProduct(idProduct);
    }

    public ProdutoDomainResponse updateProduct(Long idProduct, ProdutoDomainRequest product) {
        ProdutoDomainResponse productNow = findProductWithId(idProduct);
        productNow = ProdutoDomainResponse.builder()
                .id(productNow.getId())
                .nome(product.getNome())
                .descricao(product.getDescricao())
                .marca(product.getMarca())
                .quantidade(product.getQuantidade())
                .preco(product.getPreco())
                .ativo(product.getAtivo())
                .ofertado(product.getOfertado())
                .porcentagem(product.getPorcentagem())
                .build();

        return produtoGateway.updateProduct(productNow);
    }
    public ProdutoDomainResponse partiallyUpdate(Long idProduct, Map<String, Object> newData) {

        ProdutoDomainResponse product = produtoGateway.findWithID(idProduct);
        merge(newData,product);

        return produtoGateway.partiallyUpdate(product);
    }

    private void merge(Map<String, Object> newDataProduct, ProdutoDomainResponse product) {
        var objectMapper = new ObjectMapper();
        ProdutoDomainResponse ProductOrigin = objectMapper.convertValue(newDataProduct, ProdutoDomainResponse.class);
        newDataProduct.forEach((name, value) -> {
            Field field = ReflectionUtils.findField(ProdutoDomainResponse.class, name);
            field.setAccessible(true);
            Object newValue = ReflectionUtils.getField(field,ProductOrigin);

            ReflectionUtils.setField(field, product, newValue);
        });
    }

    public Page<ProdutoDomainResponse> SearchAllProductWhitParameters(Pageable pageable, ProdutoParameterModelResquest product) {
        if (StringUtils.isNotBlank(product.getNomeCategoria())) {
            return produtoGateway.searchProductforCategory(pageable,product.getNomeCategoria());
        }
        if (StringUtils.isNotBlank(product.getMarca())) {
            return  produtoGateway.searchProductforBrand(pageable, product.getMarca());
        }
        return produtoGateway.searchAllProduct(pageable);
    }
}
