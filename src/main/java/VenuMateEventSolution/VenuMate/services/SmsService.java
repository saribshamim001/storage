package VenuMateEventSolution.VenuMate.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);
    @Autowired
    private RestTemplate restTemplate;

    @Value("${sms.api-key}")
    private String apiKey;

    @Value("${sms.sender}")
    private String sender;

    public String sendSms(String toPhoneNumber, String message) {

        // Replace spaces with "+" — only this is needed
        String encodedMessage = message.replace(" ", "+");

        // Construct the SendPK-friendly URL
        String url = String.format("https://sendpk.com/api/sms.php?api_key=%s&sender=%s&mobile=%s&message=%s",
                apiKey, sender, toPhoneNumber, encodedMessage);

        // Send it via RestTemplate
        logger.info("Sending SMS to {}: {}", toPhoneNumber, message);
        return restTemplate.getForObject(url, String.class);
    }
}
