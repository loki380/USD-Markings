package kamilolszewski.USD.Markings.service;

import kamilolszewski.USD.Markings.model.Rate;
import kamilolszewski.USD.Markings.request.RatesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RateService {
    public List<Rate> rate(String data)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        final String uri = "http://api.nbp.pl/api/exchangerates/rates/C/USD/"+data+"/"+dtf.format(now);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<RatesRequest> response = restTemplate.getForEntity(uri, RatesRequest.class);

        List<Rate> rates = response.getBody().getRates();

        return rates;
    }
    public Double calculateDifferenceBid(List<Rate> rates, Integer index)
    {
        if(index != 0){
            Double z = rates.get(index).getBid()-rates.get(index-1).getBid();
            return z;
        }else{
            return 0.0;
        }
    }
    public Double calculateDifferenceAsk(List<Rate> rates, Integer index)
    {
        if(index != 0){
            Double z = rates.get(index).getAsk()-rates.get(index-1).getAsk();
            return z;
        }else{
            return 0.0;
        }
    }
}
