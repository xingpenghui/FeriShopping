/**  
* @Title: DbUtils.java  
* @Package com.qf.common  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Feri 
* @date 2018年5月24日  
* @version V1.0  
*/  
package com.feri.common.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.pool.DruidDataSource;

/**  
* @Title: DbUtils.java  
* @Package com.qf.common  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Feri  
* @date 2018年5月24日  
* @version V1.0  
*/
public class DbUtils {
	private static String driverclass="com.mysql.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/db_city";
	private static String username="root";
	private static String password="xph666";
	//数据库连接池
	private static DruidDataSource ds;
	private static Connection conn;
	static{
		ds=new DruidDataSource();
		ds.setDriverClassName(driverclass);
		ds.setUrl(dburl);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setTimeBetweenEvictionRunsMillis(6000);
	}
	//执行非查询语句
	public static int executeUpdate(String sql,Object... vlus) {
		try {
			conn=ds.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			for(int i=0;i<vlus.length;i++){
				ps.setObject(i+1, vlus[i]);
			}
			int r= ps.executeUpdate();
			conn.close();
			return r;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//执行查询语句
	public static ResultSet executeQuery(String sql,Object... vlus) {
		try {
			conn=ds.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			for(int i=0;i<vlus.length;i++){
				ps.setObject(i+1, vlus[i]);
			}
			return ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// 查询的二次封装返回泛型 单个对象
	public static <T> T querySingle(String sql, Class<T> clz, Object... vlus) {
		try {
			//获取数据库连接对象
			conn = ds.getConnection();
			//获取操作sql对象 防止SQL注入
			PreparedStatement ps = conn.prepareStatement(sql);
			//赋值  设置参数
			for (int i = 0; i < vlus.length; i++) {
				ps.setObject(i + 1, vlus[i]);
			}
			//执行查询
			ResultSet rs = ps.executeQuery();
			//从ResultSet中获取数据
			if (rs.next()) {
				// 通过反射创建类的对象
				T obj = clz.newInstance();
				// 获取类中所有的属性
				Field[] arrf = clz.getDeclaredFields();
				// 遍历属性
				for (Field f : arrf) {
					// 设置忽略访问校验
					f.setAccessible(true);
					// 赋值
					f.set(obj, getV(rs, f.getName()));
				}
				//关闭
				rs.close();
				ps.close();
				conn.close();
				
				return obj;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// 根据数据库表的字段的数据类型 自动类型转换
	public static Object getV(ResultSet rs, String name) {
		ResultSetMetaData ma;
		Object res = null;
		try {
			ma = rs.getMetaData();
			String type = ma.getColumnTypeName(rs.findColumn(name));
			System.out.println(type);
			switch (type) {
			case "DATE":
				Date date1 = rs.getDate(name);
				res = new SimpleDateFormat("yyyy-MM-dd").format(date1);
				break;
			case "DATETIME":
				Date date2 = rs.getDate(name);
				res = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
				break;

			default:
				res = rs.getObject(name);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	}
	//查询的二次封装返回泛型 集合
	// 查询的二次封装返回泛型 单个对象
		public static <T> List<T> queryList(String sql, Class<T> clz, Object... vlus) {
			try {
				conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				for (int i = 0; i < vlus.length; i++) {
					ps.setObject(i + 1, vlus[i]);
				}
				ResultSet rs = ps.executeQuery();
				List<T> list=new ArrayList<>();
				while (rs.next()) {
					// 通过反射创建类的对象
					T obj = clz.newInstance();
					// 获取类中所有的属性
					Field[] arrf = clz.getDeclaredFields();
					// 遍历属性
					for (Field f : arrf) {
						// 设置忽略访问校验
						f.setAccessible(true);
						// 赋值
						f.set(obj, getV(rs, f.getName()));
					}
					
					list.add(obj);
				}
				rs.close();
				ps.close();
				conn.close();
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}

	
	//查询数量 泛型整型
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
