/**
 * Confirmação de exclusão de um contato.
 * @author Luis Gabriel Goés
 */

 function confirmar(idCode){
	 let resposta = confirm("Você realmente deseja apagar este contato?")
	 if(resposta === true){
		window.location.href = "delete?idCode=" + idCode
	 }
 }