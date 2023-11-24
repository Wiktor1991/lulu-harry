package com.example.luluharry.dataInit;

import com.example.luluharry.domain.Bread;
import com.example.luluharry.domain.Day;
import com.example.luluharry.services.BreadService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.HashMap;

@Component
public class DataInitializer {

    private final BreadService breadService;

    public DataInitializer(BreadService breadService) {
        this.breadService = breadService;
    }

    @Bean
    public void addSampleBreads() {

        HashMap<Day,Integer> sampleOrders = new HashMap<>();
        sampleOrders.put(Day.MON,12);
        sampleOrders.put(Day.TUE,18);
        sampleOrders.put(Day.WEN,4);
        sampleOrders.put(Day.THU,2);
        sampleOrders.put(Day.SAT,9);


        HashMap<Day,Integer> sample2 = new HashMap<>(sampleOrders);
        sample2.put(Day.MON,2);
        sample2.put(Day.TUE,24);
        sample2.put(Day.WEN,17);
        sample2.put(Day.SAT,55);


        Bread unserMildes = Bread.builder()
                .name("UnserMildes")
                .articleNumber(87)
                .weight(500)
                .picture("https://img.rewe-static.de/4923685/5332580_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                .orders(sampleOrders)
                .build();

        Bread volkornToast = Bread.builder()
                .name("Harry Volkorntoast")
                .articleNumber(64)
                .weight(500)
                .picture("https://www.gls-eberlein.de/images/product_images/popup_images/5883_0.JPG")
                .orders(sample2)
                .build();

        Bread annoDinkel = Bread.builder()
                .name("Harry Anno Dinkel")
                .articleNumber(5604)
                .weight(500)
                .picture("https://img.rewe-static.de/7899987/33083620_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                .orders(sampleOrders)
                .build();

        Bread volkorn250 = Bread.builder()
                .name("Volkorntoast")
                .articleNumber(63)
                .weight(250)
                .picture("https://img.rewe-static.de/4922239/5332540_digital-image.png?impolicy=s-products&imwidth=1080&output-format=image/webp")
                .orders(sample2)
                .build();

        breadService.addBread(unserMildes);
        breadService.addBread(volkornToast);
        breadService.addBread(annoDinkel);
        breadService.addBread(volkorn250);
    }
}
