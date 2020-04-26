package an.easycodedemo.config;

import an.easycodedemo.entity.User;
import an.easycodedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author AnRuicheng
 * @date 2020/4/1 - 20:53
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest Request, HttpServletResponse Response, Authentication authentication) throws IOException, ServletException {
        Set<String> set = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String Path=Request.getContextPath();
        String basePath=Request.getScheme()+"://"+Request.getServerName()+":"+Request.getServerPort();
        if (set.contains("ROLE_USER")){
            Response.sendRedirect(basePath+"/toNewsPage");
            return;
        }else if(set.contains("ROLE_ADMIN")){
            Response.sendRedirect(basePath+"/toBackendHome");
            return;
        }
        System.out.println("error");
    }
}
