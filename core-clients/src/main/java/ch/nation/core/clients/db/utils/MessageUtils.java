package ch.nation.core.clients.db.utils;

public final class MessageUtils {

    public final static String getSelectedRestClientMessage(final Object object) {

        return "Got client: " + object.getClass().getName();
    }

}
