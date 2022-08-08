package andrzej.cieslik.ac.end_project.model;

import org.springframework.stereotype.Component;


public enum OrderState {

    WAITING_FOR_PAYMENT,
    PAYED,
    DELIVERED,
    CANCELED

}
