package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommonUtils {
    public static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Il9pZCI6IjYzMDg2NzBhMzU4Zjc" +
            "yZWVlMDJmYTNlZSIsImdvb2dsZUlkIjoiMTA0MTA0MzA1NTM5Mjk4Mjk4MTQxIiwiZW1haWwiOiJpa3JhbWFoLm1hZ2hmaXJh" +
            "aDI4QGdtYWlsLmNvbSIsImZ1bGxOYW1lIjoiRmlyYSIsInBob3RvVXJsIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbn" +
            "QuY29tL2EtL0FGZFp1Y29DVk9TV29WckFEV2dad0RZY0hjbnFuVURwRkktRHJraHBFSkcxPXM5Ni1jIiwiYmlvIjoiU3R1ZGVu" +
            "dCBvZiBTZWtvbGFoIFFBIGJhdGNoIDE0Iiwic3RhdHVzIjoiU3R1ZGVudCIsImRlZmF1bHRDb21wYW55Ijp7Il9pZCI6IjYxZW" +
            "JhMmM4NTA4MGY0N2IyNWRkYzhmOCJ9LCJjcmVhdGVkQXQiOiIyMDIyLTA4LTI2VDA2OjI0OjEwLjUyNVoiLCJ1cGRhdGVkQXQi" +
            "OiIyMDIyLTA5LTI0VDA2OjE3OjA3LjI1OVoiLCJfX3YiOjB9LCJpYXQiOjE2NjQzODEwMzIsImV4cCI6MTY2Njk3MzAzMn0.rN" +
            "hSaz4UYKboqWp5pvh3URg6RmjYObyxHhGbUtSEJ28";

    public static void getToken(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem(arguments[0], arguments[1])", "token", token);
        driver.navigate().refresh();
    }
}
