import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class OtusTest extends BaseHooks {

    @Test
    public void testLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("setYourMail", "setYourPass");
    PrivateOffice privateOffice = loginPage.getPrivateOffice();
    privateOffice.getPersonalInfoForm();
    privateOffice.setPersonal("Ftest", "LFtest", "Ltest", "LLTest", "OMG", "26.02.1992");
    cleanAndRefresh();
    loginPage.getLoginPage("setYourMail", "setYourPass");
    privateOffice.getPersonalInfoForm();
    Assertions.assertEquals("Ftest", privateOffice.getPersonal("nameField"));
    Assertions.assertEquals("LFtest", privateOffice.getPersonal("latinNameField"));
    Assertions.assertEquals("Ltest", privateOffice.getPersonal("surnameField"));
    Assertions.assertEquals("LLTest", privateOffice.getPersonal("latinSurnameField"));
    Assertions.assertEquals("OMG", privateOffice.getPersonal("blogNameField"));
    Assertions.assertEquals("26.02.1992", privateOffice.getPersonal("birthdayField"));

}





}
