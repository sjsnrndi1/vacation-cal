package jung.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

import jung.spring.vo.UserInfoVO;

public interface MemberMapper {

	ArrayList<UserInfoVO> getVacations(); //»ﬁ∞° ¡∂»∏

	void addVacation(HashMap<Object, Object> map); //»ﬁ∞° √ﬂ∞°

	void removeVacation(HashMap<Object, Object> map); //»ﬁ∞° ªË¡¶

}