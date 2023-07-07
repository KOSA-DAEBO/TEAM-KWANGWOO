package edu.kosa.third.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.loginDao;
import edu.kosa.third.dto.CustomerDto;


import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class loginCustomerOkServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("usrId");
		String pwd = request.getParameter("usrPwd");

		loginDao dao = new loginDao();
		CustomerDto dto;

		try {
			dto = dao.customerChk(id,pwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		HttpSession session = request.getSession(true);
		session.removeAttribute("login");
		session.setAttribute("login",dto);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		if(dto == null){ // 로그인 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			out.println("<script>alert('아이디 혹은 비밀번호가 틀렸습니다.'); location.href='/loginCustomer.do';</script>");
			out.flush();
		}else{
			forward.setPath("index.jsp");
		}
		return forward;
	}

}
