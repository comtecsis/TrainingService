package ws.synopsis.training.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ws.synopsis.training.bean.request.ClientRequest;
import ws.synopsis.training.bean.request.PutClientRequest;
import ws.synopsis.training.bean.response.ClientResponse;
import ws.synopsis.training.exception.TrainingIdException;
import ws.synopsis.training.exception.TrainingPhoneNotExists;
import ws.synopsis.training.model.Client;
import ws.synopsis.training.repository.ClientRepository;
import ws.synopsis.training.service.ClientService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {


    private ClientRepository clientRepository;

    @Override
    public List<ClientResponse> list() {
        return ((List<Client>) clientRepository.findAll()).stream()
            .map(ClientResponse::new)
            .collect(Collectors.toList());
    }
    
    

    @Override
    public void add(ClientRequest beanReq) {

        clientRepository.save(
            Client.builder()
                .name(beanReq.getName())
                .lastName(beanReq.getLastName())
                .phone(beanReq.getPhone())
                .word(beanReq.getWord())
                .build()
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
                    .word(beanRq.getWord())
                    .build()
        );

    }

    @Override
    public void remove(Long clientId) {
        clientRepository.deleteById(clientId);
    }



	@Override
	public ClientResponse listByPhone(Integer phone) throws TrainingPhoneNotExists {
		Optional<Client> client = clientRepository.findByPhone(phone);
        if(client.isPresent()) {
            return new ClientResponse(client.get());
        }
		throw new TrainingPhoneNotExists ("El celular ingresado no se encontro");
	}



	@Override
	public List<ClientResponse> listByLastName(String lastName){
		List<Client> lista=(List<Client>) clientRepository.findByLastName(lastName);
		return lista.stream()
                .map(ClientResponse::new)
                .collect(Collectors.toList());
	}
    
	@Override
	public List<ClientResponse> listByname(String name){
		List<Client> lista = (List<Client>) clientRepository.findByname(name);
		return lista.stream()
                .map(ClientResponse::new)
                .collect(Collectors.toList());
	}

}
