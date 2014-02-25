package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Component("u") 
public class UserDAOImpl implements UserDAO {
	
	//dataSource 注入到了sessionFactory 中，所以使用sessionFactory 就不再需要dataSource
	/*private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User user) {
		
		
		
		//Hibernate
		//JDBC
		//XML
		//NetWork
		
		//此处是和dataSource配套的代码		
		/*Connection conn = null;
		 * 
		 * try {
			conn = dataSource.getConnection();
			conn.createStatement().executeUpdate("insert into user values (null,'zhangsan');");
			//conn.commit;   //这里不能commit，错误提示自动提交了
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
					conn=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		
		System.out.println("session factory class:" + sessionFactory.getClass());
			Session s = sessionFactory.openSession();
			s.beginTransaction();
			s.save(user);
			s.getTransaction().commit();
		System.out.println("user saved!");
		//throw new RuntimeException("exeption!");
	}

}
