package app.parser.modelParser;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelParserImpl implements ModelParser {

    private ModelMapper modelMapper;

    public ModelParserImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public <S,D> D convert(S source, Class<D> destination){
        D convertedObject = this.modelMapper.map(source, destination);
        return convertedObject;
    }

    @Override
    public <S,D> List<D> convert(List<S> source, Class<D> destination){
        List<D> convertedList = new ArrayList<D>();
        for (S s : source) {
            D convertedType = this.modelMapper.map(s, destination);
            convertedList.add(convertedType);
        }

        return convertedList;
    }

    @Override
    public <S,D> List<D> convert(List<S> source, Class<D> destination, PropertyMap<S, D> propertyMap){
        this.modelMapper.addMappings(propertyMap);
        List<D> convertedList = new ArrayList<D>();
        for (S s : source) {
            D convertedType = this.modelMapper.map(s, destination);
            convertedList.add(convertedType);
        }

        return convertedList;
    }

    @Override
    public <S,D> D convert(S source, Class<D> destination, PropertyMap<S, D> propertyMap){
        this.modelMapper.addMappings(propertyMap);
        D convertedObject = this.modelMapper.map(source, destination);
        return convertedObject;
    }
}
