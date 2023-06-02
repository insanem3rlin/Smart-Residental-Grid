package home.awattar_hourly_price.Controller;

import home.awattar_hourly_price.Models.Transaction;
import home.awattar_hourly_price.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/transaction")
    public @ResponseBody ResponseEntity<String> insertTransaction(@RequestParam String maxLevel, @RequestParam String amount, @RequestParam String startTime, @RequestParam String endTime, @RequestParam String isBuy) {

        startTime = startTime.replace(" ", "+");
        endTime = endTime.replace(" ", "+");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        Timestamp startTimestamp = Timestamp.valueOf(startDateTime);

        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        Timestamp endTimestamp = Timestamp.valueOf(endDateTime);

        if(isBuy.equals("true")) {
            transactionRepository.save(new Transaction(maxLevel, amount, startTimestamp.toString(), endTimestamp.toString(), true));
        }
        else if(isBuy.equals("false")){
            transactionRepository.save(new Transaction(maxLevel, amount, startTimestamp.toString(), endTimestamp.toString(), false));
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}