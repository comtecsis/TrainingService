package ws.synopsis.training.web.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ws.synopsis.training.web.bean.request.IndexRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping("")
public class HomeWebController {

    @GetMapping
    public String index(Model model, IndexRequest request) {
        String name = request.getName() ;
        model.addAttribute("name", name);
        return "index/index";
    }

}
