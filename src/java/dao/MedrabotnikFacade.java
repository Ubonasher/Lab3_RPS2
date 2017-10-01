/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entitis.Medrabotnik;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import models.Medrab;

/**
 *
 * @author Григорий
 */
@Stateless
public class MedrabotnikFacade extends AbstractFacade<Medrabotnik> {

    @Resource
    SessionContext context;

    @PersistenceContext(unitName = "EJBModuleLab3JavaEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedrabotnikFacade() {
        super(Medrabotnik.class);
    }

    public void abortTrans2(int i) {
        //Medrabotnik m = new Medrabotnik(String.valueOf(new Date(System.currentTimeMillis())));
        if (i == 0) {
        } else {
            find(10l);
        }
    }
}
