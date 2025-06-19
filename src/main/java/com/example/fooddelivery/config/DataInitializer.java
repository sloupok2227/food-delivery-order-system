package com.example.fooddelivery.config;

import com.example.fooddelivery.entity.*;
import com.example.fooddelivery.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(
            ClientRepository clientRepo,
            DeliverymanRepository deliverymanRepo,
            MenuRepository menuRepo,
            OrderRepository orderRepo
    ) {
        return args -> {
            // Клиенты
            Client client1 = new Client();
            client1.setName("Иван");
            client1.setSurname("Иванов");
            client1.setAddress("ул. Ленина, д.1");
            client1.setPhone("+79110001111");

            Client client2 = new Client();
            client2.setName("Мария");
            client2.setSurname("Петрова");
            client2.setAddress("пр. Мира, д.5");
            client2.setPhone("+79220002222");

            clientRepo.saveAll(Arrays.asList(client1, client2));

            // Доставщики
            Deliveryman del1 = new Deliveryman();
            del1.setName("Алексей");
            del1.setSurname("Сидоров");
            del1.setPhone("+79330003333");

            Deliveryman del2 = new Deliveryman();
            del2.setName("Елена");
            del2.setSurname("Орлова");
            del2.setPhone("+79440004444");

            deliverymanRepo.saveAll(Arrays.asList(del1, del2));

            // Меню
            Menu m1 = new Menu();
            m1.setFoodName("Пицца Маргарита");
            m1.setPrice(BigDecimal.valueOf(350));
            m1.setWeight(500);

            Menu m2 = new Menu();
            m2.setFoodName("Суши сет");
            m2.setPrice(BigDecimal.valueOf(1200));
            m2.setWeight(900);

            Menu m3 = new Menu();
            m3.setFoodName("Чизбургер");
            m3.setPrice(BigDecimal.valueOf(220));
            m3.setWeight(250);

            menuRepo.saveAll(Arrays.asList(m1, m2, m3));

            // Заказ
            Order order = new Order();
            order.setClient(client1);
            order.setDeliveryman(del1);
            order.setOrderDate(LocalDateTime.now().minusDays(1));
            order.setWhenDeliver(LocalDateTime.now().plusHours(2));
            order.setNote("Позвонить перед доставкой");

            orderRepo.save(order);
        };
    }
}
