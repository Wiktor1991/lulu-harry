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
                .picture("https://www.gls-eberlein.de/images/product_images/popup_images/5883_0.JPG")
                .build();

        Bread annoDinkel = Bread.builder()
                .name("Harry Anno Dinkel")
                .articleNumber(5604)
                .weight(500)
                .picture("https://img.rewe-static.de/7899987/33083620_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                .build();

        Bread volkorn250 = Bread.builder()
                .name("Volkorntoast")
                .articleNumber(63)
                .weight(250)
                .picture("https://img.rewe-static.de/4922239/5332540_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                .build();

        breadService.addBread(unserMildes);
        breadService.addBread(volkornToast);
        breadService.addBread(annoDinkel);
        breadService.addBread(volkorn250);
    }
}
