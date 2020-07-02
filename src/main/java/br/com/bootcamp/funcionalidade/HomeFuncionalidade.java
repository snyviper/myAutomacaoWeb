package br.com.bootcamp.funcionalidade;

import br.com.bootcamp.pages.HomePage;
import br.com.bootcamp.settings.BaseTest;

public class HomeFuncionalidade extends BaseTest {
    private HomePage homePage;

    public HomeFuncionalidade(){
        this.homePage = new HomePage(webDriver);
    }

    public void start() {System.out.println("Testando nossa execucao"); }
}
