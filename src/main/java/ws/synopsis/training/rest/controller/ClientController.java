package ws.synopsis.training.rest.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.rest.bean.request.ClientRequest;
import ws.synopsis.training.rest.bean.request.PutClientRequest;
import ws.synopsis.training.rest.exception.TrainingFieldException;
import ws.synopsis.training.rest.model.Client;
import ws.synopsis.training.rest.service.ClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("")
    public List<Client> list() {
        return clientService.list();
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody ClientRequest beanReq) throws TrainingFieldException {

        if(StringUtils.isBlank(beanReq.getName())) {
            throw new TrainingFieldException("Nombre no puede estar vac\u00EDo.");
        }

        if(StringUtils.isBlank(beanReq.getLastName())) {
            throw new TrainingFieldException("Apellido no puede estar vac\u00EDo.");
        }

        if(StringUtils.isBlank(beanReq.getPhoneNumber())) {
            throw new TrainingFieldException("Telefono no puede estar vac\u00EDo.");
        }

        clientService.add(beanReq);
        return ResponseEntity.ok().build();
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

        if(StringUtils.isBlank(beanReq.getPhoneNumber())) {
            throw new TrainingFieldException("Telefono no puede estar vac\u00EDo.");
        }

        beanReq.setId(Long.parseLong(clientId));
        clientService.update(beanReq);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> delete(@PathVariable("clientId") String clientId) throws TrainingFieldException{
        if( StringUtils.isEmpty(clientId) || !StringUtils.isNumeric(clientId) ) {
            throw new TrainingFieldException("El identidicador debe ser un n\u00FAmero y no puede estar vac\u00EDo.");
        }
        clientService.remove(Long.parseLong(clientId));
        return ResponseEntity.ok().build();
    }

}
