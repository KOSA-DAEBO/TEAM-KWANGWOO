package edu.kosa.third.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.UsrInfoDao;
import edu.kosa.third.dto.EmpDetailsDto;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.UsrDto;

public class deleteUsrInfoServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		String status = request.getParameter("status");
		int empNo = Integer.parseInt(request.getParameter("empNo")); 
		String usrId = request.getParameter("usrId");
		Date departureDate = Date.valueOf(request.getParameter("departureDate"));
		
		UsrDto usrDto = new UsrDto();
		usrDto.setStatus(status);
		usrDto.setUsrId(usrId);
		
		EmpDto empDto = new EmpDto();
		empDto.setDepartureDate(departureDate);
		empDto.setEmpNo(empNo);
		
		UsrInfoDao usrInfoDao = new UsrInfoDao();
		
		EmpDetailsDto empDetailsDto = new EmpDetailsDto(usrDto, empDto);
		empDetailsDto.setUsrDto(usrDto);
		empDetailsDto.setEmpDto(empDto);
		
		boolean result = usrInfoDao.deleteEmpInfo(empDetailsDto);
		
		if(result) {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('퇴사처리가 되었습니다. ');</script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			forward.setPath(usrId);
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
		
		usrInfoDao.deleteEmpInfo(new EmpDetailsDto(usrDto, empDto));
				
		forward.setPath("/showEmpInfo.do");
		return forward;
	}

}
