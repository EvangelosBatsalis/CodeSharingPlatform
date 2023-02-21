package platform.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.businesslayer.Code;
import platform.businesslayer.CodeService;

@Controller //for HTML return
public class WEBcpsController {

    @Autowired
    CodeService codeService;

    @GetMapping(value = "/code/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getCodeNewCreationEndPoint2(Model model,@PathVariable int id) {
//        Code code = codeService.getCodeList().get(id-1);
        Code code = codeService.getCodeRepository().findCodeById(id);

        model.addAttribute("date",code.getLocalDateTime().toString());
        model.addAttribute("code_snipet",code.getCode().toString());
        return "returnNthCode";
    }

    @GetMapping("/code/new")
    public String getCodeNewCreationEndPointTest(Model model) {
        return "codeNew";
    }
    @GetMapping("code/latest")
    public String getWebLastTen(Model model){
//        model.addAttribute("snippets",codeService.getLastTenCodeList());
        model.addAttribute("snippets",codeService.getLastTen());

        return "returnLastTen";
    }



}
