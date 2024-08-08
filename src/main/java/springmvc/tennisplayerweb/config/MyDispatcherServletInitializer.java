package springmvc.tennisplayerweb.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //provides  the same functionality as the <servlet> and <init-param> tags in the web.xml file.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {PlayerConfig.class};
    }

    //Setup URL mapping; provides the same functionality as the <servlet-mapping> tag in the web.xml file.
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/*"};
    }
}
