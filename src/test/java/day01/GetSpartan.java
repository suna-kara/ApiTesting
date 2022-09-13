package day01;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetSpartan {

    @BeforeAll

    public  static void  init(){
      baseURI= "http://44.202.119.26:8000";
    }
@DisplayName("Get all Spartans")
    @Test
    public  void  test1(){
    Response response=given().accept(ContentType.JSON)
            .when().get("/api/spartans");

 response.prettyPrint();

 assertEquals("application/json",response.contentType());

   assertTrue(response.headers().hasHeaderWithName("Date"));
}

    @Test
   public void test2() {
        Response response= given().accept(ContentType.JSON)
                .and().pathParam("id",11)
                .when().get("/api/spartans/{id}");

        response.prettyPrint();

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());

        int id=response.path("id");
        System.out.println("id = " + id);

      String name=response.path("name");

       String gender = response.path("gender");
        System.out.println("gender = " + gender);

        long phone = response.path("phone");
        System.out.println("phone = " + phone);


        assertEquals(11,id);
        assertEquals("Suna",name);
        assertEquals("Female",gender);
        assertEquals(3312820036l,phone);




    }





}
