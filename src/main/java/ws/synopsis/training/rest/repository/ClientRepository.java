package ws.synopsis.training.rest.repository;

import ws.synopsis.training.rest.model.Client;

import java.util.List;

public interface ClientRepository {
    public List<Client> list();
    public boolean add(Client client);
    public boolean update(Client client);
    public void remove(Long clientId);
}
