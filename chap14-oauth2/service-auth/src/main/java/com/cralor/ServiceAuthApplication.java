package com.cralor;

import com.cralor.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableResourceServer
@SpringBootApplication
public class ServiceAuthApplication {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }


    /**
     * 继承AuthorizationServerConfigurerAdapter，开启服务授权功能
     */
    @Configuration
    @EnableAuthorizationServer
    protected class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

        //private TokenStore tokenStore = new InMemoryTokenStore();//在内存中存储token
        JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);//数据库存储token

        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

      //  @Autowired
        @Resource
        private UserServiceDetail userServiceDetail;

        /**
         *
         * @param clientDetailsServiceConfigurer 配置了客户端的一些基本信息
         * @throws Exception 异常
         */
        @Override
        public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception{
            clientDetailsServiceConfigurer
                    //将客户端信息存储在内存中
                    .inMemory()
                    //创建了一个clientId为browser的客户端
                    .withClient("browser")
                    //验证类型为refresh_token和password
                    .authorizedGrantTypes("refresh_token","password")
                    //客户端域为ui
                    .scopes("ui")
                    .and()
                    //创建了另一个clientId为service-hi的客户端
                    .withClient("service-hi")
                    .secret("123456")
                    .authorizedGrantTypes("client_credentials","refresh_token","password")
                    .scopes("server");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
            endpoints
                    //Token存储方式
                    .tokenStore(tokenStore)
                    //配置AuthenticationManager的Bean，开启密码类型的验证
                    .authenticationManager(authenticationManager)
                    //用来读取验证用户的信息
                    .userDetailsService(userServiceDetail);
            endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);// add get method
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception{
            oauthServer
                    //对获取token的请求不进行拦截，只需验证获取token的验证信（用户名username和密码password），这些准确无误，就返回Token
                    .tokenKeyAccess("permitAll()")
                    //检查token的策略
                    .checkTokenAccess("isAuthenticated()");

        }

    }

}
