package kamilolszewski.USD.Markings.model;

import lombok.Data;

import java.util.Date;

@Data
public class Rate {
    private Date effectiveDate;
    private Double bid;
    private Double ask;
}
