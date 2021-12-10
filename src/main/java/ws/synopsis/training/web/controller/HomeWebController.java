package ws.synopsis.training.web.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping("")
public class HomeWebController {

    @GetMapping
    public String index(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("name", name);
        return "index/index";
    }

}
