package ws.synopsis.training.rest.repository;

import ws.synopsis.training.rest.model.Client;

import java.util.List;

public interface ClientRepositoryV1 {
    public List<Client> list();
    public boolean add(Client client);
    public boolean update(long idCliente,Client client);
    public void remove(Long clientId);
}
