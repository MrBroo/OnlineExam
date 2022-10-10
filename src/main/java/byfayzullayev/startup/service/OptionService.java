package byfayzullayev.startup.service;

import byfayzullayev.startup.entity.questions.OptionEntity;
import byfayzullayev.startup.entity.questions.QuestionEntity;

import java.util.Set;

public interface OptionService {
    public OptionEntity addOption(OptionEntity optionEntity );

    public OptionEntity updateOption(OptionEntity optionEntity );

    public Set<OptionEntity> getOptions();

    public OptionEntity getOption(Long id);

    public void deleteOption(Long id);

    public Set<OptionEntity> getOptionOfQuestion(QuestionEntity question);
}
