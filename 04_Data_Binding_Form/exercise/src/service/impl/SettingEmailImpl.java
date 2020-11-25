package service.impl;

import model.SettingEmail;
import org.springframework.stereotype.Service;
import service.SettingEmailService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingEmailImpl implements SettingEmailService {

    @Override
    public void save(SettingEmail settingEmail) {
        List<SettingEmail> listSetting = new ArrayList<>();
        listSetting.add(settingEmail);
    }

    @Override
    public List<String> languageList() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    @Override
    public List<Integer> pageList() {
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }
}
