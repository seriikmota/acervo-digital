package br.ueg.acervodigital.service;

import br.ueg.acervodigital.dto.request.ItemRequestDTO;
import br.ueg.acervodigital.entities.Item;
import br.ueg.genericarchitecture.service.IAbstractService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IItemService extends IAbstractService<ItemRequestDTO, Item, Long> {
    byte[] exportItemsPdf() throws JRException;
    byte[] exportItemsPdf(Long id) throws JRException;
    Page<Item> getByDescription(String description, Pageable pageable);
    Page<Item> listAllWithoutRole(Pageable pageable);
}
