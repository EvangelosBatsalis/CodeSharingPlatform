package platform.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
//        codeMap.put("id",String.valueOf(codeEntity.getId()));

//        codeService.setCodeList(code);

        codeService.saveCode(code);
        codeMap.put("id", String.valueOf(code.getId()));

//        codeMap.put("id",String.valueOf(codeEntity.getId()));
        return new ResponseEntity<>(codeMap, HttpStatus.OK);
    }

    @GetMapping("api/code/{id}")
    public ResponseEntity<Code> getApiEnpoint(@PathVariable int id){
//
//        if(codeService.getCodeListSize() == 0){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "List is empty");
//        }else if(id > codeService.getCodeListSize()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request max list size is: " + codeService.getCodeListSize());
//        }else{
//            return new ResponseEntity<>(codeService.getReturnCodeList().get(id-1), HttpStatus.OK);
//        }
        return new ResponseEntity<>(codeRepository.findCodeById(id),HttpStatus.OK);

    }

    @GetMapping("api/code/latest")
    public ResponseEntity<List<Code>> getApiLastTen(){
//       return new ResponseEntity<>(codeService.getLastTenCodeList(), HttpStatus.OK);
        return new ResponseEntity<>(codeService.getLastTen(),HttpStatus.OK);
    }


}