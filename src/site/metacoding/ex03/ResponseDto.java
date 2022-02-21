package site.metacoding.ex03;

import java.util.List;

import lombok.Data;

@Data
class Body {
    private Items items;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;
}

@Data
class Header {
    private String resultCode;
    private String resultMsg;
}

@Data
class Item {

    private String addr;
    private Integer mgtStaDd;
    private String pcrPsblYn;
    private String ratPsblYn;
    private Integer recuClCd;
    private String rprtWorpClicFndtTgtYn;
    private String sgguCdNm;
    private String sidoCdNm;
    private String telno;
    private Integer XPos;
    private Double XPosWgs84;
    private Integer YPos;
    private Double YPosWgs84;
    private String yadmNm;
    private String ykihoEnc;

}

@Data
class Items {
    private List<Item> item;
}

@Data
class Response {

    private Header header;
    private Body body;

}

@Data
class ResponseDto {

    public Response response;

}
