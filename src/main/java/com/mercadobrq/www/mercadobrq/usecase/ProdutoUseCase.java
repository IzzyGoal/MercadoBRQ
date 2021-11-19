package com.mercadobrq.www.mercadobrq.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadobrq.www.mercadobrq.entrypoint.model.request.ProdutoParameterModelResquest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.ProductNotExistException;
import com.mercadobrq.www.mercadobrq.usecase.gateway.CategoriaGateway;
import com.mercadobrq.www.mercadobrq.usecase.gateway.ProdutoGateway;
import com.mercadobrq.www.mercadobrq.usecase.utils.CategoriaUseCaseUtils;
import com.mercadobrq.www.mercadobrq.usecase.utils.ProdutoUseCaseUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

import static com.mercadobrq.www.mercadobrq.usecase.utils.ProdutoUseCaseUtils.CheckIfProductExist;

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

    private static final String MENSAGEM_PRODUTO_NAO_EXISTE ="O produto do ID respectivo nao foi encontrado";
    private final ProdutoGateway produtoGateway;
    private final CategoriaGateway categoriaGateway;

    public ProdutoDomainResponse addProduct(ProdutoDomainRequest product) {
        Long idCategoria = product.getCategoria().getId();
        ProdutoUseCaseUtils.checkIfQuantityIsNotZero(product);

        CategoriaDomainResponse category = categoriaGateway.findCategoryWithId(idCategoria);
        CategoriaUseCaseUtils.checkIfCategoryExistForProduct(idCategoria, category);

        return produtoGateway.addProduct(product);
    }

    public ProdutoDomainResponse findProductWithId(Long idProduct, String expand) {

        ProdutoUseCaseUtils.checkIfExpandAreBeActive(expand);
        ProdutoDomainResponse product = produtoGateway.findWithID(idProduct,expand);
        CheckIfProductExist(product, idProduct);

        return product;
    }

    public void deleteProduct(Long idProduct) {
        String expand = null;
        findProductIdWithForDelete(idProduct,expand);

        produtoGateway.deleteProduct(idProduct);
    }

    private void findProductIdWithForDelete(Long idProduct,String expand) {
        if (Objects.nonNull(idProduct)) {
            ProdutoDomainResponse product  = produtoGateway.findWithID(idProduct,expand);
            if (Objects.isNull(product)) {
                throw new ProductNotExistException(String.format(MENSAGEM_PRODUTO_NAO_EXISTE, idProduct));
            }
        }
    }

    public ProdutoDomainResponse partiallyUpdate(Long idProduct, Map<String, Object> newData) {
        String expand = null;
        ProdutoDomainResponse product = produtoGateway.findWithID(idProduct,expand);
        ProdutoUseCaseUtils.CheckIfProductExist(product, idProduct);

        merge(newData, product);

        return produtoGateway.partiallyUpdate(product);
    }

    public Page<ProdutoDomainResponse> SearchAllProductWhitParameters(Pageable pageable, ProdutoParameterModelResquest product) {
        if (StringUtils.isNotBlank(product.getNomeCategoria())) {
            return produtoGateway.searchProductforCategory(pageable, product.getNomeCategoria());
        }
        if (StringUtils.isNotBlank(product.getMarca())) {
            return produtoGateway.searchProductforBrand(pageable, product.getMarca());
        }
        return produtoGateway.searchAllProduct(pageable);
    }

    private void merge(Map<String, Object> newDataProduct, ProdutoDomainResponse product) {
        var objectMapper = new ObjectMapper();

        ProdutoDomainResponse productOrigin = objectMapper.convertValue(newDataProduct, ProdutoDomainResponse.class);

        checkIfIdCategoryExist(productOrigin);
        ProdutoUseCaseUtils.checkActiveForQuantity(productOrigin,product);
        ProdutoUseCaseUtils.checIfActiveForOff(productOrigin,product);
        ProdutoUseCaseUtils.checkIfOffAndPercentageIsNull(productOrigin,product);

        newDataProduct.forEach((name, value) -> {
            Field field = ReflectionUtils.findField(ProdutoDomainResponse.class, name);
            field.setAccessible(true);
            Object newValue = ReflectionUtils.getField(field, productOrigin);
            ReflectionUtils.setField(field, product, newValue);
        });
    }

    private void checkIfIdCategoryExist(ProdutoDomainResponse productOrigin) {
        if (Objects.nonNull(productOrigin.getCategoria())) {
            if (Objects.nonNull(productOrigin.getCategoria().getId())) {
                CategoriaDomainResponse categoriaDomainResponse =
                        categoriaGateway.findCategoryWithId(productOrigin.getCategoria().getId());


                CategoriaUseCaseUtils.checkIfCategoryExistForProduct(productOrigin.getCategoria().getId(), categoriaDomainResponse);
            }
        }
    }
}
