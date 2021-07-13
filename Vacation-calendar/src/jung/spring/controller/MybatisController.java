package jung.spring.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jung.spring.svc.UserInfoService;
import jung.spring.vo.UserInfoVO;

@Controller
public class MybatisController {

	@Autowired
	private UserInfoService userInfoService;
	
	/***** »ﬁ∞° ¡∂»∏ *****/
	@RequestMapping(value="/")
	public ModelAndView defaultCalendar() {
		ModelAndView mav = new ModelAndView();
		List<UserInfoVO> vacationList = userInfoService.getVacations();
		for(int i = 0; i < vacationList.size(); i++) {
			
		}
		mav.addObject("vacationList", vacationList);
		mav.setViewName("month-view");
		return mav;
	}
	/***** »ﬁ∞° ¡∂»∏ *****/
	
	/***** »ﬁ∞° √ﬂ∞° 
	 * @throws IOException *****/
	@RequestMapping(value="/vacation_input_form")
	public ModelAndView inputVacation(@RequestParam("vacation_input_name") String vacation_name, @RequestParam("vacation_input_month") int vacation_month,
			@RequestParam("vacation_input_day") String vacation_day) {
		ModelAndView mav = new ModelAndView();
		userInfoService.addVacation(vacation_name, vacation_month, vacation_day);
		List<UserInfoVO> vacationList = userInfoService.getVacations();
		mav.addObject("vacationList", vacationList);
		mav.setViewName("month-view");
		return mav;
	}
	/***** »ﬁ∞° √ﬂ∞° *****/
	
	/***** »ﬁ∞° ªË¡¶ 
	 * @throws IOException *****/
	@RequestMapping(value="/vacation_delete_form")
	public ModelAndView deleteVacation(@RequestParam("vacation_delete_name") String vacation_name, @RequestParam("vacation_delete_month") int vacation_month,
			@RequestParam("vacation_delete_day") String vacation_day) {
		ModelAndView mav = new ModelAndView();
		userInfoService.removeVacation(vacation_name, vacation_month, vacation_day);
		List<UserInfoVO> vacationList = userInfoService.getVacations();
		mav.addObject("vacationList", vacationList);
		mav.setViewName("month-view");
		return mav;
	}
	/***** »ﬁ∞° ªË¡¶ *****/
}