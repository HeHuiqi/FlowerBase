package com.hhq.hq.HqConfig;

import com.hhq.hq.HqDAO.HqUserDAOImp;
import com.hhq.hq.HqSpringDI.Hello;
import com.hhq.hq.HqSpringDI.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
//会扫描带有@Component的类
@ComponentScan
public class ApplicationJavaConfig {


    @Bean
    public Hello getHello(){
        Hello hello = new Hello();
        hello.setName("小明");
        return hello;
    }

    @Bean
    public  HqAutoSpeak autoSpeak(){

        return new HqAutoSpeak();
    }
    @Bean
    public HqAutoHello autoHello(){

        return  new HqAutoHello();
    }

    //设置一个名字
    @Bean(name = "hqStudent")
    public HqStudent getStudent(){
        return  new HqStudent();
    }

    @Bean
    public HqTeacher getTeacher(){
        return  new HqTeacher();
    }
    @Bean
    //自动传入，因为前面已经配置过bean了
    public HqPerson getPerson(HqStudent student){
        return  new HqPerson(student);
    }

    @Bean
    public HqSchool getSchool(HqTeacher teacher){
        HqSchool school = new HqSchool();
        school.setTeacher(teacher);
        return school;
    }



    //配置jdbc
    @Bean
    public DriverManagerDataSource dataSource(){

        Properties mysqlProperties = new Properties();

        String propertiesPath = "mysql-jdbc.properties";
        String path = ApplicationJavaConfig.class.getClassLoader().getResource(propertiesPath).getPath();

        try {
            FileInputStream inputStream = new FileInputStream(path);
            mysqlProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(mysqlProperties.getProperty("mysql_drive"));
        dataSource.setUrl(mysqlProperties.getProperty("mysql_url"));
        dataSource.setUsername(mysqlProperties.getProperty("username"));
        dataSource.setPassword(mysqlProperties.getProperty("password"));
        return dataSource;
    }
    @Bean
    public  JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public HqUserDAOImp getUserDaoImp(DataSource dataSource,JdbcTemplate jdbcTemplate){

        HqUserDAOImp userDAOImp = new HqUserDAOImp();
        //setter方法或属性使用了@Autowired注解就不用调用方法了
//        userDAOImp.setDataSource(dataSource);
//        userDAOImp.setJdbcTemplate(jdbcTemplate);
        return userDAOImp;
    }

}
