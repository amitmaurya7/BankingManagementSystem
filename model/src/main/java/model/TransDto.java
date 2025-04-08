package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransDto {

	private Long txnId;

	private Long accountId;

	@Enumerated(EnumType.STRING)
	private TxnType txnType;

	public enum TxnType {
		DEPOSIT, WITHDRAW, TRANSFER
	}

	private Long amount;

	@Enumerated(EnumType.STRING)
	private TxnStatus txnStatus;

	public enum TxnStatus {
		PENDING, SUCCESS, FAILED
	}

	private String txnDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(new Timestamp(System.currentTimeMillis()));
	private Long toAccountId;
}
