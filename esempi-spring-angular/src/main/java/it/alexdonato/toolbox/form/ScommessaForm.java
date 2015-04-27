/**
 * 
 */
package it.alexdonato.toolbox.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author alex
 *
 */
public class ScommessaForm {
	
	@NotNull
	private Integer scommessaId;

	private String Pilota; 
	
	public Integer getScommessaId() {
		return scommessaId;
	}
	public void setScommessaId(Integer scommessaId) {
		this.scommessaId = scommessaId;
	}
	public String getPilota() {
		return Pilota;
	}
	public void setPilota(String pilota) {
		Pilota = pilota;
	}

}
