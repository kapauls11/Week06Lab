package tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;
import servlet.LoginServlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Debug extends TagSupport
{

    @Override
    public int doStartTag()
    {
        String scheme = LoginServlet.scheme;
        String serverName = LoginServlet.serverName;
        String port = LoginServlet.port;
        String uri = LoginServlet.uri;
        String debugParameter = LoginServlet.parameter;
        
        if (serverName.equals("test.cprg352.com") && debugParameter.equals("?debug") )    
        {
            return EVAL_BODY_INCLUDE;
        }
        else
        {
           return SKIP_BODY; 
        }

        

    }

    @Override
    public int doEndTag()
    {

        return EVAL_PAGE;
    }

}
