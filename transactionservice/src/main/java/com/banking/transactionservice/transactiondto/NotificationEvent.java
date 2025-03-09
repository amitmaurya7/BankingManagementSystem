package com.banking.transactionservice.transactiondto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEvent {

	private Long userId;
	private String message;
	
	@Enumerated(EnumType.STRING)
	private NotificationType type;
	
	public enum NotificationType{
		EMAIL,
		SMS
	}
}
