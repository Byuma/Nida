package com.example.nidaapp2;

public class customer {
    String custuserName, custPass;

    public customer(String custuserName, String custPass) {
        this.custuserName = custuserName;
        this.custPass = custPass;
    }

    public String getCustuserName() {
        return custuserName;
    }

    public void setCustuserName(String custuserName) {
        this.custuserName = custuserName;
    }

    public String getCustPass() {
        return custPass;
    }

    public void setCustPass(String custPass) {
        this.custPass = custPass;
    }
}
