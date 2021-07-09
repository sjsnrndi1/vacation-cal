package jung.spring.svc;

import java.util.List;

import jung.spring.vo.UserInfoVO;

public interface UserInfoService {

	List<UserInfoVO> getVacations(); // »ﬁ∞° ¡∂»∏

	boolean addVacation(String vacation_name, int vacation_month, int vacation_day); // »ﬁ∞° √ﬂ∞°

	boolean removeVacation(String vacation_name, int vacation_month, int vacation_day); // »ﬁ∞° ªË¡¶
	
}