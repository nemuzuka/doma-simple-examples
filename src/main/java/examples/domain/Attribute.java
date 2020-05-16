package examples.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attribute {

    @JsonProperty("customer_code")
    private String customerCode;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("age")
    private Integer age;

    public Attribute() {}

    public Attribute(String customerCode, String customerName, Integer age) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.age = age;
    }

    public String getCustomerCode() {
        return this.customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
