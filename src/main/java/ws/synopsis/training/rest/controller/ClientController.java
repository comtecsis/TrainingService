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
import ws.synopsis.training.rest.exception.TrainingFieldException;
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
    public ResponseEntity<?> add(@RequestBody ClientRequest beanReq) throws TrainingFieldException {

        if(StringUtils.isBlank(beanReq.getName())) {
            throw new TrainingFieldException("Nombre no puede estar vac\u00EDo.");
        }

        if(StringUtils.isBlank(beanReq.getLastName())) {
            throw new TrainingFieldException("Apellido no puede estar vac\u00EDo.");
        }

        if(!clientService.add(beanReq)){
        	throw new TrainingFieldException("DNI ya existe en la base de datos.");
        }

        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .build()
        );
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<?> update(@PathVariable("clientId") String clientId, @RequestBody PutClientRequest beanReq) throws TrainingFieldException {
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
        if(!clientService.update(beanReq)) {
        	throw new TrainingFieldException("El ID ingresado no existe en la BD.");
        }

        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .build()
        );
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> delete(@PathVariable("clientId") String clientId) throws TrainingFieldException{
        if( StringUtils.isEmpty(clientId) || !StringUtils.isNumeric(clientId) ) {
            throw new TrainingFieldException("El identidicador debe ser un n\u00FAmero y no puede estar vac\u00EDo.");
        }
        clientService.remove(Long.parseLong(clientId));

        return ResponseEntity.ok(
                GenResponse.builder()
                        .status(StatusEnum.OK.getStatus())
                        .build()
        );
    }

}
