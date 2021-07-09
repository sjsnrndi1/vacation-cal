package jung.spring.dao;

import java.util.ArrayList;

import jung.spring.vo.UserInfoVO;

public interface UserInfoDAO {

	ArrayList<UserInfoVO> getVacation(); //�ް� ��ȸ

	boolean addVacation(String vacation_name, int vacation_month, int vacation_day); //�ް� �߰�

	boolean removeVacation(String vacation_name, int vacation_month, int vacation_day); //�ް� ����
	
}