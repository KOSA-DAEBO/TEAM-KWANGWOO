package edu.kosa.third.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//생성하는 모든 서비스는 Action 인터페이스를 구현했으면 좋겠다

public interface Action {
	public ActionForward execute(HttpServletRequest request , HttpServletResponse response);
}

