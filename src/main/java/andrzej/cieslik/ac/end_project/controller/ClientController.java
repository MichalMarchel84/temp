package andrzej.cieslik.ac.end_project.controller;

import andrzej.cieslik.ac.end_project.model.Client;
import andrzej.cieslik.ac.end_project.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("client-form")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("clients", clientRepository.findAll());
        return "clients/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("clients", new Client());
        return "clients/add";
    }
    @PostMapping("/add")
    public String save(Client client){
        clientRepository.save(client);
        return "redirect:/client-form/list";
    }
    @GetMapping("/delete/{id}")
    //@ResponseBody
    public String delete(@PathVariable long id) {
        clientRepository.deleteById(id);
        return "redirect:/client-form/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable long id){
        model.addAttribute("clients",clientRepository.findById(id));
        return "clients/edit";
    }
    @PostMapping("/update")
    public String update(@Valid Client client, BindingResult result,Model model) {
        if(result.hasErrors()){
            model.addAttribute("clients",clientRepository.findById(client.getId()));
            return "clients/edit";
        }
        clientRepository.save(client);
        return "redirect:/client-form/list";
    }


}
