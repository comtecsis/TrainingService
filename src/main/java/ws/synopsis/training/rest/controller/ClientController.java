package ws.synopsis.training.rest.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.rest.bean.request.ClientRequest;
import ws.synopsis.training.rest.bean.request.PutClientRequest;
import ws.synopsis.training.rest.bean.response.base.GenResponse;
import ws.synopsis.training.rest.enumeration.StatusEnum;
import ws.synopsis.training.rest.exception.TrainingCelularException;
import ws.synopsis.training.rest.exception.TrainingFieldException;
import ws.synopsis.training.rest.exception.TrainingIdException;
import ws.synopsis.training.rest.exception.TrainingPhoneNotExists;
import ws.synopsis.training.rest.model.Client;
import ws.synopsis.training.rest.service.ClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/clients")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    @GetMapping("")
    public ResponseEntity<?> list() {
        List<Client> clients = clientService.list();
        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .data(clients)
                        .build()
        );
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody ClientRequest beanReq) throws TrainingFieldException, TrainingCelularException {

        if(StringUtils.isBlank(beanReq.getName())) {
            throw new TrainingFieldException("Nombre no puede estar vac\u00EDo.");
        }

        if(StringUtils.isBlank(beanReq.getLastName())) {
            throw new TrainingFieldException("Apellido no puede estar vac\u00EDo.");
        }

        clientService.add(beanReq);

        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .build()
        );
    }
    
    @GetMapping("/filter/phone/{phone}")
    public ResponseEntity<?> listByPhone(@PathVariable("phone") Integer phone) throws TrainingPhoneNotExists {
        Client client = clientService.listByPhone(phone);
        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .data(client)
                        .build()
        );
    }
    
    @GetMapping("/filter/lastName/{lastName}")
    public ResponseEntity<?> listByLastName(@PathVariable("lastName") String lastName) throws TrainingFieldException {
        
        
        if(StringUtils.isBlank(lastName) || StringUtils.isNumeric(lastName)) {
        	throw new TrainingFieldException("El apellido debe ser un n\u00FAmero y no puede estar vac\u00EDo.");
        }
        
        List<Client> clients = clientService.listByLastName(lastName);
        
        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .data(clients)
                        .build()
        );
       
    }
    
    @PutMapping("/{clientId}")
    public ResponseEntity<?> update(@PathVariable("clientId") String clientId, @RequestBody PutClientRequest beanReq) throws TrainingFieldException,TrainingIdException {
        if( StringUtils.isEmpty(clientId) || !StringUtils.isNumeric(clientId) ) {
            throw new TrainingFieldException("El identidicador debe ser un n\u00FAmero y no puede estar vac\u00EDo.");
        }

        if( StringUtils.isBlank(beanReq.getName()) ) {
            throw new TrainingFieldException("Nombre no puede estar vac\u00EDo.");
        }

        if( StringUtils.isBlank(beanReq.getLastName()) ) {
            throw new TrainingFieldException("Apellido no puede estar vac\u00EDo.");
        }

        beanReq.setId(Long.parseLong(clientId));
        clientService.update(beanReq);

        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .build()
        );
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> delete(@PathVariable("clientId") String clientId) throws TrainingFieldException{
        if( StringUtils.isEmpty(clientId) || !StringUtils.isNumeric(clientId) ) {
            throw new TrainingFieldException("El identificador debe ser un n\u00FAmero y no puede estar vac\u00EDo.");
        }
        clientService.remove(Long.parseLong(clientId));

        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .build()
        );
    }
    
    @GetMapping("/filter/name/{name}")
    public ResponseEntity<?> listByname(@PathVariable("name") String name) throws TrainingFieldException {
        
        
        if(StringUtils.isBlank(name) || StringUtils.isNumeric(name)) {
        	throw new TrainingFieldException("El nombre no puede estar vac\u00EDo.");
        }
        
        List<Client> clients = clientService.listByname(name);
        
        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .data(clients)
                        .build()
        );
    }
}
