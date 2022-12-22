package ma.m0hamedait.accountcqrses.commonAPI.dtos;

import lombok.Data;

@Data
public class DebitAccountRequestDTO {
    private String id;
    private Double amount;
    private String currency;
}
