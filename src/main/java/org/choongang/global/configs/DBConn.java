package org.choongang.global.configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

public class DBConn {
    private static SqlSessionFactory factory;

    static {
        try{
        Reader reader = Resources.getResourceAsReader("org/choongang/global/configs/mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
    }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static SqlSession getSession(boolean autoCommit)
    {
        return factory.openSession(autoCommit);
    }
    public static SqlSession getSession(){
        return getSession(true);
    }
}
