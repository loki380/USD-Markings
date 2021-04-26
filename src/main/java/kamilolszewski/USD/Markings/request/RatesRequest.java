package kamilolszewski.USD.Markings.request;

import kamilolszewski.USD.Markings.model.Rate;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class RatesRequest {
    private String currency;
    private String code;
    private List<Rate> rates;
}
