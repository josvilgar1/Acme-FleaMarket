/*
 * AbstractDeleteService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.framework.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.UserRole;
import acme.framework.helpers.StringHelper;

@Service
public interface AbstractDeleteService<R extends UserRole, E> extends //
	AbstractService<R, E>, //
	AuthoriseMethod<R, E>, //
	BindMethod<R, E>, UnbindMethod<R, E>, //
	FindOneMethod<R, E>, //
	ValidateMethod<R, E>, //
	DeleteMethod<R, E>, //
	OnSuccessMethod<R, E>, OnFailureMethod<R, E> {

	@Override
	boolean authorise(final Request<E> request);

	@Override
	void bind(Request<E> request, final E entity, final Errors errors);

	@Override
	void unbind(Request<E> request, final E entity, final Model model);

	@Override
	E findOne(Request<E> request);

	@Override
	void validate(final Request<E> request, final E entity, Errors errors);

	@Override
	void delete(final Request<E> request, final E entity);

	@Override
	default void onSuccess(final Request<E> request, final Response<E> response) {
	}

	@Override
	default void onFailure(final Request<E> request, final Response<E> response, final Throwable oops) {
	}

	/**
	 * Maps the entity attributes to the request model.
	 * Relationships are not mapped
	 *
	 * @param request Request
	 * @param entity Entity
	 * @param includedProperties Hashtable
	 */
	default void toMapAttributes(Request<E> request, E entity, Hashtable<String, Object> includedProperties) {
		List<Method> methods = Arrays.asList(entity.getClass().getMethods())
			.stream()
			.filter(m -> m.getName().contains("get"))
			.collect(Collectors.toList());
		int count = methods.size();
		for (; count > 0; count--)
			try {
				if (methods.get(count - 1).getName().equals("getClass"))
					continue;
				String attribute = methods.get(count - 1).getName().substring(3);
				char[] c = attribute.toCharArray();
				c[0] = Character.toLowerCase(c[0]);
				Class<?> returnType = methods.get(count - 1).getReturnType();
				if (!returnType.getName().contains("acme.entities."))
					request.getModel().setAttribute(new String(c), methods.get(count - 1).invoke(entity));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		
		if (includedProperties != null)
			includedProperties.forEach((k,v) -> {
				request.getModel().setAttribute(k, v);
			});
	}

}
