package platform.businesslayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.persistencelayer.CodeRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.Collections;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
//I used business logic to avoid interaction controller directly to Entity
public class CodeService{
    private CodeRepository codeRepository;

    private LocalDateTime localDateTime;
    private List<Code> codeList = new ArrayList<>();

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }


//    public CodeService(CodeRepository codeRepository) {
//        this.codeRepository = codeRepository;
//    }

    public int saveCode(Code code){
        code.setLocalDateTimeNow();
        Code codeResponseSave = codeRepository.save(code);
//        codeRepository.save(code);
        return codeResponseSave.getId();
    }

    public void getCodeById(int id){
        codeRepository.findCodeById(id);
    }


    //method to set to list
    public void setCodeList(Code code){
        code.setLocalDateTimeNow();
        codeList.add(code);
//        System.out.println(code.getLocalDateTime());
    }

    //method to iterate through list objects
    public List<Code> getReturnCodeList(){
        return codeList;
    }

    //return last 10 from the list
    public List<Code> getLastTenCodeList() {
        List<Code> newList = new ArrayList<>();
        if(codeList.size()>9) {
//            System.out.println("if"); //remove it
            for (int i = codeList.size() - 1; i > codeList.size() - 11; i--) {
                newList.add(codeList.get(i));
            }
        }else{
//            System.out.println("else"); //remove it
            newList.addAll(codeList);
            Collections.reverse(newList);
        }
        return newList;
}

//simple getSize
    public int getCodeListSize(){
        return codeList.size();
    }

    //Names from documentation
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
    public List<Code> getLastTen(){
        int id = codeRepository.findTopByOrderByIdDesc().getId();
        System.out.println(id);
        return codeRepository.findFirst10ByOrderByIdDesc();

    }

}
