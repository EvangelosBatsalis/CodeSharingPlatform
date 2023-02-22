package platform.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.businesslayer.Code;
import platform.businesslayer.CodeService;
import platform.persistencelayer.CodeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  //For Json return
public class APIcspController {

    //Singleton Entity
    @Autowired
    Code codeEntity;

    @Autowired
    CodeService codeService;

    Map<String, String> codeMap = new HashMap<>();
    @Autowired
    private CodeRepository codeRepository;

    @PostMapping("api/code/new")
    public ResponseEntity<Map<String, String>> postApiEndoint(@RequestBody Code code){
        Map<String,String> returnUuidMap = new HashMap<>();
        codeService.saveCode(code);
        returnUuidMap.put("id",code.getCodeUUID());
        System.out.println(code.getCodeUUID());
        return new ResponseEntity<>(returnUuidMap, HttpStatus.OK);

//        codeService.saveCode(code);
//        codeMap.put("id", String.valueOf(code.getId()));
//        return new ResponseEntity<>(codeMap, HttpStatus.OK);
//        codeService.setCodeList(code);
//        codeMap.put("id",String.valueOf(codeEntity.getId()));
//        codeMap.put("id",String.valueOf(codeEntity.getId()));
    }

    @GetMapping("api/code/{uuid}")
    public ResponseEntity<Code> getApiEnpoint(@PathVariable String uuid){
        return new ResponseEntity<>(codeService.getCodeByUUID(uuid),HttpStatus.OK);
//
//        if(codeService.getCodeListSize() == 0){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "List is empty");
//        }else if(id > codeService.getCodeListSize()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request max list size is: " + codeService.getCodeListSize());
//        }else{
//            return new ResponseEntity<>(codeService.getReturnCodeList().get(id-1), HttpStatus.OK);
//        }

    }

    @GetMapping("api/code/latest")
    public ResponseEntity<List<Code>> getApiLastTen(){
//       return new ResponseEntity<>(codeService.getLastTenCodeList(), HttpStatus.OK);
        return new ResponseEntity<>(codeService.getLastTen(),HttpStatus.OK);
    }

//    @GetMapping("api/code/test")
//    public List<Code> getApiEnpoint(){
//        String uuid = "05a542bc-63bf-4eb0-8de8-281d61bb4ddf";
//        List<Code> newcode = codeService.getCodeByUUID(uuid);
////        System.out.println(newcode.getCode() );
//        return newcode;
//    }
}