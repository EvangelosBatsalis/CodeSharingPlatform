package platform.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.businesslayer.Code;
import platform.businesslayer.CodeService;
import platform.businesslayer.EmptyJsonResponse;
import platform.persistencelayer.CodeRepository;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

@RestController  //used Rest annotation For Json return to have @Responsebody features enabled
public class APIcspController {

    //Declaring singletons from @Service
    @Autowired
    Code codeEntity;

    @Autowired
    CodeService codeService;

    @Deprecated(since = "version 3", forRemoval = true)
    Map<String, String> codeMap = new HashMap<>();
    @Deprecated(since = "Version 2", forRemoval = true)
    @Autowired
    private CodeRepository codeRepository;

    @PostMapping("api/code/new")
    public ResponseEntity<Map<String, String>> postApiEndoint(@RequestBody Code code) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatedTime = code.getLocalDateTime().format(dateTimeFormatter);
        if (code.getRemainingViews() <= 0) {
            code.setRestrictionByViewsIsAccessible(false);
        } else {
            code.setRestrictionByViewsIsAccessible(true);
        }
        if (code.getRemainingTime() <= 0) {
            code.setRestrictionByDateIsAccessible(false);
            code.setFormatedDateTime(formatedTime);
        } else {
            code.setRestrictionByDateIsAccessible(true);
        }
        codeService.saveCode(code); //saves the code

//      using map to return json object without using json property because of the change the UUID
        Map<String, String> returnUuidMap = new HashMap<>();
        returnUuidMap.put("id", code.getCodeUUID());
      System.out.println(code.getCodeUUID()); //simply prints the uuid for testing purposes
        return new ResponseEntity<>(returnUuidMap, HttpStatus.OK);
    }

    @GetMapping("api/code/{uuid}")
    public Code getApiEnpoint(@PathVariable String uuid) {
        Code code = codeService.getCodeByUUID(uuid);
        if ((code.getRestrictionByDateIsAccessible() == true) || (code.getRestrictionByViewsIsAccessible() == true)) {
            codeService.UpdateTimeAndViews(code);
        }
        return code;
    }

    @GetMapping("api/code/latest")
    public List<Code> getApiEnpoint2(){
        List<Code> codeList = new ArrayList<>();

        codeList.addAll(codeService.findLastTenByQuery());

        return codeList;
    }
}