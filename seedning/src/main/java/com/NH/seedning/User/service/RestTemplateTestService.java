package com.NH.seedning.User.service;

import com.NH.seedning.User.model.DrawingTransfer;
import com.NH.seedning.User.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class RestTemplateTestService {

    private ApiService<Response> apiService;

    @Autowired
    public RestTemplateTestService(ApiService<Response> apiService) {
        this.apiService = apiService;
    }

    public String callPostExternalServer(String Tram) {
        DrawingTransfer drawingTransfer = new DrawingTransfer();
        drawingTransfer.addHeader("ApiNm", "DrawingTransfer");
        drawingTransfer.addHeader("Tsymd", "20201213");
        drawingTransfer.addHeader("Trtm", "112428");
        drawingTransfer.addHeader("Iscd", "000498");
        drawingTransfer.addHeader("FintechApsno", "001");
        drawingTransfer.addHeader("ApiSvcCd", "DrawingTransferA");
        drawingTransfer.addHeader("IsTuno", "243424");
        drawingTransfer.addHeader("AccessToken", "8adc7b8d4bfc48a400077d84038f0f465e22b4ccc810473e49283636ca3f9132");

        drawingTransfer.setFinAcno("00820100004980000000000000972");
        drawingTransfer.setTram("10000");
        drawingTransfer.setDractOtlt("테스트");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        System.out.println("getHeader"+drawingTransfer.getHeader());
        System.out.println("getFinAcno"+drawingTransfer.getFinAcno());
        System.out.println("getTram"+drawingTransfer.getTram());
        System.out.println("getDractOtlt"+drawingTransfer.getDractOtlt());


        return apiService.post("https://developers.nonghyup.com/DrawingTransfer.nh", httpHeaders, "{\n" +
                "  \"Header\": {\n" +
                "    \"ApiNm\": \"DrawingTransfer\",\n" +
                "    \"Tsymd\": \"20201213\",\n" +
                "    \"Trtm\": \"112428\",\n" +
                "    \"Iscd\": \"000498\",\n" +
                "    \"FintechApsno\": \"001\",\n" +
                "    \"ApiSvcCd\": \"DrawingTransferA\",\n" +
                "    \"IsTuno\": \"2343242\",\n" +
                "    \"AccessToken\": \"8adc7b8d4bfc48a400077d84038f0f465e22b4ccc810473e49283636ca3f9132\"\n" +
                "  },\n" +
                "  \"FinAcno\": \"00820100004980000000000000972\",\n" +
                "  \"Tram\": "+ "\"" + Tram + "\",\n" +
                "  \"DractOtlt\": \"출금계좌인자내용\"\n" +
                "}", Response.class).toString();

        //return apiService.post("https://developers.nonghyup.com/DrawingTransfer.nh", httpHeaders, , Response.class).toString();
    }
}
