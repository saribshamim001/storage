package VenuMateEventSolution.VenuMate.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${sms.api-key}")
    private String apiKey;

    @Value("${sms.sender}")
    private String sender;

    @Async
    public CompletableFuture<String> sendSms(String toPhoneNumber, String message) {
        try {
            String encodedMessage = message.replace(" ", "+");
            String url = String.format(
                    "https://sendpk.com/api/sms.php?api_key=%s&sender=%s&mobile=%s&message=%s",
                    apiKey, sender, toPhoneNumber, encodedMessage
            );
            logger.info("Sending SMS to {}: {}", toPhoneNumber, message);
            String response = restTemplate.getForObject(url, String.class);
            return CompletableFuture.completedFuture(response);
        } catch (Exception e) {
            logger.error("Failed to send SMS", e);
            return CompletableFuture.completedFuture("FAILED");
        }
    }
}