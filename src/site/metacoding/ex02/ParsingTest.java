package site.metacoding.ex02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

//목적: 파싱 (Json -> Java)
public class ParsingTest {
    public static void main(String[] args) {

        // 1. url 주소 만들기
        StringBuffer sbUrl = new StringBuffer();

        sbUrl.append("http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService");
        sbUrl.append("?serviceKey="); // 서비스키
        sbUrl.append("wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtsbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D");
        sbUrl.append("&pageNo="); // 몇 번째 페이지 인지
        sbUrl.append("1");
        sbUrl.append("&numOfRows=");
        sbUrl.append("10"); // 한 페이지당 몇 개씩 가져올지
        sbUrl.append("&_type=");
        sbUrl.append("json"); // 데이터 포맷은 JSON

        // 2. 다운로드 받기 (완)
        try {
            URL url = new URL(sbUrl.toString()); // URL safe가 적용되어 있음 (URL safe가 되어 있으면 더 이상 반영하지 않음)
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader( // 가변 길이의 문자열을 받기 위해
                    new InputStreamReader(conn.getInputStream(), "utf- 8") // 데이터 읽기
            );

            StringBuffer sbDownload = new StringBuffer(); // 통신결과 모아두기
            // 데이터가 어느 정도인지 모르기 때문
            while (true) {
                String input = br.readLine();
                if (input == null) { //
                    break;
                }
                sbDownload.append(input); // 버퍼에 쌓인거 읽을 때
            }

            // 3. 파싱
            Gson gson = new Gson();
            ResponseDto responseDto = gson.fromJson(sbDownload.toString(), ResponseDto.class);

            // 4.검증
            // int itemSize = responseDto.getResponse().getBody().getItems().getItem();
            // System.out.println("아이템 사이즈" + itemSize);
            System.out.println(responseDto.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
