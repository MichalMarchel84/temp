package andrzej.cieslik.ac.end_project.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="orderItem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private BigDecimal price;
    private int quantity;
    @ManyToOne
    private Order order;


}
