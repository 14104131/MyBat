package db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
//数据库访问

public class DBAccess {
    public SqlSession getSqlSession()throws IOException {
        Reader reader= Resources.getResourceAsReader("Configuration.xml");
        //通过配置文件获取数据库连接信息
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //通过配置信息构建一个SqlSessionFactory
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //通过sqlSession打开一个数据库会话
        return sqlSession;

    }
}
