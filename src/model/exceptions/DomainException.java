package model.exceptions;
// extends Exception - obrigado a tratar a excecao
// extends RunTimeException - nao é obrigado a tratar
public class DomainException extends Exception {
    private static final long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }

}
