package ru.javawebinar.topjava.matcher;

import org.junit.Assert;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Александр on 2017-04-26.
 */
public class ModelMatcher<T, R> {
    protected Function<T,R> entityConverter;

    public ModelMatcher(Function<T, R> entityConverter) {
        this.entityConverter = entityConverter;
    }

    public void assertEquals(T expexted, T actuals){
        Assert.assertEquals(entityConverter.apply(expexted), entityConverter.apply(actuals));
    }

    public void assertCollectionEquals(Collection<T> expected, Collection<T> actuals){
        Assert.assertEquals(map(expected, entityConverter), map(actuals, entityConverter));
    }

    public static <S,T>Collection<T> map (Collection<S> collection, Function<S,T> converter){
        return collection.stream().map(converter).collect(Collectors.toList());
    }
}
