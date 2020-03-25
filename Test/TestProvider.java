import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

class TestProvider {

	@Test
	void test() {
		//1、获得mybatis核心配置文件的一个输入流对象
		try {
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2、通过输入流来创建sqlSessionFactory对象
			SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
			
			//3\通过SqlSessionFactory对象来创建Sqlsession对象
			SqlSession session=fac.openSession();
			//4、调用sqlSession对象的方法来执行操作
			//执行sql语句值返回一个数据的方法selectOne
			int count=session.selectOne("dao.ProviderMapper.getCount");
			System.out.println("获得数据总数");
			System.out.println("获得数据总数"+count);
			//5、关闭sqlSession对象
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
