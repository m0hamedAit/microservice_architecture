package ma.m0hamedAit.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class Account {
    private int code;
    private double solde;
    private Date dateCreation;
}
