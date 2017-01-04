package app.parser.modelParser;

import org.modelmapper.PropertyMap;

import java.util.List;

/**
 * Created by Admin on 8.12.2016 г..
 */
public interface ModelParser {

    <S,D> D convert(S source, Class<D> destination);

    <S,D> List<D> convert(List<S> source, Class<D> destination);

    <S,D> List<D> convert(List<S> source, Class<D> destination, PropertyMap<S, D> propertyMap);

    <S,D> D convert(S source, Class<D> destination, PropertyMap<S, D> propertyMap);
}
