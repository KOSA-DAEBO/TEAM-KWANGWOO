package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.JoinDao;
import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.UsrDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.Base64;

public class JoinCustomerOkServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("usrId"); //아이디 중복 확인은 추후에 이벤트로 추가 하여 flag 등등의 값을 받아옴
        String pwd = request.getParameter("usrPwd");
        String name = request.getParameter("usrName"); // 필수 입력값은 아이디 비번 이름 주소 전화번호뿐이니 구분해서 호출
        String email = request.getParameter("usrEmail") == null ? "" : request.getParameter("usrEmail");//null 값처리
        String tel = request.getParameter("usrTel");
        String addr = request.getParameter("sample6_address") + " " + request.getParameter("sample6_detailAddress");
        String gender = request.getParameter("usrGender");
        Date birth = Date.valueOf(request.getParameter("usrBirth"));


        SecureRandom random = null;
        String salt;
        try {

            random = SecureRandom.getInstance("SHA1PRNG");
            byte[] bytes = new byte[8];
            random.nextBytes(bytes);
            salt = new String(Base64.getEncoder().encode(bytes));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        JoinDao dao = new JoinDao();
        dao.joinCustomerChk(new UsrDto(id, pwd, salt, ""),
                new CustomerDto("", "", email, tel, gender, birth, addr, name)); // hex 값추가, 회사코드 들어오면 직원으로 Join회원가입

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("loginCustomer.do"); //로그인 페이지로 이동
        return forward;
    }
}
