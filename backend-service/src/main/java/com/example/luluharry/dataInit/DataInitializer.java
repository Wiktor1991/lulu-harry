package com.example.luluharry.dataInit;

import com.example.luluharry.domain.Bread;
import com.example.luluharry.services.BreadService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final BreadService breadService;

    public DataInitializer(BreadService breadService) {
        this.breadService = breadService;
    }

    @Bean
    public void addSampleBreads() {

        Bread unserMildes = Bread.builder()
                .name("UnserMildes")
                .articleNumber(87)
                .weight(500)
                .picture("https://img.rewe-static.de/4923685/5332580_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                .build();

        Bread volkornToast = Bread.builder()
                .name("Harry Volkorntoast")
                .articleNumber(64)
                .weight(500)
                .picture("https://shop.rewe.de/p/harry-vollkorn-toast-500g/4922506")
                .build();

        Bread annoDinkel = Bread.builder()
                .name("Harry Anno Dinkel")
                .articleNumber(5604)
                .weight(500)
                .picture("https://img.rewe-static.de/7899987/33083620_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                .build();

        breadService.addBread(unserMildes);
        breadService.addBread(volkornToast);
        breadService.addBread(annoDinkel);
    }
}
