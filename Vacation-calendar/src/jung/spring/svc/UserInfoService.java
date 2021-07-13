package jung.spring.svc;

import java.util.List;

import jung.spring.vo.UserInfoVO;

public interface UserInfoService {

	List<UserInfoVO> getVacations(); // »ﬁ∞° ¡∂»∏

	void addVacation(String vacation_name, int vacation_month, String vacation_day); // »ﬁ∞° √ﬂ∞°

	void removeVacation(String vacation_name, int vacation_month, String vacation_day); // »ﬁ∞° ªË¡¶
	
}