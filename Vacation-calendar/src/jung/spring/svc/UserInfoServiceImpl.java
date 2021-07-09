package jung.spring.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jung.spring.dao.UserInfoDAO;
import jung.spring.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	/***** »ﬁ∞° ¡∂»∏ *****/
	@Override
	public List<UserInfoVO> getVacations() {
		// TODO Auto-generated method stub
		ArrayList<UserInfoVO> vacationList = userInfoDAO.getVacation();
		return vacationList;
	}
	/***** »ﬁ∞° ¡∂»∏ *****/
	
	/***** »ﬁ∞° √ﬂ∞° 
	 * @return *****/
	@Override
	public void addVacation(String vacation_name, int vacation_month, int vacation_day) {
		// TODO Auto-generated method stub
		userInfoDAO.addVacation(vacation_name, vacation_month, vacation_day);
	}
	/***** »ﬁ∞° √ﬂ∞° *****/
	
	/***** »ﬁ∞° ªË¡¶ 
	 * @return *****/
	@Override
	public void removeVacation(String vacation_name, int vacation_month, int vacation_day) {
		// TODO Auto-generated method stub
		userInfoDAO.removeVacation(vacation_name, vacation_month, vacation_day);
	}
	/***** »ﬁ∞° ªË¡¶ *****/
}