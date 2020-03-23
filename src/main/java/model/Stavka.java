/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


/**
 *
 * @author Grbeš
 */
@Entity
public class Stavka extends Entitet{
    @ManyToOne
    private Pice pice;
    @ManyToMany
    private List<Racun>racuni=new ArrayList<>();

    public Pice getPice() {
        return pice;
    }

    public void setPice(Pice pice) {
        this.pice = pice;
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(List<Racun> racuni) {
        this.racuni = racuni;
    }
    
}
