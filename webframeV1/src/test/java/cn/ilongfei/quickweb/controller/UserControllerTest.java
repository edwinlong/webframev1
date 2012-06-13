package cn.ilongfei.quickweb.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerMapping;

import cn.ilongfei.quickweb.comm.test.base.ControllerTestBase;

/**
 * UserController测试
 * 
 */
public class UserControllerTest extends ControllerTestBase {
	@Autowired
	private UserController controller;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		//是否支持controller class级别的mapping，
		//例：如果设为false，则/user不接受输入，而/user/1可以
		request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
		response = new MockHttpServletResponse();
		response.setCharacterEncoding("UTF-8");
	}

	@Test
	public void testGet() throws Exception {
		request.setMethod("GET");
		request.setRequestURI("/user");
		handlerAdapter.handle(request, response, controller);
		System.out.println(response.getContentAsString());
		
		//assertEquals("{\"success\":false,\"msg\":\"原密码不能为空！\"}", response.getContentAsString());
	}
	
	/*@Test
	public void testSimple() throws Exception {
		request.setMethod("POST");
		request.setRequestURI("/user");
		request.setParameter("oldpassword", "");
		request.setParameter("password", "");
		request.setParameter("repassword", "");
		request.setParameter("userId", "ADSF");

		handlerAdapter.handle(request, response, controller);
		assertEquals("{\"success\":false,\"msg\":\"原密码不能为空！\"}", response.getContentAsString());
	}*/

	/*@Test
	public void testAll() throws Exception {
		request.setMethod("POST");
		request.setRequestURI("/user/");
		request.setParameter("limit", "10");
		request.setParameter("start", "1");
		
		handlerAdapter.handle(request, response, controller);
		assertNotNull(response.getContentAsString());
	}
	@Test
	public void testEasyMock() throws Exception {
		request.setMethod("POST");
		request.setRequestURI("/user/");
		request.setParameter("limit", "10");
		request.setParameter("start", "1");
		controller = EasyMock.createMock(UserController.class);
		handlerAdapter.handle(request, response, controller);
		assertNotNull(response.getContentAsString());
	}*/
}
