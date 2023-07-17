package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.JoinDao;
import edu.kosa.third.dto.EmpDto;
import edu.kosa.third.dto.UsrDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.Base64;
public class JoinEmpOkServiceAction implements Action {
    class CompanyCode{ //회사별 코드
        private final static String DAEBO = "789456"; // 대보코드
        private final static String DAEBOF = "74856923"; //대보 프리랜서 코드
        private final static String KOSA = "1234"; //코사 코드

    }

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

        String companyCode = (request.getParameter("companyCode"));

        switch (companyCode){ //회사 코드를 제대로 입력하였을때만 회원가입 요청이 감
            case CompanyCode.DAEBO :
            case CompanyCode.DAEBOF :
            case CompanyCode.KOSA :

                String id = request.getParameter("usrId"); //아이디 중복 확인은 추후에 이벤트로 추가 하여 flag 등등의 값을 받아옴
                String pwd = request.getParameter("usrPwd");
                String name = request.getParameter("usrName"); // 필수 입력값은 아이디 비번 이름 주소 전화번호뿐이니 구분해서 호출
                String email = request.getParameter("usrEmail") == null ? "" : request.getParameter("usrEmail");//null 값처리
                String tel = request.getParameter("usrTel");
                String addr = request.getParameter("usrAddr");
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
                Date now = new Date(System.currentTimeMillis());

                JoinDao dao = new JoinDao();
                dao.joinEmpChk(new UsrDto(id, pwd, salt, ""),
                        new EmpDto(0,0,5,5,birth,now,id,name,email,tel,addr,gender,false,false));
                break;
            default:
                break;
        }

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("/WEB-INF/views/main/main.jsp"); //로그인 완료 메인 페이지로 이동
        return forward;
    }
}
