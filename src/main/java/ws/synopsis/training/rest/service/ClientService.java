package ws.synopsis.training.rest.service;

import ws.synopsis.training.rest.bean.request.ClientRequest;
import ws.synopsis.training.rest.bean.request.PutClientRequest;
import ws.synopsis.training.rest.bean.response.ClientResponse;
import ws.synopsis.training.rest.exception.TrainingIdException;
import ws.synopsis.training.rest.exception.TrainingPhoneNotExists;
import ws.synopsis.training.rest.model.Client;

import java.util.List;

public interface ClientService {
    public List<ClientResponse> list();
    public ClientResponse listByPhone(Integer phone) throws TrainingPhoneNotExists ;
    public List<ClientResponse> listByLastName(String lastName);
    public void add(ClientRequest beanReq);
    public void update(PutClientRequest beanRq) throws TrainingIdException;
    public void remove(Long clienteId);
    public List<ClientResponse> listByname(String name);

}
