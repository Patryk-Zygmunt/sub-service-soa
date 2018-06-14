package agh.givealift.subs.model.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class City {
    private Long cityId;
    private String name;
    private String country;
    private String province;
   

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
