package br.ueg.acervodigitalarquitetura.mapper;

import br.ueg.acervodigitalarquitetura.domain.BaseModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface GenericMapper<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        MODEL extends BaseModel<TYPE_PK>,
        TYPE_PK
        > extends GenericUpdateMapper<MODEL, TYPE_PK> {
    MODEL toModel(DTO dto);
    MODEL fromModelCreatedToModel(DTOCreate dtoCreate);

    MODEL fromModelUpdatedToModel(DTOUpdate dtoUpdate);



    DTO toDTO(MODEL model);

    @Named(value = "toDTOList") // para identificar o nome desse método pelo mapstruct
    DTOList toDTOList(MODEL model);

    @IterableMapping(qualifiedByName = "toDTOList") // para orientar qual método utilizar no caso de vários target=source;
    List<DTOList> fromModelToDTOList(List<MODEL> modelList);
}