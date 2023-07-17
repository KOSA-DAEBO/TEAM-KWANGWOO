package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.CommuteDao;
import edu.kosa.third.dto.EmpDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommuteEmpServiceAction  implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        ActionForward forward = new ActionForward();
        forward.setRedirect(false);

        EmpDto dto = (EmpDto)session.getAttribute("login");
        CommuteDao dao = new CommuteDao();
        String[] time = dao.commuteTimeChk(dto);

        session.setAttribute("att",time);

        forward.setPath("/WEB-INF/views/commute/commuteEmpChk.jsp");
        return forward;
    }
}
