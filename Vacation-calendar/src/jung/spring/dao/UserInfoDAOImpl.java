package jung.spring.dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jung.spring.mybatis.MemberMapper;
import jung.spring.vo.UserInfoVO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	/***** »ﬁ∞° ¡∂»∏ *****/
	@Override
	public ArrayList<UserInfoVO> getVacation() {
		// TODO Auto-generated method stub
		MemberMapper vacationMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<UserInfoVO> vacationList = vacationMapper.getVacations();
		return vacationList;
	}
	/***** »ﬁ∞° ¡∂»∏ *****/
	
	/***** »ﬁ∞° √ﬂ∞° 
	 * @param response *****/
	@Override
	public boolean addVacation(String vacation_name, int vacation_month, int vacation_day) {
		// TODO Auto-generated method stub
		MemberMapper vacationMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<UserInfoVO> vacationList = vacationMapper.getVacations();
		boolean overlapCheck = true;
		for(int i = 0; i < vacationList.size(); i++) {
			if(vacationList.get(i).getName().equals(vacation_name) && vacationList.get(i).getMonth() == vacation_month && vacationList.get(i).getDay() == vacation_day) {
				overlapCheck = false;
				break;
			} else {
				overlapCheck = true;
			}
		}
		System.out.println("µµ¬¯");
		if(overlapCheck) {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("vacation_name", vacation_name);
			map.put("vacation_month", vacation_month);
			map.put("vacation_day", vacation_day);
			vacationMapper.addVacation(map);
		}
		return overlapCheck;
	}
	/***** »ﬁ∞° √ﬂ∞° *****/
	
	/***** »ﬁ∞° ªË¡¶ 
	 * @return *****/
	@Override
	public boolean removeVacation(String vacation_name, int vacation_month, int vacation_day) {
		// TODO Auto-generated method stub
		MemberMapper vacationMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<UserInfoVO> vacationList = vacationMapper.getVacations();
		boolean overlapCheck = true;
		for(int i = 0; i < vacationList.size(); i++) {
			if(vacationList.get(i).getName().equals(vacation_name) && vacationList.get(i).getMonth() == vacation_month && vacationList.get(i).getDay() == vacation_day) {
				overlapCheck = true;
				break;
			} else {
				overlapCheck = false;
			}
		}
		if(overlapCheck) {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("vacation_name", vacation_name);
			map.put("vacation_month", vacation_month);
			map.put("vacation_day", vacation_day);
			vacationMapper.removeVacation(map);
		}
		return overlapCheck;
	}
	/***** »ﬁ∞° ªË¡¶ *****/
}