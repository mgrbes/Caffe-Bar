/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Stavka;
import util.EdunovaException;

/**
 *
 * @author marko
 */
public class ObradaStavka extends Obrada<Stavka>{

    @Override
    protected void kontrolaCreate() throws EdunovaException {
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
    }

    @Override
    public List<Stavka> getPodaci() {
        return session.createQuery("from Stavka").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
    }
    
}