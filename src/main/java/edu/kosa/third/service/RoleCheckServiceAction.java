package edu.kosa.third.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;

public class RoleCheckServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		UsrInfoDao usrDao = new UsrInfoDao();
		ActionForward forward = new ActionForward();

		String usrId = request.getParameter("usrId");
		int role = usrDao.managerEmp(usrId);
		
		if (role == 1) {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('관리자 계정으로 접속하셨습니다.');</script>");
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			forward.setPath("deptMenu.do");
		} else {
			
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('일반 계정으로 접속하셨습니다.');</script>");
				out.flush();
				out.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			forward.setPath("empDetailInfo.do");
		}

		forward.setRedirect(false);
		return forward;
	}
}
