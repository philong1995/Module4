package service.impl;

import org.springframework.stereotype.Service;
import service.Translate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateImpl implements Translate {

    @Override
    public String trans(String word) {
        Map<String,String> mapWord = new HashMap<>();
        String trans = null;
        mapWord.put("hippo","hà mã");
        mapWord.put("beer","Sinh tố lúa mạch");
        mapWord.put("akbb","Anh khoa bụng bự");

        for (Map.Entry<String, String> compare : mapWord.entrySet()) {
            if (word.equals(compare.getKey())) {
                trans = word+" có nghĩa là: "+compare.getValue();
                break;
            } else {
                trans = "Từ này không có trong từ điển";
            }
        }
        return trans;
    }
}
