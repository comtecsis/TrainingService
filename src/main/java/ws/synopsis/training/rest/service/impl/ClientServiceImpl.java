package ws.synopsis.training.rest.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.training.rest.bean.request.ClientRequest;
import ws.synopsis.training.rest.bean.request.PutClientRequest;
import ws.synopsis.training.rest.model.Client;
import ws.synopsis.training.rest.repository.ClientRepository;
import ws.synopsis.training.rest.service.ClientService;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public List<Client> list() {
        return clientRepository.list();
    }

    @Override
    public boolean add(ClientRequest beanReq) {
    	if (
        clientRepository.add(
            Client.builder().name(beanReq.getName()).lastName(beanReq.getLastName()).dni(beanReq.getDni()).build()
        )) {
    		return true;
    	}
    	return false;
    }

    @Override
    public boolean update(PutClientRequest beanRq) {
    	if(
        clientRepository.update(
                Client.builder()
                    .idClient(beanRq.getId())
                    .name(beanRq.getName())
                    .lastName(beanRq.getLastName())
                    .build()
        )) return true;
    	return false;
    }

    @Override
    public void remove(Long clientId) {
        clientRepository.remove(clientId);
    }

}
