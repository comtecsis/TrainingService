package ws.synopsis.training.rest.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ws.synopsis.training.rest.bean.request.ClientRequest;
import ws.synopsis.training.rest.bean.request.PutClientRequest;
import ws.synopsis.training.rest.exception.TrainingIdException;
import ws.synopsis.training.rest.exception.TrainingPhoneNotExists;
import ws.synopsis.training.rest.model.Client;
import ws.synopsis.training.rest.repository.ClientRepository;
import ws.synopsis.training.rest.repository.ClientRepositoryV1;
import ws.synopsis.training.rest.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {


    private ClientRepository clientRepository;

    @Override
    public List<Client> list() {
        return (List<Client>) clientRepository.findAll();
    }
    
    

    @Override
    public void add(ClientRequest beanReq) {

        clientRepository.save(
            Client.builder().name(beanReq.getName()).lastName(beanReq.getLastName()).phone(beanReq.getPhone()).build()
        );

    }

    @Override
    public void update(PutClientRequest beanRq) throws TrainingIdException {

        Optional<Client> client = clientRepository.findById(beanRq.getId());

        if(!client.isPresent()) {
            throw new TrainingIdException("El Id del usuario no existe");
        }

    	clientRepository.save(
                Client.builder()
                    .idClient(beanRq.getId())
                    .name(beanRq.getName())
                    .lastName(beanRq.getLastName())
                    .phone(beanRq.getPhone())
                    .build()
        );

    }

    @Override
    public void remove(Long clientId) {
        clientRepository.deleteById(clientId);
    }



	@Override
	public Client listByPhone(Integer phone) throws TrainingPhoneNotExists {
		List<Client> clients = (List<Client>)clientRepository.findAll();
		for(Client client:clients) {
			if(client.getPhone().equals(phone)) return client;
		}
		throw new TrainingPhoneNotExists ("El celular ingresado no se encontro");
	}
    
    

}
