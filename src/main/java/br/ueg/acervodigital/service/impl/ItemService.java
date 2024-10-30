package br.ueg.acervodigital.service.impl;

import br.ueg.acervodigital.dto.jasper.ItemJasper;
import br.ueg.acervodigital.dto.list.ItemListDTO;
import br.ueg.acervodigital.dto.request.ItemRequestDTO;
import br.ueg.acervodigital.dto.response.ItemResponseDTO;
import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.mapper.ItemMapper;
import br.ueg.acervodigital.repository.ItemRepository;
import br.ueg.acervodigital.service.IItemService;
import br.ueg.acervodigital.service.IJasperService;
import br.ueg.acervodigital.util.Util;
import br.ueg.acervodigitalarquitetura.dto.CredentialDTO;
import br.ueg.acervodigitalarquitetura.enums.ApiErrorEnum;
import br.ueg.acervodigitalarquitetura.exception.DataException;
import br.ueg.acervodigitalarquitetura.security.impl.CredentialProvider;
import br.ueg.acervodigitalarquitetura.service.impl.AbstractService;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemService extends AbstractService<ItemRequestDTO, ItemResponseDTO, ItemListDTO, Item, ItemRepository, ItemMapper, Long>
        implements IItemService {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private IJasperService jasperService;

    @Override
    protected void prepareToCreate(Item data) {
        User user = new User();
        user.setId(((CredentialDTO) CredentialProvider.newInstance().getCurrentInstance()).getId());
        data.setUser(user);
    }

    @Override
    protected void prepareToUpdate(Item dataDB) {

    }

    @Override
    protected void prepareToDelete(Item dataDB) {

    }

    public List<Item> getByDescription(String description) {
        List<Item> temp = repository.findByNameContaining(description);
        if(temp.isEmpty()){
            throw new DataException(ApiErrorEnum.NOT_FOUND);
        }
        return temp;
    }

    @Override
    public byte[] exportItemsPdf() {
        String file = "/src/main/resources/jasper/AcervoCompleto.jasper";
        List<ItemJasper> itemsJasper = mountObjectsJasper(repository.findAll());
        return exportPdf(file, itemsJasper);
    }

    @Override
    public byte[] exportItemsPdf(Long id) {
        String file = "/src/main/resources/jasper/AcervoIndividual.jasper";
        List<ItemJasper> itemsJasper = mountObjectsJasper(List.of(this.validateIdModelExistsAndGet(id)));
        return exportPdf(file, itemsJasper);
    }

    private byte[] exportPdf(String file, List<ItemJasper> itemsJasper) {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(itemsJasper);
        return jasperService.generatePdf(file, new HashMap<>(), dataSource);
    }

    private List<ItemJasper> mountObjectsJasper(List<Item> items) {
        List<ItemJasper> itemsJasper = new ArrayList<>();

        int count = 0;
        for (Item item : items) {
            count++;
            ItemJasper itemJasper = ItemJasper.builder()
                    .id(item.getId())
                    .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing.")
                    .numberCode(item.getNumberCode())
                    .name(item.getName())
                    .colleactionYear(Util.formatDateYear(item.getColleactionYear()))
                    .provenance(item.getProvenance())
                    .period(item.getPeriod())
                    .location(item.getLocation())
                    .taxonomy(item.getTaxonomy())
                    .collection(item.getCollection())
                    .heritageDate(Util.formatDateWithoutHour(item.getHeritageDate()))
                    .collector(item.getCollector())
                    .taxonomy("taxonomy")
                    .build();
            try {
                if (count == 1) {
                    itemJasper.setImage(Files.newInputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/images/fossil.jpg")));
                } else if (count == 2) {
                    itemJasper.setImage(Files.newInputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/images/fossil2.jpeg")));
                } else if (count == 3) {
                    itemJasper.setImage(Files.newInputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/images/fossil3.jpg")));
                } else {
                    itemJasper.setImage(Files.newInputStream(Path.of(Paths.get("").toAbsolutePath() + "/src/main/resources/images/fossil4.jpeg")));
                    count = 0;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            itemsJasper.add(itemJasper);
        }
        return itemsJasper;
    }
}
