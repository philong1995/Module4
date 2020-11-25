package service;

import model.SettingEmail;

import java.util.List;

public interface SettingEmailService {
    void save(SettingEmail settingEmail);
    List<String> languageList();
    List<Integer> pageList();
}
