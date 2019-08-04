package ch.nation.rest.utils;

import ch.nation.rest.clients.DBRestServiceBaseInterface;

public final class MessageUtils {

    public final static String getSelectedRestClientMessage(final Object object){

        return "Got client: "+object.getClass().getName();
    }

}
