package ws.synopsis.training.repository.impl;

import ws.synopsis.training.model.Client;
import ws.synopsis.training.repository.ClientRepositoryV1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClientRepositoryV1Impl implements ClientRepositoryV1 {

    private static final Map<Long, Client> CLIENTS;

    static {
        CLIENTS = new HashMap<Long, Client>();
        CLIENTS.put(1L, Client.builder().idClient(1L).name("Elvis").lastName("Perez").phone(993819382).build());
        CLIENTS.put(2L, Client.builder().idClient(2L).name("Jhonatan").lastName("Evan\u00E0n").phone(983617383).build());
        CLIENTS.put(3L, Client.builder().idClient(3L).name("Arturo").lastName("Nu\u00F1ez").phone(939137382).build());
        CLIENTS.put(4L, Client.builder().idClient(4L).name("Luis").lastName("Quinto").phone(993133424).build());
    }

    @Override
    public List<Client> list() {
        return CLIENTS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
    }

    @Override
    public boolean add(Client client) {
        for(Map.Entry<Long, Client> m:CLIENTS.entrySet()) {
        	if(m.getValue().getPhone().equals(client.getPhone())) {
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
            retrivedClient.setPhone(client.getPhone());
        return true;
    }

    @Override
    public void remove(Long clientId) {
        CLIENTS.remove(clientId);
    }
}