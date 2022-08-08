

package andrzej.cieslik.ac.end_project.repository;

import andrzej.cieslik.ac.end_project.model.Client;
import andrzej.cieslik.ac.end_project.model.Order;
import andrzej.cieslik.ac.end_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {





}


