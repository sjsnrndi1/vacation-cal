package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.UserInfoVO;

public interface MemberMapper {

	ArrayList<UserInfoVO> getVacations(); //�ް� ��ȸ

	void addVacation(HashMap<Object, Object> map); //�ް� �߰�

	void removeVacation(HashMap<Object, Object> map); //�ް� ����

}