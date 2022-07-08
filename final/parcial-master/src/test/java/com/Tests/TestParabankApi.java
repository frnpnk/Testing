package com.Tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestParabankApi {

    public int CustomerID = 12345 ;
    public int AccountID = 12345;
    public int NewAccountID = 12345;



    @Test
    @Tag("smokeApi")
    public void registerPOST() {
        given().contentType(ContentType.JSON).body("{\n" +
                        "\"customer.firstName\": \"francisco\",\n" +
                        "\"customer.lastName\": \"Smith\",\n" +
                        "\"customer.address.street\": \"callefalsa22\",\n" +
                        "\"customer.address.city\": \"maroma\",\n" +
                        "\"customer.address.state\": \"setearma\",\n" +
                        "\"customer.address.zipCode\": \"10300\",\n" +
                        "\"customer.phoneNumber\": \"43424523432v\",\n" +
                        "\"customer.ssn\": \"ninguno\",\n" +
                        "\"customer.username\": \"franciscosmith223\",\n" +
                        "\"customer.password\":\"fran1234\",\n" +
                        "\"repeatedPassword\": \"fran1234\"\n" +
                        "}")
                .when().post("https://parabank.parasoft.com/parabank/register.htm")
                .then().statusCode(200).log().all();
        // setearia la variable  con el id obtenido CustomerID = "nuevo valor" ;
        // setearia la variable  con el id obtenido AccountID = "nuevo valor" ;
    }


    @Test
    @Tag("smokeApi")
    public void newAccountPOST() {
        given().contentType(ContentType.JSON).body("{}")
                .when().post(" https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?c\n" +
                        "    ustomerId=\n"+ CustomerID + "&newAccountType=1&fromAccountId=\n"+AccountID)
                .then().statusCode(200).log().all();
        // setearia la variable  con el id obtenido NewAccountID = "nuevo valor" ;
    }


    @Test
    @Tag("smokeApi")
    public void getAccounts(){
        given().contentType(ContentType.JSON).body("{}")
                .when().get(" https://parabank.parasoft.com/parabank/overview.htm")
                .then().statusCode(200).log().all();
    }

    @Test
    @Tag("smokeApi")
    public void TransferPOST(){
        given().contentType(ContentType.JSON).body("{}")
                .when().post(" https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAc\n" +
                        "countId=\n"+ AccountID + "&toAccountId=13677&amount=\n"+ NewAccountID)
                .then().statusCode(200).log().all();
    }
    
        /*



○ Actividad de la cuenta (cada mes) URL:
https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/
transactions/month/All/type/All
 */

    @Test
    @Tag("smokeApi")
    public void GETMonthAccountById(){
        given().contentType(ContentType.JSON).body("{}")
                .when().get(" https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/\n"+NewAccountID+
                        "transactions/month/All/type/All")
                .then().statusCode(200).log().all();
    }

}
