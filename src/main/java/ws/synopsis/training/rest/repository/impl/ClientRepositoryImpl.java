package ws.synopsis.training.rest.repository.impl;

import org.springframework.stereotype.Repository;
import ws.synopsis.training.rest.model.Client;
import ws.synopsis.training.rest.repository.ClientRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private static final Map<Long, Client> CLIENTS;

    static {
        CLIENTS = new HashMap<Long, Client>();
        CLIENTS.put(1L, Client.builder().idClient(1L).name("Elvis").lastName("Perez").build());
        CLIENTS.put(2L, Client.builder().idClient(2L).name("Jhonatan").lastName("Evan\u00E0n").build());
        CLIENTS.put(3L, Client.builder().idClient(3L).name("Arturo").lastName("Nu\u00F1ez").build());
        CLIENTS.put(4L, Client.builder().idClient(4L).name("Luis").lastName("Quinto").build());
    }

    @Override
    public List<Client> list() {
        return CLIENTS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
    }

    @Override
    public void add(Client client) {
        long id = (long) CLIENTS.size();
        client.setIdClient(id);
        CLIENTS.put(id, client);
    }
}
