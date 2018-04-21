/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintproject.model;

import paintproject.model.AbstractShape;

/**
 *
 * @author dell-pc
 */
public class Originator {

    private AbstractShape abs;

    public void set(AbstractShape abs) {

        this.abs = abs;
    }

    public Memento storeInMemento() {
        return new Memento(abs);

    }

    public AbstractShape restoreFromMemento(Memento memento) {

        abs = memento.getState();
        return abs;

    }

}
