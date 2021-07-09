package jung.spring.dao;

import java.util.ArrayList;

import jung.spring.vo.UserInfoVO;

public interface UserInfoDAO {

	ArrayList<UserInfoVO> getVacation(); //»ﬁ∞° ¡∂»∏

	void addVacation(String vacation_name, int vacation_month, int vacation_day); //»ﬁ∞° √ﬂ∞°

	void removeVacation(String vacation_name, int vacation_month, int vacation_day); //»ﬁ∞° ªË¡¶
	
}