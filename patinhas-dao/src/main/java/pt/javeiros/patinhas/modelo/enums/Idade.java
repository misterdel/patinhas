/**
 * 
 */
package pt.javeiros.patinhas.modelo.enums;

/**
 * @author cahangoa
 *
 */
public enum Idade {
	BEBE("Beb�"), JOVEM("Jovem"), ADULTO("Adulto"), SENIOR("�nior");
	
	
    private String idade;
    
    private Idade(String idade) {
        this.idade = idade;
    }
 
    public String getIdade() {
        return idade;
    }
}
