package ru.aservice.prod.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.aservice.prod.dto.OpenWeatherResponseDto;
import ru.aservice.prod.entity.Messages;
import ru.aservice.prod.exeption.LanguageException;
import ru.aservice.prod.repository.MessageRepository;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessagesService {

    private final RestTemplate restTemplate;
    private final MessageRepository messageRepository;

    @Override
    public void addMessage(Messages message) {
        Objects.requireNonNull(message.getMsg(), "Require variable [msg] is null");
        String latitude = message.getCoordinate().getLatitude();
        String longitude = message.getCoordinate().getLongitude();
        message.setCreatedAt(new Date());
        OpenWeatherResponseDto openWeatherResponseDto = getWeather(latitude, longitude);
        double currentTempByKelvi = openWeatherResponseDto.getMainDto().getTemp();
        double currentTempByCelsius = currentTempByKelvi - 273.50;
        message.setCurrentTemp(Math.floor(currentTempByCelsius));
        LanguageException.requireLgnNonRu(message.getLanguage(), "Require variable [ru]" + "is" + " " + message.getLanguage());
        messageRepository.save(message);
    }


    private OpenWeatherResponseDto getWeather(String latitude,
                                              String longitude) {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&appid=9e435b943eedfe33444f9be91c9548ab";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<OpenWeatherResponseDto> openWeatherResponse = restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                OpenWeatherResponseDto.class,
                latitude,
                longitude
        );

        if (!openWeatherResponse.getStatusCode().is2xxSuccessful()) {
            throw new IllegalArgumentException("failed request");
        }
        return openWeatherResponse.getBody();
    }
}




