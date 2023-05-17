const phoneInput = document.querySelector('input[name=cadastroPhone]');

phoneInput.addEventListener('input', (event) => {
	// Remove caracteres não numéricos
	let phone = event.target.value.replace(/\D/g, '');

	// Adiciona os parênteses e traço para formatar o número
	phone = phone.replace(/^(\d{2})(\d)/g, '($1) $2');
	phone = phone.replace(/(\d{5})(\d)/, '$1-$2');

	// Limita o tamanho máximo para 11 caracteres
	if (phone.length > 15) {
		phone = phone.slice(0, 15);
	}

	// Define o valor formatado para o input
	event.target.value = phone;
});

const idCodeInput = document.querySelector('input[name=inputIdCode]');

idCodeInput.addEventListener('input', (event) => {
	event.target.value = event.target.value.replace(/\D/g, '');
});

function validar() {
	let nomeValidar = formCadastro.cadastroNome.value
	let phoneValidar = formCadastro.cadastroPhone.value
	if (nomeValidar === "") {
		alert('Preencha o campo nome')
		formCadastro.cadastroNome.focus()
		return false
	} else if (phoneValidar === "") {
		alert('Preencha o campo telefone')
		formCadastro.cadastroPhone.focus()
		return false
	} else if (!/\(\d{2}\) \d{5}\-\d{4}/.test(phoneValidar)) {
		alert('Preencha o campo telefone no formato (DD) 99999-9999');
		formCadastro.cadastroPhone.focus();
		return false;
	} else {
		document.forms["formCadastro"].submit()
	}
}
