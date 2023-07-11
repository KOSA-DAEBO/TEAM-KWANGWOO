package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.JoinDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class idDuplicateOkServiceAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("usrId");

        JoinDao dao = new JoinDao();
        boolean duplChk = dao.idDuplChk(id);

        HttpSession session = request.getSession(true);
        session.removeAttribute("duplChkId");
        session.setAttribute("duplChkId",duplChk);

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);

        if(duplChk == false) {

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out;
            try {
                out = response.getWriter();
                out.println("<script>alert('이미 존재 하는 아이디 입니다.'); window.history.back();</script>");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            forward.setRedirect(true);
            forward.setPath("idDuplChk.do?usrId="+id);
            return forward;
        }

    }
}
