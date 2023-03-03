package platform.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.businesslayer.Code;
import platform.businesslayer.CodeNotFoundException;
import platform.businesslayer.CodeService;

import java.time.format.DateTimeFormatter;

@Controller //for HTML return
public class WEBcpsController {

    @Autowired
    CodeService codeService;

    @GetMapping(value = "/code/{uuid}", produces = MediaType.TEXT_HTML_VALUE)
    public String getCodeNewCreationEndPoint2(Model model,@PathVariable String uuid) {
        Code code = codeService.getCodeByUUID(uuid);
        //change the format of datetime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatedTime = code.getLocalDateTime().format(dateTimeFormatter);

        if ((code.getRestrictionByDateIsAccessible() == true) || (code.getRestrictionByViewsIsAccessible() == true)) {
            codeService.UpdateTimeAndViews(code);
        }
        //pass code object to freemaker
        model.addAttribute("code", code);
        //pass formated date and time to freemaker
        model.addAttribute("date", formatedTime);
        return "code";
    }

    @GetMapping("/code/new")
    public String getCodeNewCreationEndPointTest(Model model) {
        return "codeNew";
    }

    @GetMapping("code/latest")
    public String getWebLastTen(Model model){
        model.addAttribute("snippets",codeService.findLastTenByQuery());

        return "returnLastTen";
    }
}
