package dao;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Date;
import entitis.Medrabotnik;
import java.util.Random;
import models.Medrab;
import util.MedrabFacade;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ExperimentBean {

    @EJB
    MedrabFacade bd1Fasade;
    @EJB
    MedrabotnikFacade bd2Fasade;
    @Resource
    SessionContext context;

    Random r = new Random();

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String firstExperiment() {
        Medrabotnik m2 = bd2Fasade.find(0);
        setDRm1(m2);
        if (!context.getRollbackOnly()) {
            return String.valueOf(bd1Fasade.find(Long.valueOf(0)).getDr());
        } else {
            return "Неудача";
        }
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void setDRm1(Medrabotnik m2) {
        Medrab m1 = bd1Fasade.find(Long.valueOf(0));
        m1.setDr(m2.getDatarojdenia());
        bd1Fasade.edit(m1);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String secondExperiment() {
        Medrabotnik m2 = bd2Fasade.find(1);
        setFIOm1(m2);
        if (context.getRollbackOnly()) {
            return "Rollback состоялся";
        } else {
            return "Rollback не было";
        }
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void setFIOm1(Medrabotnik m2) {
        Medrab m1 = bd1Fasade.find((long) r.nextInt(2));
        String temp = m1.getFio();
        m1.setFio(m2.getFio());
        m2.setFio(temp);
        bd1Fasade.edit(m1);
        bd2Fasade.edit(m2);
        bd1Fasade.abortTrans(m1);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String thirdExperiment() {
        try {
            Medrab m1 = bd1Fasade.find(2l);
            Medrabotnik m2 = bd2Fasade.find(2);
            String temp = m1.getFio();
            m1.setFio(m2.getFio());
            m2.setFio(temp);
            bd1Fasade.edit(m1);
            bd2Fasade.edit(m2);
            bd2Fasade.abortTrans2(r.nextInt(2));
        } catch (EJBException e) {
            return "Транзакция закончена откатом : " + e;
        }
        return "EJBException не передан";
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String fourthExperiment() {
        Medrab m1 = bd1Fasade.find(3l);
        m1.setFio(String.valueOf(new Date(System.currentTimeMillis())));
        bd1Fasade.edit(m1);

        forfourthExperiment();

        if (context.getRollbackOnly()) {
            return "Rollback состоялся";
        } else {
            return "Rollback не состоялся";
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void forfourthExperiment() {
        try {
            Medrabotnik m2 = bd2Fasade.find(3);
            m2.setFio(String.valueOf(new Date(System.currentTimeMillis())));
            bd2Fasade.edit(m2);
            context.setRollbackOnly();
        } catch (EJBException e) {

        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String fifthExperiment() {
        try {
            Medrabotnik m2 = bd2Fasade.find(4);
            m2.setFio(String.valueOf(new Date(System.currentTimeMillis())));
            newTransact();
            bd2Fasade.edit(m2);
            bd2Fasade.abortTrans2(r.nextInt(2));

        } catch (EJBException e) {
            return "Транзакция закончена откатом : " + e;
        }
        return "EJBException не передан";
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void newTransact() {
        Medrab m1 = bd1Fasade.find(4l);
        m1.setFio(String.valueOf(new Date(System.currentTimeMillis())));
        bd1Fasade.edit(m1);
    }

}
