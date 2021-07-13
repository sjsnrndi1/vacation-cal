package jung.spring.dao;

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
	
	/***** »ﬁ∞° √ﬂ∞° *****/
	@Override
	public void addVacation(String vacation_name, int vacation_month, String vacation_day) {
		// TODO Auto-generated method stub
		MemberMapper vacationMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<UserInfoVO> vacationList = vacationMapper.getVacations();
		boolean overlapCheck = true;
		String va_day_individually[] = vacation_day.split(",");

		Loop1 :
		for(int i = 0; i < vacationList.size(); i++) {
			if(vacationList.get(i).getName().equals(vacation_name) && vacationList.get(i).getMonth() == vacation_month) {
				for(int j = 0; j < va_day_individually.length; j++) {
					if(vacationList.get(i).getDay() == Integer.parseInt(va_day_individually[j])) {
						va_day_individually[j] = null;
						overlapCheck = false;
						break Loop1;
					}
				}
			} else {
				overlapCheck = true;
			}
		}
		
		for(int i = 0; i < va_day_individually.length; i++) {
			if(overlapCheck && va_day_individually[i] != null) {
				HashMap<Object, Object> map = new HashMap<Object, Object>();
				map.put("vacation_name", vacation_name);
				map.put("vacation_month", vacation_month);
				map.put("vacation_day", Integer.parseInt(va_day_individually[i]));
				vacationMapper.addVacation(map);
			}
		}
	}
	/***** »ﬁ∞° √ﬂ∞° *****/
	
	/***** »ﬁ∞° ªË¡¶ 
	 * @return *****/
	@Override
	public void removeVacation(String vacation_name, int vacation_month, String vacation_day) {
		// TODO Auto-generated method stub
		MemberMapper vacationMapper = sqlSession.getMapper(MemberMapper.class);
		ArrayList<UserInfoVO> vacationList = vacationMapper.getVacations();
		boolean overlapCheck = true;
		String va_day_individually[] = vacation_day.split(",");
		int count = 0;
		
		Loop1 :
			for(int i = 0; i < vacationList.size(); i++) {
				if(vacationList.get(i).getName().equals(vacation_name) && vacationList.get(i).getMonth() == vacation_month) {
					for(int j = 0; j < va_day_individually.length; j++) {
						if(vacationList.get(i).getDay() == Integer.parseInt(va_day_individually[j])) {
							count += 1;
							if(count == va_day_individually.length) {
								overlapCheck = true;
								break Loop1;								
							}
						}
					}
				} else {
					overlapCheck = false;
				}
			}
		for(int i = 0; i < va_day_individually.length; i++) {
			if(overlapCheck && va_day_individually[i] != null) {
				HashMap<Object, Object> map = new HashMap<Object, Object>();
				map.put("vacation_name", vacation_name);
				map.put("vacation_month", vacation_month);
				map.put("vacation_day", Integer.parseInt(va_day_individually[i]));
				vacationMapper.removeVacation(map);
			}
		}
	}
	/***** »ﬁ∞° ªË¡¶ *****/
}