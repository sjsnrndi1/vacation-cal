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
	
	/***** �ް� ��ȸ *****/
	@Override
	public List<UserInfoVO> getVacations() {
		// TODO Auto-generated method stub
		ArrayList<UserInfoVO> vacationList = userInfoDAO.getVacation();
		return vacationList;
	}
	/***** �ް� ��ȸ *****/
	
	/***** �ް� �߰� 
	 * @return *****/
	@Override
	public boolean addVacation(String vacation_name, int vacation_month, int vacation_day) {
		// TODO Auto-generated method stub
		boolean check = userInfoDAO.addVacation(vacation_name, vacation_month, vacation_day);
		return check;
	}
	/***** �ް� �߰� *****/
	
	/***** �ް� ���� 
	 * @return *****/
	@Override
	public boolean removeVacation(String vacation_name, int vacation_month, int vacation_day) {
		// TODO Auto-generated method stub
		boolean check = userInfoDAO.removeVacation(vacation_name, vacation_month, vacation_day);
		return check;
	}
	/***** �ް� ���� *****/
}