package tr.lkd.lyk2015.springtodo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //front controller configurasyonum web config dosyamda
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }
    
    // "/" dan sonraki herşeye bana gelsin. root path sonrası springe gelsin
    // burda front controllerimi ayarlamış oluyorum
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}