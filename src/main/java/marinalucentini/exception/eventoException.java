package marinalucentini.exception;

import java.util.UUID;

public class eventoException extends RuntimeException {
    public eventoException(UUID id) {

        super("L'evento con id " + id + " non è stato trovato");
    }
}
