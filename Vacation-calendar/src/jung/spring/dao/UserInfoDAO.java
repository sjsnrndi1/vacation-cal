package jung.spring.dao;

import java.util.ArrayList;

import jung.spring.vo.UserInfoVO;

public interface UserInfoDAO {

	ArrayList<UserInfoVO> getVacation(); //�ް� ��ȸ

	void addVacation(String vacation_name, int vacation_month, String vacation_day); //�ް� �߰�

	void removeVacation(String vacation_name, int vacation_month, String vacation_day); //�ް� ����
	
}