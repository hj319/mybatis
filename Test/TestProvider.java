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
		//1�����mybatis���������ļ���һ������������
		try {
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2��ͨ��������������sqlSessionFactory����
			SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
			
			//3\ͨ��SqlSessionFactory����������Sqlsession����
			SqlSession session=fac.openSession();
			//4������sqlSession����ķ�����ִ�в���
			//ִ��sql���ֵ����һ�����ݵķ���selectOne
			int count=session.selectOne("dao.ProviderMapper.getCount");
			System.out.println("�����������");
			System.out.println("�����������"+count);
			//5���ر�sqlSession����
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
