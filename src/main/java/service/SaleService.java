package service;

import dao.impl.SaleDaoImpl;
import entity.SaleEntity;

import java.util.List;

public class SaleService {
    private static final SaleDaoImpl saleDao = new SaleDaoImpl();

    public void addSale(SaleEntity sale) {

    }

    public List<SaleEntity> getAll() {
        return saleDao.getAll();
    }
}
