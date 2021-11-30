package ws.synopsis.training.rest.repository;

import ws.synopsis.training.rest.exception.TrainingFieldException;
import ws.synopsis.training.rest.model.Client;

import java.util.List;

public interface ClientRepository {
    public List<Client> list();
    public void add(Client client);
    public void update(Client client) throws TrainingFieldException;
    public void remove(Long clientId);
}
