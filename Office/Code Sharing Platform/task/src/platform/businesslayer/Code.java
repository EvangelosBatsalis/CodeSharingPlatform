package platform.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

//@JsonSerialize
@Entity
@Component
@Table(name = "codes")
public class Code {
    //initialization is because of the exercise;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id")
    int id;

    @Column(name = "code")
    private String code = "zxc";
    private String title = "Code";
    private String codeSnippet = "zxca";
    @Column(name = "date")
    private LocalDateTime localDateTime;

    public Code() {
        this.id = 0;
    }

    @JsonIgnore
    public int getId(){
//        this.id = ++id;
        return id;
    }
    public Code(String s) {
        this.code = s;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @JsonIgnore
    public String getCodeSnippet() {
        return codeSnippet;
    }

    @JsonIgnore
    public void setCodeSnippet(String codeSnippet) {
        this.codeSnippet = codeSnippet;
    }

    @JsonProperty("date")
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTimeNow() {
        this.localDateTime = LocalDateTime.now().withNano(0);
    }
}
