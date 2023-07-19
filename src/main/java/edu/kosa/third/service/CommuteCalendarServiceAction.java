package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.CommuteDao;
import edu.kosa.third.dto.EmpDto;
import org.json.simple.JSONArray;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommuteCalendarServiceAction  implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        EmpDto dto = (EmpDto)session.getAttribute("login");

        CommuteDao dao = new CommuteDao();
        JSONArray jsonArray = dao.calendar(dto);

        //POST 방식으로 JsonArray 전달
        request.setAttribute("jsonArray", jsonArray);

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("/WEB-INF/views/commute/commuteEmp.jsp"); //emp 출근 캘린더 페이지
        return forward;
    }
}
