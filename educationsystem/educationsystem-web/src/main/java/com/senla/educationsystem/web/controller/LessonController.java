package com.senla.educationsystem.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.educationsystem.api.service.ILessonService;
import com.senla.educationsystem.model.bean.Lesson;

@RestController
@RequestMapping("/lesson")
public class LessonController {

	private static Logger log = Logger.getLogger(LessonController.class.getName());

	@Autowired
	private ILessonService lessonService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public boolean addLesson(@RequestBody Lesson lesson) {
		boolean result = false;
		try {
			if (lesson != null) {
				result = lessonService.addLesson(lesson);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public boolean removeLesson(@RequestBody Lesson lesson) {
		boolean result = false;
		try {
			if (lesson != null) {
				result = lessonService.removeLesson(lesson);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public boolean updateLesson(@RequestBody Lesson lesson) {
		boolean result = false;
		try {
			if (lesson != null) {
				result = lessonService.updateLesson(lesson);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

}
