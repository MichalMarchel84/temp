package andrzej.cieslik.ac.end_project.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 50, unique = true)
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    @Column(length = 50)
    private String smallFotoLink;
    @NotBlank
    @Column(length = 50)
    private String fotosLink;
    @NotNull
    private Long deliveryPeriod;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Long quantity;
    @NotNull
    private boolean active;
}
   /* lista w ułożeniu poziomym tzn. obok siebie nr. oferty , zwyczajowa nazwa oferty , opis zawartości przedmiotu oferty  -> link ,
        zdjecie - jeśli dostepne ->link , termin dostawy , cena , przycisk dodaj do koszyka w przycisku il.sztuk*/
/*
widok 3 - strona dodawania oferty
        i nadzoru realizcji przez admininstartora - zmienia status zapłaty i dostawy ,
        widok 4 - strona rejestracji klienta
        widok 5 - widok zawartości koszyka - lista pozioma w postaci pozycja : nr oferty , zwyczajowa nazwa przedmiotu oferty , termin dostawy , ilość , cena łączna
        podsumowanie pozycji z sumą
        poniżej przyciski opcji : edycja pozycji , powrót do widoku 1 , zakup
        widok 6 - zakup -
        wybór : stały klient - wszedł na widoku 1 przez przycisk stałego klienta ,bez podawania danych ;
        klient niezalogowany - podaje dane do wysyłki
        płatność - przelew lub karta - pusty link -
        widok 7 : status zamówienia : lista + info o statusie zapłaty + info o dacie dostawy - sesja do czasu realizacji dostawy*/
