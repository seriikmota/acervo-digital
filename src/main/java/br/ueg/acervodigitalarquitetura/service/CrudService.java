package br.ueg.acervodigitalarquitetura.service;

import br.ueg.acervodigitalarquitetura.domain.BaseModel;

import java.util.List;

public interface CrudService<
        MODEL extends BaseModel<TYPE_PK>, TYPE_PK
        > {
    Class<TYPE_PK> getEntityType();

    List<MODEL> listAll();
    MODEL create(MODEL dado);
    MODEL update(MODEL dado);

    MODEL getById(TYPE_PK id);

    MODEL deleteById(TYPE_PK id);
}
