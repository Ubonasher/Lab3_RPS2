/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entitis.Otdelenie;

/**
 *
 * @author Григорий
 */
@Stateless
public class OtdelenieFacade extends AbstractFacade<Otdelenie> {

    @PersistenceContext(unitName = "EJBModuleLab3JavaEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OtdelenieFacade() {
        super(Otdelenie.class);
    }
    
}
