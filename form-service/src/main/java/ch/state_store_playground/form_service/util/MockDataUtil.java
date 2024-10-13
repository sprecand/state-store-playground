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
import java.time.LocalDate;
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

    private static final UUID villaId = UUID.randomUUID();
    private static final UUID seeId = UUID.randomUUID();
    private static final UUID wqId = UUID.randomUUID();

    @PostConstruct
    private void init(){
        realEstateOverviewDtoList.add(new RealEstateOverviewDto()
            .id(villaId)
            .name("Villa am Hang")
            .description("Mit Tennisplatz")
            .address("Zürichbergstrasse 99")
            .cost(20000000));
        realEstateDtoList.add(new RealEstateDto()
            .id(villaId)
            .name("Villa am Hang")
            .description("Mit Tennisplatz")
            .address("Zürichbergstrasse 99")
            .cost(20000000)
            .dateOfSale(LocalDate.now().plusMonths(4)));

        realEstateOverviewDtoList.add(new RealEstateOverviewDto()
            .id(seeId)
            .name("Wohnung am See")
            .description("Migros im Haus")
            .address("Engestrasse 11")
            .cost(3500000));
        realEstateDtoList.add(new RealEstateDto()
            .id(seeId)
            .name("Wohnung am See")
            .description("Migros im Haus")
            .address("Engestrasse 11")
            .cost(3500000)
            .dateOfSale(LocalDate.now().plusMonths(3).plusDays(15)));

        realEstateOverviewDtoList.add(new RealEstateOverviewDto()
            .id(wqId)
            .name("WG im Zentrum")
            .description("Zentrale Lage")
            .address("Langstrasse 90")
            .cost(720));
        realEstateDtoList.add(new RealEstateDto()
            .id(wqId)
            .name("WG im Zentrum")
            .description("Zentrale Lages")
            .address("Langstrasse 90")
            .cost(720)
            .dateOfSale(LocalDate.now().plusMonths(1).plusDays(4)));
        requestOverviewDtoList.add(new RequestOverviewDto()
            .id(UUID.randomUUID())
            .name("Bewerbung für WG Zimmer"));
        requestDtoList.add(new RequestDto()
            .id(UUID.randomUUID())
            .name("Bewerbung für WG Zimmer")
            .detail("Sind Katzen erlaubt?"));
    }
}