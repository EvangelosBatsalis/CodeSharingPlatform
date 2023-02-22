package platform.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

//@JsonSerialize
@Entity
@Component
@Table(name = "codes")
public class Code {
    //initialization is because of the exercise;

    //declaration and initialisation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "idCode")
    int id;
    @Column(name = "code")
    private String code = "zxc";
    private String title = "Code";
    private String codeSnippet = "zxca";
    @Column(name = "date")
    private LocalDateTime localDateTime;
    @Column(name = "remainingTime")
    @JsonProperty("time")
    private int remainingTime;
    @Column(name = "remainingViews")
    @JsonProperty("views")
    private int remainingViews;
    @JsonIgnore
//    @JsonProperty("id")
    private final String codeUUID = UUID.randomUUID().toString();
    @Column(name = "deletionDate")
    @JsonIgnore
    private LocalDateTime deletionLocalDateTime = null;


//constructors
    public Code() {
        this.id = 0;
    }


    //setters and getters
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

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getRemainingViews() {
        return remainingViews;
    }

    public void setRemainingViews(int remainingViews) {
        this.remainingViews = remainingViews;
    }

    public String getCodeUUID() {
        return codeUUID;
    }
}
