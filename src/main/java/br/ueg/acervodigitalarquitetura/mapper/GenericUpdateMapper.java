package br.ueg.acervodigitalarquitetura.mapper;

import br.ueg.acervodigitalarquitetura.domain.BaseModel;
import org.mapstruct.MappingTarget;

public interface GenericUpdateMapper<
        MODEL extends BaseModel<TYPE_PK>,
        TYPE_PK
        > {
    /**
     * Atualiza o objeto entity com os dados
     * do objeto updateEntity, pegando apenas o atributos
     * preenchidos.
     * @param entity
     * @param updateEntity
     */
    void updateModelFromModel(@MappingTarget MODEL entity, MODEL updateEntity);
}