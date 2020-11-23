package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping({"","/world_clock"})
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {

        // Nhận thời gian hiện tại tại địa phương
        Date date = new Date();


        // Lấy múi giờ theo địa phương
        TimeZone local = TimeZone.getDefault();


        // Lấy múi giờ theo thành phố được chỉ định
        TimeZone locale = TimeZone.getTimeZone(city);


        // Tính thời gian hiện tại ở thành phố được chỉ định
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());

        // Đặt lại ngày theo giờ địa phương
        date.setTime(locale_time);

        model.addAttribute("city", city);
        model.addAttribute("date", date);

        return "index";
    }

}
