package framework.managers;

import framework.pages.ForCompaniesPage;
import framework.pages.InsurancePage;
import framework.pages.StartPage;
import org.openqa.selenium.support.PageFactory;

public class PageManager {
    private static PageManager INSTANCE =null;
    private StartPage startPage;
    private ForCompaniesPage forCompaniesPage;
    private InsurancePage insurancePage;

    private PageManager(){

    }
    public static PageManager getInstance(){
        if(INSTANCE==null){
            INSTANCE= new PageManager();
        }
        return INSTANCE;
    }

    public StartPage getStartPage(){
        if(startPage==null){
            startPage=new StartPage();
        }
        return startPage;
    }

    public ForCompaniesPage getForCompaniesPage(){
        if(forCompaniesPage==null){
            forCompaniesPage=new ForCompaniesPage();
        }
        return forCompaniesPage;
    }
    public InsurancePage getInsurancePage(){
        if(insurancePage==null){
            insurancePage=new InsurancePage();
        }
        return insurancePage;
    }

}
