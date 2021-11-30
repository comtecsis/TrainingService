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
    public void add(ClientRequest beanReq) {
        clientRepository.add(
            Client.builder()
                    .name(beanReq.getName())
                    .lastName(beanReq.getLastName())
                    .cellPhone(beanReq.getCellPhone())
                    .build()
        );
    }

    @Override
    public void update(PutClientRequest beanReq) {
        clientRepository.update(
                Client.builder()
                    .idClient(beanReq.getId())
                    .name(beanReq.getName())
                    .lastName(beanReq.getLastName())
                    .cellPhone(beanReq.getCellPhone())
                    .build()
        );
    }

    @Override
    public void remove(Long clientId) {
        clientRepository.remove(clientId);
    }

}
