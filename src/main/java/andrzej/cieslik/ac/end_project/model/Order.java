package andrzej.cieslik.ac.end_project.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @NotBlank
    private OrderState orderState;

    @Override
    public int hashCode() {
        return Long.hashCode(id) ;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Order )){
            return false;
        }
        Order that = (Order) obj;

        return id.equals(that.id);
    }
}
