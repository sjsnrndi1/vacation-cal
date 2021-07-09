package jung.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
		mav.addObject("vacationList", vacationList);
		mav.setViewName("week-numbers");
		return mav;
	}
	/***** »ﬁ∞° ¡∂»∏ *****/
	
	/***** »ﬁ∞° √ﬂ∞° 
	 * @throws IOException *****/
	@RequestMapping(value="/vacation_input_form")
	public ModelAndView inputVacation(@RequestParam("vacation_input_name") String vacation_name, @RequestParam("vacation_input_month") int vacation_month,
			@RequestParam("vacation_input_day") int vacation_day, HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		boolean check = userInfoService.addVacation(vacation_name, vacation_month, vacation_day);
		if(!check) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('»ﬁ∞° µÓ∑œ Ω«∆–!'); </script>");
			out.flush();			
		}
		List<UserInfoVO> vacationList = userInfoService.getVacations();
		mav.addObject("vacationList", vacationList);
		mav.setViewName("week-numbers");
		return mav;
	}
	/***** »ﬁ∞° √ﬂ∞° *****/
	
	/***** »ﬁ∞° ªË¡¶ 
	 * @throws IOException *****/
	@RequestMapping(value="/vacation_delete_form")
	public ModelAndView deleteVacation(@RequestParam("vacation_delete_name") String vacation_name, @RequestParam("vacation_delete_month") int vacation_month,
			@RequestParam("vacation_delete_day") int vacation_day, HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		boolean check = userInfoService.removeVacation(vacation_name, vacation_month, vacation_day);
		if(!check) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('»ﬁ∞° ªË¡¶ Ω«∆–!'); </script>");
			out.flush();			
		}
		List<UserInfoVO> vacationList = userInfoService.getVacations();
		mav.addObject("vacationList", vacationList);
		mav.setViewName("week-numbers");
		return mav;
	}
	/***** »ﬁ∞° ªË¡¶ *****/
}