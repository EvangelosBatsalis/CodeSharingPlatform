package platform.businesslayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.persistencelayer.CodeRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
//I used business logic to avoid interaction controller directly to Entity
public class CodeService {
    private CodeRepository codeRepository;
    //    private LocalDateTime localDateTime;
    @Deprecated(since = "version 3", forRemoval = true)
    private List<Code> codeList = new ArrayList<>();

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public void saveCode(final Code code) {
        codeRepository.save(code);
    }

    public void UpdateTimeAndViews(Code code) {
        if (code.getRestrictionByViewsIsAccessible() == true) {
            if (code.getRemainingViews() == 0) {
                codeRepository.deleteByCodeUUID(code.getCodeUUID());
                throw new CodeNotFoundException();
            }
            code.setRemainingViews(code.getRemainingViews() - 1);
            codeRepository.save(code);

        }
        if (code.getRestrictionByDateIsAccessible() == true) {
            long difference = LocalDateTime.now()
                    .until(code.getLocalDateTime().plusSeconds(code.getRemainingTime()), ChronoUnit.SECONDS);
            if (difference <= 0) {
                codeRepository.deleteByCodeUUID(code.getCodeUUID());
                throw new CodeNotFoundException();
            }
            System.out.println(difference);
            System.out.println(code.getLocalDateTime());
            code.getRemainingTime();
            code.setRemainingTime(difference);
        }
    }

    public Code getCodeByUUID(String uuid) {
        return codeRepository.findByCodeUUID(uuid).orElseThrow(CodeNotFoundException::new);
    }

    public List<Code> findLastTenByQuery() {
        return codeRepository.findLastTenByQuery();
    }

    @Deprecated(since = "version 4", forRemoval = true)
    public void getCodeById(int id) {
        codeRepository.findCodeById(id);
    }

    @Deprecated(since = "version 3", forRemoval = true)
    //method to set to list
    public void setCodeList(Code code) {
        code.setLocalDateTimeNow();
        codeList.add(code);
    }

    @Deprecated(since = "version 3", forRemoval = true)
    //method to iterate through list objects
    public List<Code> getReturnCodeList() {
        return codeList;
    }

    @Deprecated(since = "Version 3", forRemoval = true)
    //return last 10 from the list
    public List<Code> getLastTenCodeList() {
        List<Code> newList = new ArrayList<>();
        if (codeList.size() > 9) {
            for (int i = codeList.size() - 1; i > codeList.size() - 11; i--) {
                newList.add(codeList.get(i));
            }
        } else {
            newList.addAll(codeList);
            Collections.reverse(newList);
        }
        return newList;
    }

    @Deprecated(since = "Version 3", forRemoval = true)
    public List<Code> getLastTen() {
        int id = codeRepository.findTopByOrderByIdDesc().getId();
        System.out.println(id);
        return codeRepository.findFirst10ByOrderByIdDesc();
    }

}
