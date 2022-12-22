package ma.m0hamedait.accountcqrses.commonAPI.dtos;

import lombok.Data;

@Data
public class CreditAccountRequestDTO {
    private String id;
    private Double amount;
    private String currency;
}
