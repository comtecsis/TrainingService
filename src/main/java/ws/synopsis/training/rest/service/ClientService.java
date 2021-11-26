package ws.synopsis.training.rest.service;

import ws.synopsis.training.rest.bean.request.ClientRequest;
import ws.synopsis.training.rest.model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> list();
    public void add(ClientRequest beanReq);
}
