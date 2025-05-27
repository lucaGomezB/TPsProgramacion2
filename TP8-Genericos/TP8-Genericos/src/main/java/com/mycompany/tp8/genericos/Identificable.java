package com.mycompany.tp8.genericos;

/**
 *
 * @author Skywalker
 */
public interface Identificable<K> {
    public K getID();
    public boolean tieneMismoID(K id);
}
