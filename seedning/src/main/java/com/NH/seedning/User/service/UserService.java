package com.NH.seedning.User.service;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {

    public ResponseEntity<Void> createAccount() {

        WebClient client3 = WebClient
                .builder()
                .baseUrl("https://developers.nonghyup.com/OpenFinAccountDirect.nh")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        WebClient.UriSpec<WebClient.RequestBodySpec> request1 = client3.method(HttpMethod.POST);
        WebClient.UriSpec<WebClient.RequestBodySpec> request2 = client3.post();

        WebClient.RequestBodySpec uri2 = client3
                .post()
                .uri("https://developers.nonghyup.com/OpenFinAccountDirect.nh");

        LinkedMultiValueMap header = new LinkedMultiValueMap();
        LinkedMultiValueMap map = new LinkedMultiValueMap();

        header.add("ApiNm", "OpenFinAccountDirect");
        header.add("Tsymd", "20201212");
        header.add("Trtm", "113604");
        header.add("Iscd", "000498");
        header.add("FintechApsno", "001");
        header.add("ApiSvcCd", "DrawingTransferA");
        header.add("IsTuno", "5435453");
        header.add("AccessToken", "8adc7b8d4bfc48a400077d84038f0f465e22b4ccc810473e49283636ca3f9132");

        map.add("Header", header);
        map.add("DrtrRgyn", "Y");
        map.add("BrdtBrno", "19970831");
        map.add("Bncd", "011");
        map.add("Acno", "3020000002066");

        BodyInserters.MultipartInserter inserter2 = BodyInserters.fromMultipartData(map);

        WebClient.ResponseSpec response1 = (WebClient.ResponseSpec) uri2
                .body(inserter2)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
            .retrieve();
/*

        WebClient.UriSpec<WebClient.RequestBodySpec>  response1 = WebClient.create()
                .mutate()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .baseUrl("https://developers.nonghyup.com/OpenFinAccountDirect.nh")
                        .build()
                        .post()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .body(BodyInserters.fromMultipartData(map))
                        .retrieve()
                .bodyToMono(String.class);


*/
        System.out.println("RRRRRRRRRRRRRRRRRRRRRRRR"+response1);
        return null;
    }

    public ResponseEntity<Void> drawingTransfer(String moneyinput) {

        WebClient client3 = WebClient
                .builder()
                .baseUrl("https://developers.nonghyup.com/DrawingTransfer.nh")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        WebClient.UriSpec<WebClient.RequestBodySpec> request1 = client3.method(HttpMethod.POST);
        WebClient.UriSpec<WebClient.RequestBodySpec> request2 = client3.post();

        WebClient.RequestBodySpec uri2 = client3
                .post()
                .uri("https://developers.nonghyup.com/DrawingTransfer.nh");

        LinkedMultiValueMap header = new LinkedMultiValueMap();
        LinkedMultiValueMap map = new LinkedMultiValueMap();

        header.add("ApiNm", "DrawingTransfer");
        header.add("Tsymd", "20201212");
        header.add("Trtm", "113604");
        header.add("Iscd", "000498");
        header.add("FintechApsno", "001");
        header.add("ApiSvcCd", "DrawingTransferA");
        header.add("IsTuno", "5435453");
        header.add("AccessToken", "8adc7b8d4bfc48a400077d84038f0f465e22b4ccc810473e49283636ca3f9132");

        map.add("Header", header);
        map.add("FinAcno", "00820100004980000000000000972");
        map.add("Tram", moneyinput);
        map.add("DractOtlt", "테스트");

        BodyInserters.MultipartInserter inserter2 = BodyInserters.fromMultipartData(map);

        WebClient.ResponseSpec response1 = uri2
                .body(inserter2)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
/*

        WebClient.UriSpec<WebClient.RequestBodySpec>  response1 = WebClient.create()
                .mutate()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .baseUrl("https://developers.nonghyup.com/OpenFinAccountDirect.nh")
                        .build()
                        .post()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .body(BodyInserters.fromMultipartData(map))
                        .retrieve()
                .bodyToMono(String.class);


*/

        System.out.println("RRRRRRRRRRRRRRRRRRRRRRRR"+response1.toEntity(String.class));
        return null;
    }
}
