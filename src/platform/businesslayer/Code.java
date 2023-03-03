package platform.businesslayer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

//@JsonSerialize
@Entity
@Component
@Table(name = "codes")
public class Code {

    //declaration and initialisation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "idCode")
    int id;
    @Column(name = "code")
    private String code;
    @Column(name = "date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonProperty("date")
    private LocalDateTime localDateTime;
    @Column(name = "remainingTime")
    @JsonProperty("time")
    private long remainingTime;
    @Column(name = "remainingViews")
    @JsonProperty("views")
    private Integer remainingViews = null;  //used Integer to get null if null then there is no restriction but if 0 then it will be deleted from db this change will be performed from CodeService
    @JsonIgnore
    private String codeUUID;
    @JsonIgnore
    private Boolean restrictionByDateIsAccessible = false;
    @JsonIgnore
    private Boolean restrictionByViewsIsAccessible = false;
    @JsonIgnore
    private String formatedDateTime; //formatted date for exporting the list to freemaker


//constructors
    public Code() {
        localDateTime = LocalDateTime.now();
        codeUUID = UUID.randomUUID().toString();
    }

    public Code(String empty) {
    }

    //Getters and Setters
    @JsonIgnore
    public int getId() {
        //this.id = ++id;
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTimeNow() {
        this.localDateTime = LocalDateTime.now().withNano(0);
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(long remainingTime) {
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

    public Boolean getRestrictionByDateIsAccessible() {
        return restrictionByDateIsAccessible;
    }

    public void setRestrictionByDateIsAccessible(Boolean restrictionByDateIsAccessible) {
        this.restrictionByDateIsAccessible = restrictionByDateIsAccessible;
    }

    public Boolean getRestrictionByViewsIsAccessible() {
        return restrictionByViewsIsAccessible;
    }

    public void setRestrictionByViewsIsAccessible(Boolean restrictionByViewsIsAccessible) {
        this.restrictionByViewsIsAccessible = restrictionByViewsIsAccessible;
    }

    public String getFormatedDateTime() {
        return formatedDateTime;
    }

    public void setFormatedDateTime(String formatedDateTime) {
        this.formatedDateTime = formatedDateTime;
    }
}
