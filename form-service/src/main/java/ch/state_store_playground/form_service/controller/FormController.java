package ch.state_store_playground.form_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ch.state_store_playground.form_service.dto.Form1Dto;
import ch.state_store_playground.form_service.dto.Form2Dto;
import ch.state_store_playground.form_service.dto.Form3Dto;
import ch.state_store_playground.form_service.dto.RequestDto;
import ch.state_store_playground.form_service.util.MockDataUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FormController implements RequestsApi {
	private final MockDataUtil mockDataUtil;

	@Override
	public ResponseEntity<RequestDto> _createSubRequest(String requestId, @Valid RequestDto requestDto) {
		mockDataUtil.getRequestDtoList().add(requestDto);
		return ResponseEntity.ok(requestDto);
	}

	@Override
	public ResponseEntity<Void> _deleteRequest(String requestId) {
		mockDataUtil.getRequestDtoList().removeIf(savedRequest -> savedRequest.getId().toString() == requestId);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Form1Dto> _getForm1(String requestId) {
		return ResponseEntity.ok(new Form1Dto());
	}

	@Override
	public ResponseEntity<Form2Dto> _getForm2(String requestId) {
		return ResponseEntity.ok(new Form2Dto());
	}

	@Override
	public ResponseEntity<Form3Dto> _getForm3(String requestId) {
		return ResponseEntity.ok(new Form3Dto());
	}

	@Override
	public ResponseEntity<RequestDto> _getRequestById(String requestId) {
		return ResponseEntity.ok(mockDataUtil.getRequestDtoList().get(0));
	}

	@Override
	public ResponseEntity<List<RequestDto>> _listRequests() {
		return ResponseEntity.ok(mockDataUtil.getRequestDtoList());
	}

	@Override
	public ResponseEntity<Form1Dto> _updateForm1(String requestId, @Valid Form1Dto form1Dto) {
		return ResponseEntity.ok(new Form1Dto().text1("some text"));
	}

	@Override
	public ResponseEntity<Form2Dto> _updateForm2(String requestId, @Valid Form2Dto form2Dto) {
		return ResponseEntity.ok(new Form2Dto().text1("some text"));
	}

	@Override
	public ResponseEntity<Form3Dto> _updateForm3(String requestId, @Valid Form3Dto form3Dto) {
		return ResponseEntity.ok(new Form3Dto().text1("some text"));
	}

	@Override
	public ResponseEntity<RequestDto> _updateRequest(String requestId, @Valid RequestDto requestDto) {
		return ResponseEntity.ok(mockDataUtil.getRequestDtoList().get(0));
	}
}