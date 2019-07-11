/**
 * 
 */
package pt.javeiros.patinhas.modelo.enums;

/**
 * @author cahangoa
 *
 */
public enum Porte {
	PEQUENO("Pequeno"), MEDIO("Médio"), GRANDE("Grande"),MUITO_GRANDE("Muito Grande");

    private String porte;
    
    private Porte(String porte) {
        this.porte = porte;
    }
 
    public String getIdade() {
        return porte;
    }
}
