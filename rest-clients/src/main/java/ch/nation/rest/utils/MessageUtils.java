package ch.nation.rest.utils;

import ch.nation.core.model.dto.AbstractDto;
import ch.nation.rest.clients.DBRestServiceBaseInterface;

public final class MessageUtils {

    public final static String getSelectedRestClientMessage(final DBRestServiceBaseInterface object){

        return "Got client: "+object.getClass().getName();
    }

}
