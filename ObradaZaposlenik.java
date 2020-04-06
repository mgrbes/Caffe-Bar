/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Zaposlenik;
import util.EdunovaException;
import util.Pomocno;

/**
 *
 * @author marko
 */
public class ObradaZaposlenik extends ObradaOsoba<Zaposlenik>{

    public ObradaZaposlenik(Zaposlenik entitet) {
        super(entitet);
    }

    public ObradaZaposlenik() {
        super();
    }

    
    
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
       super.kontrolaCreate();
       kontrolaBrojUgovora();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
    
    
    private void kontrolaBrojUgovora() throws EdunovaException{
        
    }

    @Override
    public List<Zaposlenik> getPodaci() {
        return session.createQuery("from Zaposlenik").list();
    }
    
    public List<Zaposlenik> getPodaci(String uvjet){
        return session.createQuery("from Zaposlenik z "
                + " where concat(z.ime, ' ', z.prezime) like :uvjet "
                + " or concat(z.prezime, ' ', z.ime) like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(20).list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
        
    }
    
     

    
    
}
