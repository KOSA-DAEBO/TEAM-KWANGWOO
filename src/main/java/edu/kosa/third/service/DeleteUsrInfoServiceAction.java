package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;


public class DeleteUsrInfoServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		String usrId = request.getParameter("usrId");
		int empNo = Integer.parseInt(request.getParameter("empNo"));

		UsrInfoDao usrInfoDao = new UsrInfoDao();
		boolean result = usrInfoDao.deleteEmpInfo(usrId,empNo);
		response.setContentType("text/html;charset=UTF-8");
		if(result) {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('퇴사처리가 되었습니다.');location.href='empList.do'</script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('퇴사처리가 되지 않았습니다. '); window.history.back();</script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		forward.setPath("empList.do");
		return forward;
	}

}
