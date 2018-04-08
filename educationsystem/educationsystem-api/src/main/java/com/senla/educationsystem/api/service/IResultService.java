package com.senla.educationsystem.api.service;

import java.util.List;

import com.senla.educationsystem.model.bean.Result;

public interface IResultService {

	boolean addResult(Result result) throws Exception;

	boolean removeResult(Result result) throws Exception;

	boolean updateResult(Result result) throws Exception;

	List<Result> getAllResults() throws Exception;

	Result getResultById(Integer id) throws Exception;

	List<Result> getResultsByStudent(Integer studentId) throws Exception;

	List<Result> getResultsByCourse(Integer courseId) throws Exception;
}
