package ch.state_store_playground.form_service.util;
import org.springframework.stereotype.Component;

import ch.state_store_playground.form_service.dto.RealEstateDto;
import ch.state_store_playground.form_service.dto.RealEstateOverviewDto;
import ch.state_store_playground.form_service.dto.RequestDto;
import ch.state_store_playground.form_service.dto.RequestOverviewDto;
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
    private List<RequestOverviewDto> requestOverviewDtoList = new ArrayList<>();
    private List<RequestDto> requestDtoList = new ArrayList<>();
    private List<RealEstateDto> realEstateDtoList = new ArrayList<>();
    private List<RealEstateOverviewDto> realEstateOverviewDtoList = new ArrayList<>();

    @PostConstruct
    private void init(){
        realEstateOverviewDtoList.add(new RealEstateOverviewDto().id(UUID.randomUUID()).name("Villa am Hang").description("Mit Tennisplatz"));
        realEstateOverviewDtoList.add(new RealEstateOverviewDto().id(UUID.randomUUID()).name("Wohnung am See").description("Migros im Haus"));
        realEstateOverviewDtoList.add(new RealEstateOverviewDto().id(UUID.randomUUID()).name("WG im Zentrum"));
        realEstateDtoList.add(new RealEstateDto().id(UUID.randomUUID()).name("Villa am Hang").description("Mit Tennisplatz"));
        realEstateDtoList.add(new RealEstateDto().id(UUID.randomUUID()).name("Wohnung am See").description("Migros im Haus"));
        requestOverviewDtoList.add(new RequestOverviewDto().id(UUID.randomUUID()).name("Bewerbung für WG Zimmer"));
        requestDtoList.add(new RequestDto().id(UUID.randomUUID()).name("Bewerbung für WG Zimmer").detail("Sind Katzen erlaubt?"));
    }
}