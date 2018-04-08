package com.senla.educationsystem.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.educationsystem.api.service.ILessonTimeService;
import com.senla.educationsystem.model.bean.LessonTime;

@RestController
@RequestMapping("/lessonTime")
public class LessonTimeController {

	private static Logger log = Logger.getLogger(LessonTimeController.class.getName());

	@Autowired
	private ILessonTimeService lessonTimeService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addLessonTime(@RequestBody LessonTime time) {
		boolean result = false;
		try {
			if (time != null) {
				result = lessonTimeService.addLessonTime(time);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<LessonTime> getAllTimes() {
		List<LessonTime> times = null;
		try {
			times = lessonTimeService.getAllLessonTimes();
		} catch (Exception e) {
			log.error(e);
		}
		return times;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public boolean removeLessonTime(@RequestBody LessonTime time) {
		boolean result = false;
		try {
			if (time != null) {
				result = lessonTimeService.removeLessonTime(time);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public boolean updateLessonTime(@RequestBody LessonTime time) {
		boolean result = false;
		try {
			if (time != null) {
				result = lessonTimeService.updateLessonTime(time);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

}
