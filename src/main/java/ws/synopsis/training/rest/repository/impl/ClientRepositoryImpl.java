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
        CLIENTS.put(1L, Client.builder().idClient(1L).name("Elvis").lastName("Perez").dni("71202773").build());
        CLIENTS.put(2L, Client.builder().idClient(2L).name("Jhonatan").lastName("Evan\u00E0n").dni("74356664").build());
        CLIENTS.put(3L, Client.builder().idClient(3L).name("Arturo").lastName("Nu\u00F1ez").dni("70202773").build());
        CLIENTS.put(4L, Client.builder().idClient(4L).name("Luis").lastName("Quinto").dni("70282002").build());
    }

    @Override
    public List<Client> list() {
        return CLIENTS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
    }

    @Override
    public boolean add(Client client) {
    	List<Client> clients = CLIENTS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
    	for(Client clientFor :clients) {
    		if(client.getDni().equals(clientFor.getDni())) {
    			return false;
    		}
    	}
        long id = (long) CLIENTS.size() + 1;        
        client.setIdClient(id);
        CLIENTS.put(id, client);
        return true;
    }

    @Override
    public boolean update (Client client){
        Client retrivedClient = CLIENTS.get(client.getIdClient());
        if (retrivedClient==null) return false;
        retrivedClient.setName(client.getName());
        retrivedClient.setLastName(client.getLastName());
        return true;
    }

    @Override
    public void remove(Long clientId) {
        CLIENTS.remove(clientId);
    }
}
