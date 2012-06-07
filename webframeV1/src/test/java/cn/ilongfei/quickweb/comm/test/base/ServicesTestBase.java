package cn.ilongfei.quickweb.comm.test.base;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Services基本测试类<br>
 * 其他类继承即可
 * 
 * @author chenxin
 * @date 2011-08-10 下午04:34:17
 */
@ContextConfiguration(locations = { "classpath:application-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class ServicesTestBase extends AbstractTransactionalJUnit4SpringContextTests {

	/**
	 *要指明唯一的数据源，如果只有一个就不用指明了。
	 */
	/*@Override
	@Resource(name = "dbcp")
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}*/

}
