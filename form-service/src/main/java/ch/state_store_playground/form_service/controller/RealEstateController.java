package ch.state_store_playground.form_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ch.state_store_playground.form_service.dto.RealEstateDto;
import ch.state_store_playground.form_service.dto.RealEstateOverviewDto;
import ch.state_store_playground.form_service.util.MockDataUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RealEstateController implements RealEstateApi{
    private final MockDataUtil mockDataUtil;

    @Override
    public ResponseEntity<List<RealEstateOverviewDto>> _findRealEstate() {
        return ResponseEntity.ok(mockDataUtil.getRealEstateOverviewDtoList());
    }

    @Override
    public ResponseEntity<RealEstateDto> _findRealEstateById(String realEstateId) {
        return ResponseEntity.ok(mockDataUtil.getRealEstateDtoList().get(0));
    }
}
