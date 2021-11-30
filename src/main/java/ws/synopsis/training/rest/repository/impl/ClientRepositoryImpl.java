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
        CLIENTS.put(1L, Client.builder().idClient(1L).name("Elvis").lastName("Perez").celular(993819382).build());
        CLIENTS.put(2L, Client.builder().idClient(2L).name("Jhonatan").lastName("Evan\u00E0n").celular(983617383).build());
        CLIENTS.put(3L, Client.builder().idClient(3L).name("Arturo").lastName("Nu\u00F1ez").celular(939137382).build());
        CLIENTS.put(4L, Client.builder().idClient(4L).name("Luis").lastName("Quinto").celular(993133424).build());
    }

    @Override
    public List<Client> list() {
        return CLIENTS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
    }

    @Override
    public boolean add(Client client) {
        for(Map.Entry<Long, Client> m:CLIENTS.entrySet()) {
        	if(m.getValue().getCelular() == client.getCelular()) {
        		return true;
        	}
        }
    	long id = (long) CLIENTS.size() + 1;
        client.setIdClient(id);
        CLIENTS.put(id, client);
        return false;
    }

    @Override
    public boolean update (long clientId,Client client){
    	boolean exists=CLIENTS.containsKey(clientId);
    	
    	if(!exists) {
    		return false;
    	}
    	
        Client retrivedClient = CLIENTS.get(client.getIdClient());
            retrivedClient.setName(client.getName());
            retrivedClient.setLastName(client.getLastName());
            retrivedClient.setCelular(client.getCelular());
        return true;
    }

    @Override
    public void remove(Long clientId) {
        CLIENTS.remove(clientId);
    }
}