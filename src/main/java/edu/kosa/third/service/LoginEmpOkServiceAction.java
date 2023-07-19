package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.LoginDao;
import edu.kosa.third.dto.EmpDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginEmpOkServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("usrId");
        String pwd = request.getParameter("usrPwd");

        LoginDao dao = new LoginDao();
        EmpDto dto;

        try {
            dto = dao.EmpChk(id,pwd);
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
            out.println("<script>alert('아이디 혹은 비밀번호가 틀렸습니다.'); window.history.back();</script>");
            out.flush();
        }else{
            forward.setPath("commuteEmpChk.do"); //출근체크 페이지로 이동
        }
        return forward;

    }
}
