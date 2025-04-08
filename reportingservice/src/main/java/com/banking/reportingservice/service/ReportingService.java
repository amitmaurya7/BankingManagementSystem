package com.banking.reportingservice.service;

import java.util.List;

import com.banking.reportingservice.dto.StatementDto;
import model.TransDto;

public interface ReportingService {

	List<TransDto> getTransactions(StatementDto statement);
}
