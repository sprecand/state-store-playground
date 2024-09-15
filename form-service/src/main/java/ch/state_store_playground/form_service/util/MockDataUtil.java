package ch.state_store_playground.form_service.util;
import org.springframework.stereotype.Component;

import ch.state_store_playground.form_service.dto.ItemDto;
import ch.state_store_playground.form_service.dto.ItemOverviewDto;
import ch.state_store_playground.form_service.dto.RequestDto;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Component
@Getter
@RequiredArgsConstructor
public class MockDataUtil {
    private List<RequestDto> requestDtoList = new ArrayList<>();
    private List<ItemDto> itemDtoList = new ArrayList<>();
    private List<ItemOverviewDto> itemOverviewDtoList = new ArrayList<>();

    @PostConstruct
    private void init(){
        itemOverviewDtoList.add(new ItemOverviewDto().id(UUID.randomUUID()).name("Holzstuhl"));
        itemDtoList.add(new ItemDto().id(UUID.randomUUID()).name("Holzstuhl").detail("Schöner Stuhl aus Holz"));
        itemDtoList.add(new ItemDto().id(UUID.randomUUID()).name("TV").detail("Grosser TV"));
        requestDtoList.add(new RequestDto().id(UUID.randomUUID()).name("Anfrage").detail("Ist der Stuhl defekt?"));
    }
}