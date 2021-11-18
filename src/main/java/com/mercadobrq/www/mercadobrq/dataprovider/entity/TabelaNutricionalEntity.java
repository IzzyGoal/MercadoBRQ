package com.mercadobrq.www.mercadobrq.dataprovider.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@Builder
public class TabelaNutricionalEntity {

    @Column(name = "tab_valor_energetico")
    private String valorEnergetico;

    @Column(name = "tab_gordura_saturada")
    private String gorduraSaturada;

    @Column(name = "tab_sodio")
    private String sodio;

    @Column(name = "tab_acucar")
    private String acucar;

    @Column(name = "tab_proteinas")
    private String proteinas;

    @Column(name = "tab_fibras")
    private String fibras;

}
