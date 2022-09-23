package byfayzullayev.startup.service;

import byfayzullayev.startup.entity.OptionEntity;
import byfayzullayev.startup.entity.Question;
import byfayzullayev.startup.entity.Quiz;

import java.util.Set;

public interface OptionService {
    public OptionEntity addOption(OptionEntity optionEntity );

    public OptionEntity updateOption(OptionEntity optionEntity );

    public Set<OptionEntity> getOptions();

    public OptionEntity getOption(Long id);

    public void deleteOption(Long id);

    public Set<OptionEntity> getOptionOfQuestion(Question question);
}
