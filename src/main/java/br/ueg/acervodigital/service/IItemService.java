package br.ueg.acervodigital.service;

public interface IItemService {
    byte[] exportItemsPdf();
    byte[] exportItemsPdf(Long id);
}
