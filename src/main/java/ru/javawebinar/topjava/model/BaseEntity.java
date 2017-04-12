package ru.javawebinar.topjava.model;

/**
 * Created by Александр on 2017-04-12.
 */
public class BaseEntity {

    protected Integer id;

    public BaseEntity() {
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }
}
