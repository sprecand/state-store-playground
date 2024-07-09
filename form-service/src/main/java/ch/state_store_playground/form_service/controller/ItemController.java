package ch.state_store_playground.form_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ch.state_store_playground.form_service.dto.ItemDto;
import ch.state_store_playground.form_service.dto.ItemOverviewDto;
import ch.state_store_playground.form_service.util.MockDataUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ItemController implements ItemsApi{
    private final MockDataUtil mockDataUtil;

    @Override
    public ResponseEntity<ItemDto> _findItemById(String itemId) {
        return ResponseEntity.ok(mockDataUtil.getItemDtoList().get(0));
    }

    @Override
    public ResponseEntity<List<ItemOverviewDto>> _findItems() {
        return ResponseEntity.ok(mockDataUtil.getItemOverviewDtoList());
    }
}
