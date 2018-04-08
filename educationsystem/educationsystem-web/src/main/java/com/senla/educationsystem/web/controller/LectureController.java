package com.senla.educationsystem.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.educationsystem.api.service.ILectureService;
import com.senla.educationsystem.model.bean.Lecture;
import com.senla.educationsystem.model.bean.User;
import com.senla.educationsystem.model.userrole.UserRole;
import com.senla.educationsystem.web.dto.NewLecturesDto;
import com.senla.educationsystem.web.token.TokenRepository;

@RestController
@RequestMapping("/lecture")
public class LectureController {

	private static Logger log = Logger.getLogger(LectureController.class.getName());

	@Autowired
	private ILectureService lectureService;

	@RequestMapping(value = "/addList", method = RequestMethod.POST)
	public void addLecturesToCourse(@RequestHeader String token, @RequestBody NewLecturesDto dto) {
		User lecturer = TokenRepository.getInstance().getUserByToken(token);
		try {
			if (dto != null) {
				if (!lecturer.getRole().equals(UserRole.LECTURER)) {
					return;
				}
				lectureService.addLecturesToCourse(dto.getLectures(), dto.getCourseId());
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public boolean removeLecture(@RequestHeader String token, @RequestBody Lecture lecture) {
		User lecturer = TokenRepository.getInstance().getUserByToken(token);
		boolean result = false;
		try {
			if (lecture != null) {
				if (!lecturer.getRole().equals(UserRole.LECTURER)) {
					return false;
				}
				result = lectureService.removeLecture(lecture);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public boolean updateCourse(@RequestHeader String token, @RequestBody Lecture lecture) {
		User lecturer = TokenRepository.getInstance().getUserByToken(token);
		boolean result = false;
		try {
			if (lecture != null) {
				if (!lecturer.getRole().equals(UserRole.LECTURER)) {
					return false;
				}
				result = lectureService.updateLecture(lecture);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

}
