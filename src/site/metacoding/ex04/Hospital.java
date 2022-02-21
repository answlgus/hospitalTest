package site.metacoding.ex04;

import lombok.Data;

//칼럼 16개
@Data
public class Hospital {

    private int id; // PrimaryKey 만들기 - > DB에서 시퀀스 생성 seq_hospital
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

    public void copy(Item item) { // object를 복사
        this.addr = item.getAddr();
        this.mgtStaDd = item.getMgtStaDd();
        this.pcrPsblYn = item.getPcrPsblYn();
        this.ratPsblYn = item.getRatPsblYn();
        this.recuClCd = item.getRecuClCd();
        this.rprtWorpClicFndtTgtYn = item.getRprtWorpClicFndtTgtYn();
        this.sgguCdNm = item.getSgguCdNm();
        this.sidoCdNm = item.getSidoCdNm();
        this.telno = item.getTelno();
        this.XPos = item.getXPos();
        this.XPosWgs84 = item.getXPosWgs84();
        this.YPos = item.getYPos();
        this.YPosWgs84 = item.getYPosWgs84();
        this.yadmNm = item.getYadmNm();
        this.ykihoEnc = item.getYkihoEnc();
    }
}
