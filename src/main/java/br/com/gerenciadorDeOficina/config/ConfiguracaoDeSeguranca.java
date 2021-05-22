package br.com.gerenciadorDeOficina.config;

import br.com.gerenciadorDeOficina.jwt.ComponenteJWT;
import br.com.gerenciadorDeOficina.jwt.FiltroAutencicacaoJWT;
import br.com.gerenciadorDeOficina.jwt.FiltroDeAutorizacao;
import br.com.gerenciadorDeOficina.jwt.UsuarioLoginService;
import br.com.gerenciadorDeOficina.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class ConfiguracaoDeSeguranca extends WebSecurityConfigurerAdapter {

    @Autowired
    private ComponenteJWT componenteJWT;

    @Autowired
    private UsuarioLoginService usuarioLoginService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.cors().configurationSource(configuracaoDeCors());

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/clientes", "veiculo**", "servico**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "login")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/clientes", "veiculo**", "servico**")
                .permitAll()
                .antMatchers(HttpMethod.PATCH, "/clientes/**", "veiculo**", "servico**")
                .permitAll()
                .antMatchers("/h2-console/**")
                .permitAll()
                .anyRequest().authenticated();

        http.headers().frameOptions().disable();


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilter(new FiltroAutencicacaoJWT(componenteJWT, authenticationManager(), usuarioService));
        http.addFilter(new FiltroDeAutorizacao(authenticationManager(), componenteJWT, usuarioLoginService));

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
                "/configuration/**", "/swagger-ui.html", "/webjars/**");
    }

    @Bean
    CorsConfigurationSource configuracaoDeCors(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    protected BCryptPasswordEncoder critografarSenha() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioLoginService).passwordEncoder(critografarSenha());
    }
}