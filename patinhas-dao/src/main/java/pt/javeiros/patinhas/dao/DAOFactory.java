package pt.javeiros.patinhas.dao;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import pt.javeiros.patinhas.dao.interfaces.DAO;

import java.lang.reflect.ParameterizedType;


public class DAOFactory {
	    @Inject
	    private EntityManager em;

	    @SuppressWarnings({"rawtypes","unchecked"})
	    @Produces
	    @Dependent
	    public <T> DAO<T> createDAO(InjectionPoint point){
	        ParameterizedType type=(ParameterizedType)point.getType();
	        Class classe = (Class) type.getActualTypeArguments()[0];
	        return new DAOImpl<T>(classe,em);
	    }
}
