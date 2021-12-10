package ws.synopsis.training.service;

import ws.synopsis.training.bean.request.ClientRequest;
import ws.synopsis.training.bean.request.PutClientRequest;
import ws.synopsis.training.bean.response.ClientResponse;
import ws.synopsis.training.exception.TrainingIdException;
import ws.synopsis.training.exception.TrainingPhoneNotExists;

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
