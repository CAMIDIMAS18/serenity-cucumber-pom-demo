package com.automation.practice.demo;

import net.serenitybdd.core.steps.UIInteractions;

public class SearchActions extends UIInteractions {

    public void loginInPage(String username, String password){
        $("Log in to your customer account").click();
        $("#email").sendKeys(username);
        $("#passwd").sendKeys(password);
        $("button[id='SubmitLogin'] span").click();
    }


}
