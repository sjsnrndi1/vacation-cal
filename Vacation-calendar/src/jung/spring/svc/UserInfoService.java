package jung.spring.svc;

import java.util.List;

import jung.spring.vo.UserInfoVO;

public interface UserInfoService {

	List<UserInfoVO> getVacations(); // �ް� ��ȸ

	void addVacation(String vacation_name, int vacation_month, String vacation_day); // �ް� �߰�

	void removeVacation(String vacation_name, int vacation_month, String vacation_day); // �ް� ����
	
}