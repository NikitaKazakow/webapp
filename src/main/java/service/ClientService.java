package service;

import dao.impl.ClientDaoImpl;
import entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private static final ClientDaoImpl clientDao = new ClientDaoImpl();

    public List<ClientEntity> getAll() {
        return clientDao.getAll();
    }

    public boolean isClientExists(String id) {
        boolean result = false;
        Optional<ClientEntity> clientEntityOptional = clientDao.get(id);
        if (clientEntityOptional.isPresent()) {
            result = true;
        }
        return result;
    }

    public void delete(String id) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setPassportNumber(id);
        clientDao.delete(clientEntity);
    }

    public void add(ClientEntity client) {
        clientDao.save(client);
    }

    public void update(ClientEntity clientEntity) {
        clientDao.update(clientEntity);
    }

    public Optional<ClientEntity> get(String id) {
        return clientDao.get(id);
    }
}
