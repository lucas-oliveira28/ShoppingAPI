package com.lucasmonteiro.shoppingapi.config;

import com.lucasmonteiro.shoppingapi.entities.*;
import com.lucasmonteiro.shoppingapi.entities.enums.OrderStatus;
import com.lucasmonteiro.shoppingapi.entities.enums.ShippingType;
import com.lucasmonteiro.shoppingapi.entities.enums.UserLevel;
import com.lucasmonteiro.shoppingapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Lucas Monteiro", "lucas.monteiro@gmail.com", "12345", UserLevel.ADMIN);
        User u2 = new User(null, "João Silva", "joao.silva@gmail.com", "12345", UserLevel.EMPLOYEE);
        User u3 = new User(null, "Augusto Renan", "augusto.renan@gmail.com", "12345", UserLevel.CLIENT);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Payment pay1 = new Payment(null, Instant.now(), o1);
        Payment pay2 = new Payment(null, Instant.now(), o2);
        Payment pay3 = new Payment(null, Instant.now(), o3);

        o1.setPayment(pay1);
        o2.setPayment(pay2);
        o3.setPayment(pay3);

        ShippingInfo si1 = new ShippingInfo(null, ShippingType.PRIORITY, 200.0, "1234567", "321", o1);
        ShippingInfo si2 = new ShippingInfo(null, ShippingType.ECONOMIC, 200.0, "1234567", "321", o2);
        ShippingInfo si3 = new ShippingInfo(null, ShippingType.LOCAL_DELIVERY, 200.0, "1234567", "321", o3);

        o1.setShippingInfo(si1);
        o2.setShippingInfo(si2);
        o3.setShippingInfo(si3);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        ShoppingCart oi1 = new ShoppingCart(o1, p1, 2, p1.getPrice());
        ShoppingCart oi2 = new ShoppingCart(o1, p3, 1, p3.getPrice());
        ShoppingCart oi3 = new ShoppingCart(o2, p3, 2, p3.getPrice());
        ShoppingCart oi4 = new ShoppingCart(o3, p5, 2, p5.getPrice());

        shoppingCartRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));


    }
}
