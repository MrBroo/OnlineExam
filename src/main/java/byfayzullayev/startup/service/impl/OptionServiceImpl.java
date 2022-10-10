package byfayzullayev.startup.service.impl;

import byfayzullayev.startup.Repository.OptionRepository;
import byfayzullayev.startup.entity.questions.OptionEntity;
import byfayzullayev.startup.entity.questions.QuestionEntity;
import byfayzullayev.startup.service.OptionService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public OptionEntity addOption(OptionEntity optionEntity ) {
        return optionRepository.save(optionEntity);
    }

    @Override
    public OptionEntity updateOption(OptionEntity optionEntity) {
        return optionRepository.save(optionEntity);
    }

    @Override
    public Set<OptionEntity> getOptions() {
        return new LinkedHashSet<>(optionRepository.findAll());
    }

    @Override
    public OptionEntity getOption(Long id) {
        return optionRepository.findById(id).get();
    }

    @Override
    public void deleteOption(Long id) {
        OptionEntity optionEntity = new OptionEntity();
        optionEntity.setId(id);
        optionRepository.delete(optionEntity);

    }

    @Override
    public Set<OptionEntity> getOptionOfQuestion(QuestionEntity question) {
        return optionRepository.findByQuestion(question);
    }
}
