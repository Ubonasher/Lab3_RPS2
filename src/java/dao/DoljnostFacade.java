/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entitis.Doljnost;

/**
 *
 * @author Григорий
 */
@Stateless
public class DoljnostFacade extends AbstractFacade<Doljnost> {

    @PersistenceContext(unitName = "EJBModuleLab3JavaEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DoljnostFacade() {
        super(Doljnost.class);
    }
    
}
