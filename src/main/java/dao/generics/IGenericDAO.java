package main.java.dao.generics;

import main.java.dao.Persistente;
import main.java.exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;
    public void excluir(E valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;
    public T consultar(E valor);
    public Collection<T> buscarTodos();
}
