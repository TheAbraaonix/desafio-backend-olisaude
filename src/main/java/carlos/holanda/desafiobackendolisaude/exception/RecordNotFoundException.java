package carlos.holanda.desafiobackendolisaude.exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(Long id) {
        super("The register of id " + id + " does not exist.");
    }
}
