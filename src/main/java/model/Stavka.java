/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 *
 * @author Grbeš
 */
@Entity
public class Stavka extends Entitet{
    @ManyToOne
    private Pice pice;
    

    public Pice getPice() {
        return pice;
    }

    public void setPice(Pice pice) {
        this.pice = pice;
    }

   

    
    
}
