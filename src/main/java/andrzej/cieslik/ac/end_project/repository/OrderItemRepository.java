package andrzej.cieslik.ac.end_project.repository;

import andrzej.cieslik.ac.end_project.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    /*@Transactional
   public void insertWithQuery(OrderItem orderItem){

    }*/
}
