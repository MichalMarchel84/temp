package andrzej.cieslik.ac.end_project.service;

import andrzej.cieslik.ac.end_project.model.Client;
import andrzej.cieslik.ac.end_project.model.Order;
import andrzej.cieslik.ac.end_project.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderService {

    private final OrderRepository orderRepository ;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Map<Client, List<Order>> getOrdersByClient(){
        List<Order> orderList = orderRepository.findAll();
        HashMap<Client,List<Order>> ordersByClients = new HashMap<>();
        for (Order order : orderList){
            getOrCreate(ordersByClients,order.getClient()).add(order);
        }
        return ordersByClients;
    }

    private List<Order> getOrCreate (Map<Client,List<Order>> map, Client client){
        List<Order> list = map.get(client);
        if(list == null){
            list = new ArrayList<>();
            map.put(client,list);
        }
        return list;
    }
}
