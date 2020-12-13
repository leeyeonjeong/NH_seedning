package com.NH.seedning.User.model;

import java.util.HashMap;
import java.util.Map;

public class DrawingTransfer {
    /**
     * map.add("Header", header);
     *         map.add("FinAcno", "00820100004980000000000000972");
     *         map.add("Tram", moneyinput);
     *         map.add("DractOtlt", "테스트");
     * */

    private Map<String, String> Header = new HashMap<>();
    private String FinAcno;
    private String Tram;
    private String DractOtlt;

    public String getFinAcno() {
        return FinAcno;
    }

    public void setFinAcno(String FinAcno) {
        this.FinAcno = FinAcno;
    }

    public String getTram() {
        return Tram;
    }

    public void setTram(String Tram) {
        this.Tram = Tram;
    }

    public String getDractOtlt() {
        return DractOtlt;
    }

    public void setDractOtlt(String DractOtlt) {
        this.DractOtlt = DractOtlt;
    }

    public Map<String, String> getHeader() {
        return Header;
    }

    public void setHeader(Map<String, String> Header) {
        this.Header = Header;
    }

    public void addHeader(String key, String value) {
        this.Header.put(key, value);
    }

}
