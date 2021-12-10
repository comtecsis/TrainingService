package ws.synopsis.training.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.bean.request.LoginRequest;
import ws.synopsis.training.bean.response.ClientResponse;
import ws.synopsis.training.bean.response.base.GenResponse;
import ws.synopsis.training.exception.TrainingLogicException;
import ws.synopsis.training.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1/login")
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping(value = "")
    public ResponseEntity<?> login(@RequestBody LoginRequest login,
                                   HttpServletRequest request) throws TrainingLogicException, SQLException {
        GenResponse<ClientResponse> beanService = loginService.login(login);
        return ResponseEntity.ok(beanService);
    }

}