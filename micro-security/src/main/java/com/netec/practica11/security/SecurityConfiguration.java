package com.netec.practica11.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfiguration {
	@Bean
	public DataSource dataSource() {
		// return new
		// EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		// .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
		// .build();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/practica11");
		dataSource.setUsername("root");
		dataSource.setPassword("abcd_2357");
		return dataSource;

	}

	@Bean
	public UserDetailsManager users(DataSource dataSource) {
		// Usuarios, roles & autoridades
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
		userDetailsManager.setDataSource(dataSource);

		// Comprobar y crear usuarios si no existen
		if (!userDetailsManager.userExists("edgar")) {
			UserDetails user = User.withUsername("edgar").password("{noop}edgar123").roles("USER").build();
			userDetailsManager.createUser(user);
		}

		if (!userDetailsManager.userExists("zaira")) {
			UserDetails admin = User.withUsername("zaira").password("{noop}zaira123").roles("ADMIN").build();
			userDetailsManager.createUser(admin);
		}

		return userDetailsManager;
	}

}
