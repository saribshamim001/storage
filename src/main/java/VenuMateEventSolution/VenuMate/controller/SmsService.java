package VenuMateEventSolution.VenuMate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

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

        // Send it
        return restTemplate.getForObject(url, String.class);
    }
}
