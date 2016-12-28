package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	   xmlns:context="http://www.springframework.org/schema/context"
	   xsi:schemaLocation="
	      http://www.springframework.org/schema/beans 
	      http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
	      http://www.springframework.org/schema/context 
	      http://www.springframework.org/schema/context/spring-context-4.1.xsd">
	 
	   <context:property-placeholder location="classpath:persistence-mysql.properties" />
	 
	   <bean id="sessionFactory"
	    class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
	      <property name="dataSource" ref="dataSource" />
	      <property name="packagesToScan" value="org.baeldung.spring.persistence.model" />
	      <property name="hibernateProperties">
	         <props>
	            <prop key="hibernate.hbm2ddl.auto">${hibernate.hbm2ddl.auto}</prop>
	            <prop key="hibernate.dialect">${hibernate.dialect}</prop>
	         </props>
	      </property>
	   </bean>
	 
	   <bean id="dataSource"
	    class="org.apache.tomcat.dbcp.dbcp.BasicDataSource">
	      <property name="driverClassName" value="${jdbc.driverClassName}" />
	      <property name="url" value="${jdbc.url}" />
	      <property name="username" value="${jdbc.user}" />
	      <property name="password" value="${jdbc.pass}" />
	   </bean>
	 
	   <bean id="transactionManager"
	    class="org.springframework.orm.hibernate4.HibernateTransactionManager">
	      <property name="sessionFactory" ref="sessionFactory" />
	   </bean>
	 
	   <bean id="persistenceExceptionTranslationPostProcessor"
	    class="org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor"/>
	 
	</beans>
}

