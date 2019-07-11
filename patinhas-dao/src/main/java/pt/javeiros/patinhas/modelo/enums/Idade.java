/**
 * 
 */
package pt.javeiros.patinhas.modelo.enums;

/**
 * @author cahangoa
 *
 */
public enum Idade {
	BEBE("Bebé"), JOVEM("Jovem"), ADULTO("Adulto"), SENIOR("énior");
	
	
    private String idade;
    
    private Idade(String idade) {
        this.idade = idade;
    }
 
    public String getIdade() {
        return idade;
    }
}
