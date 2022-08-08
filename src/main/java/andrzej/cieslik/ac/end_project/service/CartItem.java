package andrzej.cieslik.ac.end_project.service;

import andrzej.cieslik.ac.end_project.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartItem {
    private Integer quantity;
    private Product product;


}
