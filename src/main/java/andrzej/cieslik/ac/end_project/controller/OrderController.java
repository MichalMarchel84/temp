

package andrzej.cieslik.ac.end_project.controller;

import andrzej.cieslik.ac.end_project.model.Order;
import andrzej.cieslik.ac.end_project.repository.ClientRepository;
import andrzej.cieslik.ac.end_project.repository.OrderRepository;
import andrzej.cieslik.ac.end_project.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("order-form")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderService orderService;


    public OrderController(OrderRepository orderRepository, ClientRepository clientRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;

        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute( "orders",  orderService.getOrdersByClient());
        return "orders/list";
    }

    @GetMapping("/change_order_status")
    public String changeStatus(Model model, @RequestParam Long id, @RequestParam Enum state){

        model.addAttribute("state",state);
        return "orders/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("orders", new Order());
        return "orders/add";
    }
    @PostMapping("/add")
    public String save(Order order){
        orderRepository.save(order);
        return "redirect:/order-form/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        orderRepository.deleteById(id);
        return "redirect:/order-form/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable long id){
        model.addAttribute("orders",orderRepository.findById(id));
        return "order/edit";
    }
       @PostMapping("/update")
    public String update(@Valid Order order, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("orders",orderRepository.findById(order.getId()));
            return "clients/edit";
        }
        orderRepository.save(order);
        return "redirect:/order-form/list";
    }
}


