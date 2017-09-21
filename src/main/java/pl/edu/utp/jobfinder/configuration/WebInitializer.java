package pl.edu.utp.jobfinder.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Bartłomiej Skibiński
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { JpaConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfiguration.class }; // TODO: null ? 
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
}
