package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.DeptDao;
import edu.kosa.third.dto.DeptDto;

public class AddDeptServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		if (request.getParameter("deptName") == null) {
			PrintWriter printer;
			try {
				printer = response.getWriter();
				printer.println("<script>alert('부서이름이 입력되지 않았습니다.'); window.history.back();</script>");
				printer.flush();
				printer.close();
			}catch(Exception e) {}
			forward.setPath("deptMenu.do");
			return forward;
		} else if(request.getParameter("deptNo") == null) {
			PrintWriter printer;
			try {
				printer = response.getWriter();
				printer.println("<script>alert('부서번호가 입력되지 않았습니다.'); window.history.back();</script>");
				printer.flush();
				printer.close();
			}catch(Exception e) {}
			forward.setPath("deptMenu.do");
			return forward;
		} 
		
		
		else {
			String deptName = request.getParameter("deptName");
			int deptNo = Integer.parseInt(request.getParameter("deptNo"));
			DeptDao deptdao = new DeptDao();
				
			boolean result = deptdao.insertDept(new DeptDto(deptNo, deptName));
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter printer;
			try {
				printer = response.getWriter();
				printer.println("<script>alert('부서가 추가 되었습니다.'); window.history.back();</script>");
				printer.flush();
				printer.close();
			}catch (Exception e) {
			}
			
			if (result == false) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script>alert('부서가 추가 되지 않았습니다.'); window.history.back();</script>");
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			} else {
				forward.setRedirect(true);
				forward.setPath("deptMenu.do");
				return forward;
			}
		}
	}
}
