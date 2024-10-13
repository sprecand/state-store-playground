package ch.state_store_playground.form_service.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ch.state_store_playground.form_service.dto.FinancialFormDto;
import ch.state_store_playground.form_service.dto.PersonaFormDto;
import ch.state_store_playground.form_service.dto.QuestionFormDto;
import ch.state_store_playground.form_service.dto.RequestDto;
import ch.state_store_playground.form_service.dto.RequestOverviewDto;
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
	public ResponseEntity<PersonaFormDto> _getPersonaForm(String requestId) {
		return ResponseEntity.ok(new PersonaFormDto());
	}

	@Override
	public ResponseEntity<FinancialFormDto> _getFinancialForm(String requestId) {
		return ResponseEntity.ok(new FinancialFormDto());
	}

	@Override
	public ResponseEntity<QuestionFormDto> _getQuestionForm(String requestId) {
		return ResponseEntity.ok(new QuestionFormDto());
	}

	@Override
	public ResponseEntity<RequestDto> _findRequestById(String requestId) {
		return ResponseEntity.ok(mockDataUtil.getRequestDtoList().get(0));
	}

	@Override
	public ResponseEntity<List<RequestOverviewDto>> _listRequests() {
		return ResponseEntity.ok(mockDataUtil.getRequestOverviewDtoList());
	}

	@Override
	public ResponseEntity<PersonaFormDto> _updatePersonaForm(String requestId, @Valid PersonaFormDto personaFormDto) {
		return ResponseEntity.ok(new PersonaFormDto().firstName("some text"));
	}

	@Override
	public ResponseEntity<FinancialFormDto> _updateFinancialForm(String requestId, @Valid FinancialFormDto financialFormDto) {
		return ResponseEntity.ok(new FinancialFormDto().yearlyIncome(new BigDecimal(100000)));
	}

	@Override
	public ResponseEntity<QuestionFormDto> _updateQuestionForm(String requestId, @Valid QuestionFormDto questionFormDto) {
		return ResponseEntity.ok(new QuestionFormDto().question("Are cats allowed?"));
	}

	@Override
	public ResponseEntity<RequestDto> _updateRequest(String requestId, @Valid RequestDto requestDto) {
		return ResponseEntity.ok(mockDataUtil.getRequestDtoList().get(0));
	}
}