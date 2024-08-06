package co.istad.forum.service;

import co.istad.forum.dto.AnswerResponse;

import java.util.List;

public interface AnswerService {
    List<AnswerResponse>findAll();
}
